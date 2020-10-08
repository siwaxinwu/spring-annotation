package io.roy.spring.plugins.register.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * description：检测到当前操作系统为Linux，作为bean的注入条件
 * author：dingyawu
 * date：created in 16:06 2020/8/6
 * history:
 */
public class LinuxCondition implements Condition{
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Environment environment = context.getEnvironment();
        String property = environment.getProperty("os.name");
        return property.contains("Linux");
    }
}
