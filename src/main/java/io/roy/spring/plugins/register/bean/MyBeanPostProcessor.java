package io.roy.spring.plugins.register.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/*
 * description：后置处理器：初始化前后进行处理工作
 * 将后置处理器加入到容器中
 * 在bean初始化前后进行一些处理工作；
 * postProcessBeforeInitialization:在初始化之前工作
 * postProcessAfterInitialization:在初始化之后工作
 * 也可以让实现Ordered接口自定义排序
 *
 * 后置处理器用于bean对象初始化前后进行逻辑增强。spring提供了BeanPostProcessor的很多实现类，
 * 例如AutowiredAnnotationBeanPostProcessor用于@Autowired注解的实现，
 * AnnotationAwareAspectJAutoProxyCreator用于SpringAOP的动态代理等等。
 *
 * author：dingyawu
 * date：created in 18:11 2020/7/28
 * history:
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor, Ordered {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        System.out.println("postProcessBeforeInitializating...." + beanName + ">" + bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitializating...." + beanName + ">" + bean);
        return bean;
    }

    @Override
    public int getOrder() {
        return 3;
    }
}
