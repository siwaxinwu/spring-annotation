package io.roy.spring.plugins.register.springScan.spring;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * description：
 * author：dingyawu
 * date：created in 7:36 2020/9/30
 * history:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface MyScope {
    String value() default "singleton";
}
