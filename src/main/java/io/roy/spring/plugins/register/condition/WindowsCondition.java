package io.roy.spring.plugins.register.condition;


import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * description：检测到当前操作系统为Windows，作为bean的注入条件
 * author：dingyawu
 * date：created in 16:00 2020/8/6
 * history:
 */
public class WindowsCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        /*ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        ClassLoader classLoader = context.getClassLoader();*/
        Environment environment = context.getEnvironment();
       /* BeanDefinitionRegistry registry = context.getRegistry();*/
        String property = environment.getProperty("os.name");
        return property.contains("Windows");
    }
}
