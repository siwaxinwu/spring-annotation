package roy.spring.test;

import io.roy.spring.plugins.register.config.APPConfig;
import io.roy.spring.plugins.register.config.AopConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * description：Bean：被spring管理的对象叫做bean
 * Bean的生命周期
 * 扫描类 ——> BeanDefinition ——> new A()——>A填充属性——> Aware、init——>
 * BeanPostProcessor （Bean的后置处理器，对前面生成的bean进行加工）——>
 * 单例池 （SingletonObjects, * 会在beanpostProcessor的后置过滤器重写方法中进行AOP，postProcessAfterInitialization（）返回代理对象  beanName:bean对象）——>
 *
 * 创建一个原始对象他会放到singletonFactory中,singletonFactory.put(beanName, ObjectFactory),三级缓存
 *
 *
 * 创建一个原始对象存入singletonFactory.put(beanName,ObjectFactory)  ObjectFactory = () -> getEarlyBeanReference(beanName, mbd, bean原始对象)
 * B在创建的过程中，需要注入A，去singletonFactory中拿到这人个lambda表达式，执行它返回AOP代理对象，
 * 就是Aservice的AOP代理对象（提前生成），
 *  getSigleton（AService aService）方法里执行表达式的逻辑，提前生成代理对象，会放到earlySingletonObject中，在singletonFactory中删除
 *  earlySingletonObject.put(beanName,singletonObject),
 *  singletonfactory.remove(beanName)
 *  执行这个lambda表达式的时候会把初始化的原始对象A放到earlyProxyReferences这个map中
 *  在执行beanpostProcessor的实现类的重写方法postProcessAfterInitialization（）的时候，返回AOP对象之前
 *  去拿这个原始对象和你传进来的bean做对比，相等就不会做AOP，直接返回原始对象
 *  普通的情况下不相等，就会去执行AOP,返回代理对象
 *
 *  三级缓存SingletonFactory中找到lambda表达式----执行lambda表达式---------返回AService的AOP代理对象，
 *  并且把AOP代理对象放到二级缓存EarlySingletonFactory中
 *
 *  一级缓存：单例池
 *  为什么需要三级缓存：singletonFactory存的是lambda表达式，存的时候并没有执行，而是在你产生循环依赖的时候才会去执行
 *  lambda表达式，
 *  如果没有循环依赖的话，三级缓存里面的lamda表达式是不会执行的，如果lambda表达式不执行，二级缓存earlySingletonObjects
 *  中就没有值，经过BeanpostFactory的后置处理器以后生成AOP对象，在从二级缓存里面拿就是空的，直接返回AOP对象放入单例池
 *
 * author：dingyawu
 * date：created in 21:15 2020/9/26
 * history:
 */
public class TestCircleDepends {
    @Test
    public void test(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(APPConfig.class);
        System.out.println(ac.getBean("AService"));
        System.out.println(ac.getBean("BService"));
    }
}
