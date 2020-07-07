package com.fleet.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author April Han
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {

    /**
     * 操作方式（1：用户登录，2：用户操作，3：用户登出）
     */
    int type() default 2;

    /**
     * 信息
     */
    String value() default "";
}
