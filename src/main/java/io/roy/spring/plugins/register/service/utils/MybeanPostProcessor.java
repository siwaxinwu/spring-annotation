package io.roy.spring.plugins.register.service.utils;

import io.roy.spring.plugins.register.service.AService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * description：
 * author：dingyawu
 * date：created in 19:55 2020/9/27
 * history:
 */
@Component
public class MybeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("AService")){
            System.out.println("bean = " + bean);
            //报错的原因：注入BService的bean的aService跟你放到单例池里面的aService不是同一个对象。没有循环依赖就不会报错
//            AService aService = new AService();
//            return aService;
        }
        return bean;
    }
}
