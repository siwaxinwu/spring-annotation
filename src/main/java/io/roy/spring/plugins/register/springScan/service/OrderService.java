package io.roy.spring.plugins.register.springScan.service;

import io.roy.spring.plugins.register.springScan.spring.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * description：
 * author：dingyawu
 * date：created in 7:39 2020/9/30
 * history:
 */
@MyComponent("orderService")
@MyScope
@Data
public class OrderService implements MyInitializingBean, MyBeanNameAware {

    private String beanName;
    @MyAutoWired
    private UserService userService;

    public void test(){
        System.out.println(userService);
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("OrderService execute afterPropertiesSet.....");
    }

    @Override
    public void setBeanName(String beanName) {
        System.out.println("OrderService   execute setBeanName ................");
        this.beanName = beanName;
    }
}
