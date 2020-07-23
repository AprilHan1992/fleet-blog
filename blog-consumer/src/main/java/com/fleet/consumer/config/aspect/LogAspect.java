package com.fleet.consumer.config.aspect;

import com.fleet.consumer.config.async.LogAsync;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;

@Aspect
@Component
public class LogAspect {

    ThreadLocal<Long> times = new ThreadLocal<>();

    @Resource
    private LogAsync logAsync;

    @Around("@annotation(com.fleet.common.annotation.Log)")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        times.set(System.currentTimeMillis());
        Object object = pjp.proceed();
        long millis = System.currentTimeMillis() - times.get();
        times.remove();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        RequestContextHolder.setRequestAttributes(servletRequestAttributes, true);
        logAsync.saveLog(pjp, millis, 1, null);
        return object;
    }

    @AfterThrowing(pointcut = "@annotation(com.fleet.common.annotation.Log)", throwing = "e")
    public void doAfterThrowing(JoinPoint jp, Throwable e) {
        long millis = System.currentTimeMillis() - times.get();
        times.remove();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        RequestContextHolder.setRequestAttributes(servletRequestAttributes, true);
        logAsync.saveLog((ProceedingJoinPoint) jp, millis, 0, e.getMessage());
    }
}
