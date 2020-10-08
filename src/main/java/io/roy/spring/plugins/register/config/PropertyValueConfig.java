package io.roy.spring.plugins.register.config;

import io.roy.spring.plugins.register.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * description：测试属性赋值
 * author：dingyawu
 * date：created in 10:19 2020/9/29
 * history:
 */
@Configuration
@PropertySource("classpath:person.properties")
public class PropertyValueConfig {
    @Bean
    public Person person(){
        return new Person();
    }
}