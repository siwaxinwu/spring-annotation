package io.roy.spring.plugins.register.bean.myBean.processor;


import io.roy.spring.plugins.register.bean.AB;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * description：
 * author：dingyawu
 * date：created in 17:25 2020/9/26
 * history:
 */

public class MyFactoryBean implements FactoryBean {

    /**
     * 这个方法只会执行一次
     * @return
     * @throws Exception
     */
    @Override
    public Object getObject() throws Exception {
        return new AB();
    }

    @Override
    public Class<?> getObjectType() {
        return AB.class;
    }
}
