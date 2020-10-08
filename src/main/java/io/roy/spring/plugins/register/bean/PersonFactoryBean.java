package io.roy.spring.plugins.register.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * description： 通过FactoryBean接口想Spring中注册一个bean
 * author：dingyawu
 * date：created in 19:34 2020/8/6
 * history:
 */
public class PersonFactoryBean implements FactoryBean<Person> {

    //返回一个Person对象，这个对象会被注册到Spring容器中
    @Override
    public Person getObject() throws Exception {
        return new Person();
    }

    @Override
    public Class<?> getObjectType() {
        return Person.class;
    }

    //bean是否为单例;true:是；false:否
    @Override
    public boolean isSingleton() {
        return true;
    }
}
