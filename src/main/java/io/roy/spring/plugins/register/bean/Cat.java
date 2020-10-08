
package io.roy.spring.plugins.register.bean;

import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


/**
 * description：  测试InitializingBean接口和DisposableBean接口
 *
 *
 * author：dingyawu
 * date：created in 9:37 2020/9/29
 * history:
 */
@Component
@Data
public class Cat implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean {

    private String beanName;

    public Cat(){
        System.out.println("Cat类的构造方法...");
    }

    public void init(){
        System.out.println("Cat的init()方法...");
    }

    public void destroy(){
        System.out.println("Cat的destroy()方法...");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("Cat的postConstruct()方法...");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("Cat的preDestroy()方法...");
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
