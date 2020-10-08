package io.roy.spring.plugins.register.springScan.spring;

import org.springframework.beans.BeansException;
import org.springframework.lang.Nullable;

/**
 * description：
 * author：dingyawu
 * date：created in 14:25 2020/9/30
 * history:
 */
public interface MyBeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName);

    public Object postProcessAfterInitialization(Object bean, String beanName);
}
