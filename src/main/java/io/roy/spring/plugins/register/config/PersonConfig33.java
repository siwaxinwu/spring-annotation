package io.roy.spring.plugins.register.config;

import io.roy.spring.plugins.register.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * description：
 * author：dingyawu
 * date：created in 21:25 2020/8/5
 * history:
 */
@Configuration
public class PersonConfig33 {

    @Scope("thread")
    @Bean("person")
    public Person person(){
        System.out.println("给容器中添加person....");
        return new Person("roy",29);
    }
}
