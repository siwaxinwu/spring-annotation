package io.roy.spring.plugins.register.bean.myBean.processor;

import io.roy.spring.plugins.register.bean.myBean.annotation.RoyScan;
import io.roy.spring.plugins.register.bean.myBean.dao.OrderMapper;
import io.roy.spring.plugins.register.bean.myBean.dao.UserMapper;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * description：两种方式生成BD注册到BeandefinitionMap中
 * 1.@Import注解
 * 2.@componentScan注解扫描所有标注过@service的注解类
 * author：dingyawu
 * date：created in 19:52 2020/9/26
 * history:
 */
public class MyBeanDefinitionRegister implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
        //spring整合mybatis和dubbo
        Map<String, Object> annotationAttributes =
                importingClassMetadata.getAnnotationAttributes(RoyScan.class.getName());
        Object o = annotationAttributes.get("value");
        System.out.println(o);//包路径


        List<Class> mappers = new ArrayList<>();
        mappers.add(UserMapper.class);
        mappers.add(OrderMapper.class);

        for(Class mapper: mappers){
            BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition();
            AbstractBeanDefinition bd1 = builder.getBeanDefinition();
            bd1.setBeanClass(MyFactoryBean1.class);
            bd1.getConstructorArgumentValues().addGenericArgumentValue(mapper);
            registry.registerBeanDefinition(mapper.getSimpleName(),bd1);
        }
    }
}
