package io.roy.spring.plugins.register.bean.myBean.processor;


import io.roy.spring.plugins.register.bean.AB;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * description：
 * author：dingyawu
 * date：created in 17:25 2020/9/26
 * history:
 */

public class MyFactoryBean1 implements FactoryBean {

    private Class mapper;

    public MyFactoryBean1(Class mapper){
        this.mapper = mapper;
    }


    @Override
    public Object getObject() throws Exception {
        Object proxy = Proxy.newProxyInstance(MyFactoryBean1.class.getClassLoader(),
                new Class[]{mapper}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println(method.getName());
                        return null;
                    }
                });
        return proxy;
    }

    @Override
    public Class<?> getObjectType() {
        return mapper;
    }
}
