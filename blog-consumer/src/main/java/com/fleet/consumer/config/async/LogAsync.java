package com.fleet.consumer.config.async;

import com.fleet.common.entity.user.User;
import com.fleet.common.service.log.LogService;
import com.fleet.common.util.CurUser;
import com.fleet.common.util.IPUtil;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 日志记录
 *
 * @author April Han
 */
@Component
public class LogAsync {

    @Reference
    private LogService logService;

    /**
     * @Async 异步方法不要和同步调用方法写在同一个类中，否则注解时效
     */
    @Async
    public void saveLog(ProceedingJoinPoint pjp, long millis, Integer state, String error) {
        com.fleet.common.entity.log.Log opLog = new com.fleet.common.entity.log.Log();
        User user = CurUser.getUser();
        if (user != null) {
            opLog.setUserId(user.getId());
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
                // 获取登录用户输入用户名
                if (signature.getName().equals("login")) {
                    if (argNames[i].equals("name")) {
                        opLog.setName(argValues[i].toString());
                    }
                }
                paramList.add(argNames[i] + ": " + argValues[i]);
            }
        }
        opLog.setParam("{ " + StringUtils.join(paramList, ", ") + " }");

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
