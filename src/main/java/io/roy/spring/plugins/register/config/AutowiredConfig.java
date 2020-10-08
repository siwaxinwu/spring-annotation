package io.roy.spring.plugins.register.config;

import io.roy.spring.plugins.register.dao.PersonDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * description： @autowired注解配置类
 * author：dingyawu
 * date：created in 17:25 2020/9/28
 * history:
 */
@Configuration
@ComponentScan(value = {
        "io.roy.spring.plugins.register.service",
        "io.roy.spring.plugins.register.controller",
        "io.roy.spring.plugins.register.dao",
        "io.roy.spring.plugins.register.bean1"})
public class AutowiredConfig {

    //当采用@autowired注入的时候，同类型的bean优先匹配带有@primary注解的bean
    /*@Bean("personDao")
    @Primary*/
    public PersonDao personDao(){
        return new PersonDao("2");
    }
}
