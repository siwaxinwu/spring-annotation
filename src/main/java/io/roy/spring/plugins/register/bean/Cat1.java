package io.roy.spring.plugins.register.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * description：
 * author：dingyawu
 * date：created in 17:45 2020/7/28
 * history:
 */

public class Cat1 implements InitializingBean, DisposableBean {
    public Cat1(){
        System.out.println("cat1 constructor....");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("cat1 afterPropertiesSet.........");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("cat1 destroy.....");
    }
}
