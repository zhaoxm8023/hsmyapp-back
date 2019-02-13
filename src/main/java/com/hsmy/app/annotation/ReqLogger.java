package com.hsmy.app.annotation;

import java.lang.annotation.*;

/**
 * 请求日志注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ReqLogger {
    String value() default "";
}
