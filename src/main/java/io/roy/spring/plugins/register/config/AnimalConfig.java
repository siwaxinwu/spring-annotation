package io.roy.spring.plugins.register.config;

import io.roy.spring.plugins.register.bean.Animal;
import io.roy.spring.plugins.register.bean.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * description：  测试InitializingBean接口和DisposableBean接口
 * 原型的bean是不调用的他的销毁方法的,初始化方法还是会调用的
 *
 * author：dingyawu
 * date：created in 9:37 2020/9/29
 * history:
 */
@Configuration
public class AnimalConfig {

    @Bean
    @Scope("prototype")
    public Animal animal(){
        return new Animal();
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Cat cat(){
        return new Cat();
    }
}
