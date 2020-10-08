package roy.spring.test;

import io.roy.spring.plugins.register.bean.Person;
import io.roy.spring.plugins.register.bean.myBean.Cat2;
import io.roy.spring.plugins.register.bean.myBean.UserService;
import io.roy.spring.plugins.register.config.*;
import io.roy.spring.plugins.register.bean.myBean.processor.MyFactoryBean;
import io.roy.spring.plugins.register.service.User22;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.Map;

/**
 * description：
 * IOC：控制反转,将类的对象的创建交给Spring类管理创建。
 * DI：依赖注入,将类里面的属性在创建类的过程中给属性赋值。
 * DI和IOC的关系：DI不能单独存在,DI需要在IOC的基础上来完成。
 *
 * author：dingyawu
 * date：created in 18:39 2020/8/5
 * history:
 */
public class SpringBeanTest {

    /**
     * 根据xml文件来定义bean
     */
    @Test
    public void testXmlConfig(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Person person = (Person) context.getBean("person");
        System.out.println(person);
    }

    /**
     * 测试通过注解配置bean
     */
    @Test
    public void testAnnotationConfig(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PersonConfig22.class);
        Person person = ac.getBean(Person.class);
        System.out.println(person);
        System.out.println("--------------------------------");
        String[] names = ac.getBeanNamesForType(Person.class);
        Arrays.stream(names).forEach(System.out::println);
    }

    /**
     * 测试通过xml方式实行包扫描产生bean
     */
    @Test
    public void testComponentScanByXml(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("--------------------------------");
        String[] names = ac.getBeanDefinitionNames();
        Arrays.stream(names).forEach(System.out::println);
        int count = ac.getBeanDefinitionCount();
        System.out.println(count + "==" + names.length);
    }

    /**
     * 测试@componentScan的注解，以及生效和排除的几种情况
     * 自定义排除的情况，重点实现扫描的类里面只含有“Person字符串的类”
     * 但我configuration的类本身的bean和内部@bean修饰的方法不能校验，只能校验@componentScan的扫描类
     * 当使用includeFilters()指定只包含哪些组件时，需要禁用默认的过滤规则
     */
    @Test
    public void testComponentScanByAnnotation(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PersonConfig22.class);
        String[] names = ac.getBeanDefinitionNames();
        Arrays.stream(names).forEach(System.out::println);
        System.out.println(ac.getBeanDefinitionCount());
    }

    /**
     *  测试某个bean的懒加载
     *  利用FactoryBean接口的实现类来注入一个bean
     *  通过注解@conditional来控制该bean是否加载，实现condition接口，重写match方法
     */
    @Test
    public void test11(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(PersonConfig2.class);
        String[] names = ac.getBeanNamesForType(Person.class);
        Arrays.stream(names).forEach(System.out::println);

        System.out.println("-------------------------------------");
        System.out.println(ac.getBean("personFactoryBean"));
        Map<String, Person> beans = ac.getBeansOfType(Person.class);
        System.out.println(beans);

        System.out.println("-------------------------------------");
        Environment environment = ac.getEnvironment();
        String osName = environment.getProperty("os.name");
        System.out.println(osName);
    }

    /**
     * 拿到当前操作的系统
     */
    @Test
    public void test12(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PersonConfig2.class);
        ConfigurableEnvironment environment = ac.getEnvironment();
        System.out.println(environment.getProperty("os.name"));  //Windows 10
    }

    /**
     * 向Spring容器中注册bean通常有以下几种方式：
     * 包扫描+标注注解（@Controller、@Servcie、@Repository、@Component），通常用于自己写的类。
     * @Bean注解，通常用于导入第三方包中的组件。
     * @Import注解，快速向Spring容器中导入组件。
     *
     * @Import注解的使用方式
     * @Import注解的三种用法主要包括：
     * 直接填class数组方式
     * ImportSelector方式
     * ImportBeanDefinitionRegistrar方式
     */
    @Test
    public void test13(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PersonConfig11.class);
        String[] names = ac.getBeanDefinitionNames();
        //io.roy.spring.plugins.register.bean.Department 使用@import的时候，是全类名充当beannamedefinition的key
        Arrays.stream(names).forEach(System.out::println);
    }

    @Test
    public void test14() throws Exception {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PersonConfig2.class);
        String[] names = ac.getBeanDefinitionNames();
        Arrays.stream(names).forEach(System.out::println);
        System.out.println("------------------------");
        Person personFactoryBean = (Person)ac.getBean("personFactoryBean");
        System.out.println(personFactoryBean.getAge());
        System.out.println("personFactoryBean实例的类型为：" + personFactoryBean.getClass());
        System.out.println("------------------------");
        Object personFactoryBean1 = ac.getBean("personFactoryBean");
        System.out.println(personFactoryBean == personFactoryBean1);
        System.out.println("------------------------");
        Object bean = ac.getBean("&personFactoryBean");
        System.out.println("personFactoryBean实例的类型为：" + bean.getClass());

    }

    /**
     * 测试如何实现接口BeanNameAware获取bean的名字作为bean的属性
     * 狭义bean的生命周期：
     *      new A() ——填充属性 ——Aware（回调） ——初始化 ——AOP ——单例池 MAP（beanName， 对象）
     *
     * 广义的bean生命周期：
     * 扫描class —— 解析成BeanDefinition—— beanfactoryPostProcessor ——new A() ——填充属性 ——Aware（回调） ——初始化 ——AOP生成代理对象 ——单例池 MAP（beanName， 对象）
     * BeanDefinition里面有个重要的属性beanClass，他是基于Beadefinition里面的beanClass属性来实例化的，不是基于class，
     *
     * Beandefinition的属性：
     * constructArgumentValues：构造方法参数值，
     * scope：bean的作用范围
     * lazyInit：是否需要懒加载，
     * autowireMode：注入模型，
     * dependsOn：是否依赖了其他的bean
     * initMethodName：初始化方法的名字，
     * beanClass：bean的类型
     *
     *把类上面的注解都解析出来，解析成BeanDefinition的属性，如果到这一步你把beanClass属性换掉，那就实例化你换掉的属性
     *
     * 常规创建bean：走bean的生命周期，
     * 非常规：走bean生命周期中的bean工厂后置处理器
     * 调用方法beanFactory.registerSingleton("xxx", new Cat());
     * 比如mybatis先利用jdk动态代理生成代理对象，再用这个方法就可以注入spring容器了
     *
     * 写一个FactoryBean的实现类注入进来，重写getObject（）方法，返回要得到的bean，但这个bean实例对应的beanName=myFactoryBean
     *
     *  spring容器构建实例的时候如何保证单例
     *  通过concurrentHashMap的key的唯一性，仅仅是通过名字
     *
     *  spring如何整合mybatis：
     *
     */
    @Test
    public void test15(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Test15Config.class);
        //System.out.println(ac.getBean("myFactoryBean"));
        UserService userService = ac.getBean("userService", UserService.class);
        userService.test();
    }

    @Test
    public void test16(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(APPConfig.class);
        User22 user22 = ac.getBean("user22", User22.class);

    }


}

