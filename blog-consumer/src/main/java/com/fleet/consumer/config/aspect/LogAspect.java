package com.fleet.consumer.config.aspect;

import com.fleet.common.entity.user.User;
import com.fleet.common.service.log.LogService;
import com.fleet.common.util.CurUser;
import com.fleet.common.util.IPUtil;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Aspect
@Component
public class LogAspect {

    ThreadLocal<Long> times = new ThreadLocal<>();

    @Reference
    private LogService logService;

    @Around("@annotation(com.fleet.common.annotation.Log)")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        times.set(System.currentTimeMillis());
        Object object = pjp.proceed();
        long millis = System.currentTimeMillis() - times.get();
        times.remove();
        try {
            saveLog(pjp, millis, 1, null);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return object;
    }

    @AfterThrowing(pointcut = "@annotation(com.fleet.common.annotation.Log)", throwing = "e")
    public void doAfterThrowing(JoinPoint jp, Throwable e) {
        long millis = System.currentTimeMillis() - times.get();
        times.remove();
        try {
            saveLog((ProceedingJoinPoint) jp, millis, 0, e.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void saveLog(ProceedingJoinPoint pjp, long millis, Integer state, String error) {
        com.fleet.common.entity.log.Log opLog = new com.fleet.common.entity.log.Log();
        User user = CurUser.getUser();
        if (user != null) {
            opLog.setId(user.getId());
            opLog.setName(user.getName());
        }

        // 获取request
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();

        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        com.fleet.common.annotation.Log log = method.getAnnotation(com.fleet.common.annotation.Log.class);
        if (log != null) {
            opLog.setType(log.type());
            opLog.setLog(log.value());
        }

        opLog.setUrl(request.getRequestURL().toString());
        opLog.setHttpMethod(request.getMethod());
        opLog.setMethod(signature.getDeclaringTypeName() + "." + signature.getName() + "()");

        // 参数名称
        String[] argNames = signature.getParameterNames();
        // 参数值
        Object[] argValues = pjp.getArgs();
        List<String> paramList = new ArrayList<>();
        if (argNames != null) {
            for (int i = 0; i < argNames.length; i++) {
                if (argNames[i].equals("pwd") || argNames[i].equals("oldPwd") || argNames[i].equals("newPwd")) {
                    argValues[i] = "密码不能明文显示";
                }
                // 获取登录用户输入账户
                if (signature.getName().equals("login")) {
                    if (argNames[i].equals("name")) {
                        opLog.setName(argValues[i].toString());
                    }
                }
                paramList.add(argNames[i] + ": " + argValues[i]);
            }
        }
        opLog.setParams("{ " + StringUtils.join(paramList, ", ") + " }");

        opLog.setIp(IPUtil.getIpAddr(request));

        String ua = request.getHeader("User-Agent");
        opLog.setAgent(ua);
        UserAgent userAgent = UserAgent.parseUserAgentString(ua);
        OperatingSystem os = userAgent.getOperatingSystem();
        opLog.setOs(os.getName());
        Browser browser = userAgent.getBrowser();
        opLog.setBrowser(browser.getName());

        opLog.setState(state);
        opLog.setError(error);

        opLog.setMillis(millis);
        opLog.setCreateTime(new Date());

        logService.insert(opLog);
    }
}
