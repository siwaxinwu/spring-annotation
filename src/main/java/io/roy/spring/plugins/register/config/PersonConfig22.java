package io.roy.spring.plugins.register.config;

import io.roy.spring.plugins.register.bean.Person;
import io.roy.spring.plugins.register.filter.MyTypeFilter;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * description： 测试通过注解@componentScan配置bean
 * includeFilters()方法表示Spring扫描的时候，只包含哪些注解，而excludeFilters()方法表示不包含哪些注解。
 * 两个方法的返回值都是Filter[]数组，在ComponentScan注解类的内部存在Filter注解
 * author：dingyawu
 * date：created in 18:41 2020/8/5
 * history:
 */

//@ComponentScan(value = "io.roy.spring")
/*@ComponentScan(value = "io.mykit.spring", excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class, Repository.class})
})*/

/*
@ComponentScan(value = "io.roy.spring", includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
}, useDefaultFilters = false)
*/

/*
@ComponentScan(value = "io.roy.spring", includeFilters = {
        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})
}, useDefaultFilters = false)
*/


@ComponentScans(value = {
        @ComponentScan(value = "io.roy.spring.plugins.register.bean1", includeFilters = {
                @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
        }, useDefaultFilters = false)
})
@Configuration
public class PersonConfig22 {
    @Bean("zidingyi")
    public Person person(){
        return new Person();
    }
}
