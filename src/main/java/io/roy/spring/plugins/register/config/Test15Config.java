package io.roy.spring.plugins.register.config;

import io.roy.spring.plugins.register.bean.myBean.annotation.RoyScan;
import io.roy.spring.plugins.register.bean.myBean.processor.MyBeanDefinitionRegister;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * description：@ComponentScan注解他会去扫描包里面所有带生成bean的注解，把他们解析成BeanDefinition放到BeanDefinitionMap
 * 里面，BeanDefinitionMap是bean工厂的一个map属性
 * 扫描完了仅仅是得到这个map，map里面存的是beanDefinition对象
 * 扫描完了，也就是bean工厂组件完毕，开始执行bean工厂后置处理器beanFactoryPostProcessor
 * 扫描完了仅仅得到的是BeanDefinitionMap,这个时候还没有实例化，仅仅能得到beanDefinition对象
 *当你得到了所有的Beandefinition对象以后，就代表BeanFactory组建完毕
 *
 * beanfactory对象里面的属性：beanDefinitionMap（CocurrentHashMap）, singletonObjects(CocurrentHashMap单例池),
 * beanDefinitionNames（arraylist）
 * beanpostProcessor（copyonWriteProcessor） bean工厂里面三个重要的属性
 *
 * beanDefinition其实就是一个个bean类的模板
 *
 * @import导入的类是不需要作为bean注入的
 *
 * author：dingyawu
 * date：created in 12:02 2020/9/26
 * history:
 */
@Configuration
@ComponentScan("io.roy.spring.plugins.register.bean.myBean")
@Import(MyBeanDefinitionRegister.class)
@RoyScan("io.roy.spring.plugins.register.bean.myBean.dao")
public class Test15Config {
}
