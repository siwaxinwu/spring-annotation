package io.roy.spring.plugins.register.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * description： bean工厂创建完毕以后，就可以去生产对象了
 * ac并不等同于BeanFactory，ac只是继承了他，拥有了bean工厂的功能
 * 同时ac还继承了EnvironmentCapable：表示可以获取容器当前运行的环境
 * MseeageSource：表示可以用于国际化
 * ApplicationEventPublisher：表示拥有事件发布功能
 * ResourcePatternResolver：表示拥有加载资源文件功能
 *
 * author：dingyawu
 * date：created in 20:39 2020/9/28
 * history:
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("user22");
        Object user22 = beanFactory.getBean("user22");
        System.out.println("123");

    }
}
