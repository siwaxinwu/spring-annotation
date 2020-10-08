package io.roy.spring.plugins.register.bean.myBean;

import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * description：
 * author：dingyawu
 * date：created in 16:09 2020/9/26
 * history:
 */
@Component
@Data
@EnableAspectJAutoProxy
@Scope("prototype")
public class Cat2 implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean {

    @Autowired
    private User11 user11;

    private String beanName;

    public Cat2(){
        System.out.println("Cat2类的构造方法...");
    }
    /**
     * spring会回调这个方法
     * 如何获取spring的beanName
     * @param beanName
     */
    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    /**
     * 获取创建它的工厂
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }

    /**
     * spring在创建这个bean的时候会调用这个方法，执行里面的业务逻辑
     * 个人理解就是初始化方法，类似于init（）方法
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {

    }
}

