package io.roy.spring.plugins.register.config;

import io.roy.spring.plugins.register.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * description：
 * author：dingyawu
 * date：created in 21:07 2020/8/5
 * history:
 */
@Configuration
public class PersonConfig23 {

    @Bean("person")
    @Scope("prototype")
    public Person person(){
        System.out.println("给容器中添加Person....");
        return new Person("roy", 23);
    }
}
