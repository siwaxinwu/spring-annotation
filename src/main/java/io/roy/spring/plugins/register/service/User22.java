package io.roy.spring.plugins.register.service;

import org.aspectj.lang.annotation.After;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * description：两种初始化的方式
 *  属性赋值：拿bean的名字去单例池里面找，找到了就赋值给他
 *  AutowiredAnnotationBeanPostProcessor继承了InstantiationAwareBeanPostProcessorAdaptor就是这个后置处理器
 *  来实现依赖注入
 *  如何把自己创建的对象放入spring容器
 * @bean
 * @import
 * BeanFactoryPostProcessor：beanFactory.registerSingleton("xxx",new A())
 * FactoryBean的实现类
 *
 * FactoryBean和BeanFactory的区别
 * FactoryBean是一个bean接口，getBean（）的时候先去单例池里面找，找到了以后判断他有没有实现FactoryBean，有的话
 * 去FactoryBeanObjectCache这个map里面拿
 * mybatis整合spring的时候就是在FactoryBean的实现类中的方法getObject中生成代理类，然后返回代理对象
 * BeanFactory是个bean工厂，
 *
 * author：dingyawu
 * date：created in 19:58 2020/9/28
 * history:
 */
@Component
public class User22 implements InitializingBean, BeanNameAware, ApplicationContextAware, BeanPostProcessor {

    private String beanName;

    @Autowired
    private CService cService;

    @PostConstruct
    public void init(){
        System.out.println("一旦你实例化这个对象，这个方法就会执行");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("初始化方法");
    }

    //获取bean的id
    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    //获取bean工厂
    @Override
    public void setApplicationContext(ApplicationContext ac) throws BeansException {

    }

    //这两个方法就是初始化前后执行
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }
}
