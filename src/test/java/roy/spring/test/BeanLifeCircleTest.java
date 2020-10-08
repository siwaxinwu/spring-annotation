package roy.spring.test;

import io.roy.spring.plugins.register.bean.Animal;
import io.roy.spring.plugins.register.bean.Student;
import io.roy.spring.plugins.register.config.AnimalConfig;
import io.roy.spring.plugins.register.config.LifeCircleConfig1;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * description：测试bean的生命周期
 * author：dingyawu
 * date：created in 16:48 2020/7/28
 * history:
 */
public class BeanLifeCircleTest {
    /**
     * 测试bean的初始化和销毁方法
     */
    @Test
    public void test1(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(LifeCircleConfig1.class);
        System.out.println("ac establish end.....");
        Student student = ac.getBean(Student.class);
        ac.close();
    }

    /**
     * 原型的bean是不调用的他的销毁方法的,初始化方法还是会调用的
     */
    @Test
    public void test2(){
        //创建IOC容器
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AnimalConfig.class);
        String[] names = ac.getBeanDefinitionNames();
        Arrays.stream(names).forEach(System.out::println);
        System.out.println("--------------------------------");
        Animal animal = ac.getBean("animal", Animal.class);
        System.out.println(animal);
        //关闭IOC容器
        ac.close();
    }


    /**
     *构造方法 -> @PostConstruct -> init()方法 -> @PreDestroy -> destroy()方法。
     * @PostConstruct注解是Java中的注解，并不是Spring提供的注解。
     * @PostConstruct注解被用来修饰一个非静态的void()方法。被@PostConstruct修饰的方法会在服务器加载Servlet的时候运行，
     * 并且只会被服务器执行一次。PostConstruct在构造函数之后执行，init()方法之前执行。
     * 被@PreDestroy修饰的方法会在服务器卸载Servlet的时候运行，并且只会被服务器调用一次，类似于Servlet的destroy()方法。被@PreDestroy修饰的方法会在destroy()
     * 方法之后运行，在Servlet被彻底卸载之前。执行顺序如下所示。
     *
     * 调用destroy()方法->@PreDestroy->destroy()方法->bean销毁。
     *
     * 总结：@PostConstruct，@PreDestroy是Java规范JSR-250引入的注解，定义了对象的创建和销毁工作，
     * 同一期规范中还有注解@Resource，Spring也支持了这些注解。
     *
     * 在Spring中，@PostConstruct，@PreDestroy注解的解析是通过BeanPostProcessor实现的，
     * 具体的解析类是org.springframework.context.annotation.CommonAnnotationBeanPostProcessor，其父类是org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor，
     * Spring官方说明了该类对JSR-250中@PostConstruct，@PreDestroy，@Resource注解的支持。
     */
    @Test
    public void test3(){
        //创建IOC容器
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AnimalConfig.class);
        ac.close();
    }
}
