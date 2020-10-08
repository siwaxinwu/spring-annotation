package roy.spring.test;

import io.roy.spring.plugins.register.bean.Person;
import io.roy.spring.plugins.register.config.PropertyValueConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Arrays;

/**
 * description：IOC容器中除了Spring框架注册的bean之外，还包含我们自己向IOC容器中注册的bean组件
 *
 * author：dingyawu
 * date：created in 17:20 2020/7/28
 * history:
 */
public class PropertyValueTest {

    /**
     * @propertySource注解注入属性的测试
     * 使用environment获取属性
     */
    @Test
    public void test(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PropertyValueConfig.class);
        String[] names = ac.getBeanDefinitionNames();
        Arrays.stream(names).forEach(System.out::println);
        Person person = ac.getBean("person", Person.class);
        System.out.println(person);
        System.out.println("-----------------------");
        ConfigurableEnvironment environment = ac.getEnvironment();
        System.out.println(environment.getProperty("person.nickName"));

    }

    /**
     * 通过xml的配置读取外部文件进行配置
     */
    @Test
    public void test1(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        Person person = ac.getBean("person", Person.class);
        System.out.println(person);

    }

}
