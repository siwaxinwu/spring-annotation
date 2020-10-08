package io.roy.spring.plugins.register.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * description：
 * author：dingyawu
 * date：created in 21:13 2020/9/26
 * history:
 */
@Component
public class AService {
    /**
     * 在构造AService的bean的时候，属性赋值的时候就是从spring容器中获取BService的bean
     * aService填充属性的时候，会尝试去构造BService的bean
     * bService一定得是beanName；
     *
     * 会先去单例池里面寻找beanName为bService的bean，如果没有，对应spring而言，不会中断Aservice对象的创建，只会去构造一个bService
     * 构造bservice的时候也是拿不到Aservice的bean,去单例池里面也是找不到的
     * 实例化出来的是原始对象，里面的属性暂时是没有值的，放到map里面
     *
     * 但是最终放到单例池的是new出来的对象的代理对象，但是放到map里的是实例化的对象，并不是同一个
     */
    @Autowired
    private BService bService;

}
