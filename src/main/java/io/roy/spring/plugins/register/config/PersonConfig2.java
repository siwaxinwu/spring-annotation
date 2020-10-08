package io.roy.spring.plugins.register.config;

import io.roy.spring.plugins.register.bean.Person;
import io.roy.spring.plugins.register.bean.PersonFactoryBean;
import io.roy.spring.plugins.register.condition.LinuxCondition;
import io.roy.spring.plugins.register.condition.WindowsCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * description：
 * author：dingyawu
 * date：created in 15:35 2020/8/6
 * history:
 */
@Configuration
//@Conditional(LinuxCondition.class)
public class PersonConfig2 {
    @Lazy
    @Conditional(WindowsCondition.class)
    @Bean("person")
    public Person person(){
        System.out.println("给容器中添加Person....");
        return new Person("roy", 28);
    }

    @Bean("roy29")
    @Conditional(LinuxCondition.class)
    public Person person01(){
        return new Person("roy",29);
    }

    @Bean("roy30")
    public Person person02(){
        return new Person("roy", 30);
    }

    @Bean
    public PersonFactoryBean personFactoryBean(){
        return new PersonFactoryBean();
    }
}
