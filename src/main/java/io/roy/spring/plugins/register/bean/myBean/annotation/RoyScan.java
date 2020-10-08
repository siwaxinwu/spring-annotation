package io.roy.spring.plugins.register.bean.myBean.annotation;

import io.roy.spring.plugins.register.bean.myBean.processor.MyBeanDefinitionRegister;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * description：用来扫描dao层的接口来依赖注入spring
 * author：dingyawu
 * date：created in 20:29 2020/9/26
 * history:
 */
@Retention(RetentionPolicy.RUNTIME)
@Import(MyBeanDefinitionRegister.class)
public @interface RoyScan {
    String value() default "";
}
