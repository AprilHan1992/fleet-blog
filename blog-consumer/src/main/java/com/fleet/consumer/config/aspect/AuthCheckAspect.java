package com.fleet.consumer.config.aspect;

import com.fleet.common.annotation.AuthCheck;
import com.fleet.common.entity.user.User;
import com.fleet.common.enums.ResultState;
import com.fleet.common.exception.BaseException;
import com.fleet.common.service.user.UserRoleService;
import com.fleet.common.util.CurUser;
import org.apache.dubbo.config.annotation.Reference;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author April Han
 */
@Aspect
@Component
public class AuthCheckAspect {

    @Reference
    private UserRoleService userRoleService;

    @Around("@annotation(com.fleet.common.annotation.AuthCheck)")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method method = methodSignature.getMethod();
        AuthCheck authCheck = method.getAnnotation(AuthCheck.class);

        User user = CurUser.getUser();
        if (user == null) {
            throw new BaseException(ResultState.ERROR);
        }

        Integer id = user.getId();
        String[] roles = authCheck.roles();
        if (roles.length != 0) {
            Boolean hasRoles = userRoleService.hasRoles(id, roles);
            if (!hasRoles) {
                throw new BaseException(ResultState.ERROR);
            }
        }

        String[] permits = authCheck.permits();
        if (permits.length != 0) {
            Boolean hasPermits = userRoleService.hasPermits(id, permits);
            if (!hasPermits) {
                throw new BaseException(ResultState.ERROR);
            }
        }

        try {
            return pjp.proceed();
        } catch (Exception e) {
            throw e;
        }
    }
}
