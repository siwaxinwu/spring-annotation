package roy.spring.test;

import com.sun.org.apache.bcel.internal.generic.NEW;
import io.roy.spring.plugins.register.bean.Person;
import io.roy.spring.plugins.register.config.PersonConfig23;
import io.roy.spring.plugins.register.config.PersonConfig33;
import io.roy.spring.plugins.register.scope.MyScope;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.TimeUnit;

/**
 * description：测试springbean的作用域
 *
 * 单实例bean注意的事项
 * 单例bean是整个应用共享的，所以需要考虑到线程安全问题，之前在玩springmvc的时候，springmvc中controller默认是单例的，有些开发者在controller
 * 中创建了一些变量，那么这些变量实际上就变成共享的了，controller可能会被很多线程同时访问，这些线程并发去修改controller中的共享变量，
 * 可能会出现数据错乱的问题；所以使用的时候需要特别注意。
 *
 * 多实例bean注意的事项
 * 多例bean每次获取的时候都会重新创建，如果这个bean比较复杂，创建时间比较长，会影响系统的性能，这个地方需要注意。
 *
 *
 * author：dingyawu
 * date：created in 21:10 2020/8/5
 * history:
 */
public class SpringScopeTest {
    /**
     * 测试bean的作用域，
     * scope的时候每次getBean的时候都得重新生成
     * 在创建Spring容器时，并不会实例化和加载多实例对象
     * 当对象的Scope作用域为多实例时，每次向Spring容器获取对象时，都会创建一个新的对象并返回。
     * 此时，获取到的bean和bean1就不是同一个对象了
     */
    @Test
    public void test1(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PersonConfig23.class);
        Person bean = ac.getBean(Person.class);
        Person bean1 = ac.getBean(Person.class);
        System.out.println(bean);
        System.out.println(bean == bean1);
    }

    /**
     * 测试自定义的scope
     */
    @Test
    public void test2(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PersonConfig33.class);
        ac.getBeanFactory().registerScope(MyScope.THREAD_SCOPE, new MyScope());
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread() + "," + ac.getBean(Person.class));
                System.out.println(Thread.currentThread() + "," + ac.getBean(Person.class));
            }).start();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
