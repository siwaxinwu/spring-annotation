package io.roy.spring.plugins.register.bean.myBean.processor;

import io.roy.spring.plugins.register.bean.Cat;
import io.roy.spring.plugins.register.bean.myBean.dao.OrderMapper;
import io.roy.spring.plugins.register.bean.myBean.dao.UserMapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * description：bean工厂后置处理器可以让程序员操作bean工厂
 *
 * author：dingyawu
 * date：created in 15:46 2020/9/26
 * history:
 */
@Component
public class MybeanPostProcessor1 implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        GenericBeanDefinition bd = (GenericBeanDefinition) beanFactory.getBeanDefinition("cat2");
        Class<?> beanClass = bd.getBeanClass();
        System.out.println("you" + beanClass);
        //创建bean，调用spring中的bean的生命周期创建bean
        beanFactory.getBean("cat2");
        //可以创建bean
        beanFactory.registerSingleton("xxx", new Cat());







    }
}
