package io.roy.spring.plugins.register.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * description：  测试InitializingBean接口和DisposableBean接口
 * author：dingyawu
 * date：created in 9:37 2020/9/29
 * history:
 */
@Component
public class Animal implements InitializingBean, DisposableBean {
    public Animal(){
        System.out.println("执行了Animal类的无参数构造方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行了Animal类的初始化方法。。。。。");

    }
    @Override
    public void destroy() throws Exception {
        System.out.println("执行了Animal类的销毁方法。。。。。");

    }
}