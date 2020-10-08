package io.roy.spring.plugins.register.condition;

import io.roy.spring.plugins.register.bean.Company;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * description：registerBeanDefinitions()方法的实现逻辑很简单，
 * 就是判断Spring容器中是否同时存在以employee命名的bean和以department命名的bean，
 * 如果同时存在以employee命名的bean和以department命名的bean，
 * 则向Spring容器中注入一个以company命名的bean。
 * author：dingyawu
 * date：created in 17:25 2020/8/6
 * history:
 */
public class MyImportBeanDefinitionRegister implements ImportBeanDefinitionRegistrar {
    /**
     * AnnotationMetadata: 当前类的注解信息
     * BeanDefinitionRegistry：BeanDefinition注册类
     * 通过调用BeanDefinitionRegistry接口的registerBeanDefinition()方法，可以将所有需要添加到容器中的bean注入到容器中。
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean employee = registry.containsBeanDefinition("employee");
        boolean department = registry.containsBeanDefinition("department");
        if (employee && department){
            BeanDefinition beanDefinition = new RootBeanDefinition(Company.class);
            registry.registerBeanDefinition("company", beanDefinition);
        }
    }

}
