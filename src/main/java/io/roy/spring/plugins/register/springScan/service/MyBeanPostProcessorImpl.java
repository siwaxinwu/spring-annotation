package io.roy.spring.plugins.register.springScan.service;

import io.roy.spring.plugins.register.springScan.spring.MyBeanPostProcessor;
import io.roy.spring.plugins.register.springScan.spring.MyComponent;

/**
 * description：
 * author：dingyawu
 * date：created in 14:28 2020/9/30
 * history:
 */
@MyComponent
public class MyBeanPostProcessorImpl implements MyBeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("初始化前....................");
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("初始化后..............");
        return null;
    }
}
