package com.fleet.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author April Han
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthCheck {

    // 校验参数
    String[] params() default {};

    // 角色
    String[] roles() default {};

    // 权限项
    String[] permits() default {};
}
