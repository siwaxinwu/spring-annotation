package io.roy.spring.plugins.register.config;

import io.roy.spring.plugins.register.bean.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * 测试bean的初始化和销毁方法
 *
 *
 *  description：对于单实例bean对象来说，在Spring容器创建完成后，就会对单实例bean进行实例化
 * 总之：对于单实例bean来说，在Spring容器启动的时候创建对象；对于多实例bean来说，在每次获取bean的时候创建对象。
 *  bean的销毁方法是在容器关闭的时候调用的。
 *  bean对象的初始化方法调用的时机：对象创建完成，如果对象中存在一些属性，并且这些属性也都赋值好之后，
 *  会调用bean的初始化方法。对于单实例bean来说，在Spring容器创建完成后，Spring容器会自动调用bean的初始化和销毁方法；
 *  对于单实例bean来说，在每次获取bean对象的时候，调用bean的初始化和销毁方法。
 *
 *  bean对象的销毁方法调用的时机：对于单实例bean来说，在容器关闭的时候，会调用bean的销毁方法；对于多实例bean来说，
 *  Spring容器不会管理这个bean，也不会自动调用这个bean的销毁方法。不过，小伙伴们可以手动调用多实例bean的销毁方法。
 *
 *  将bean设置成多实例时，Spring不会自动调用bean对象的销毁方法。至于多实例bean对象何时销毁，那就是程序员自己的事情了！！
 *  Spring容器不再管理多实例bean。
 *
 * author：dingyawu
 * date：created in 16:54 2020/7/28
 * history:
 */
@Configuration
public class LifeCircleConfig1 {
    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    @Scope("prototype")
    public Student student(){
        return new Student();
    }
}
