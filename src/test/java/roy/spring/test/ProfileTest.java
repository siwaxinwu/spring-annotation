package roy.spring.test;

import io.roy.spring.plugins.register.config.ProfileConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.util.stream.Stream;

/**
 * description：
 * author：dingyawu
 * date：created in 16:49 2020/9/28
 * history:
 */
public class ProfileTest {

    @Test
    public void testProfile01(){
        //创建IOC容器
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ProfileConfig.class);
        String[] names = ac.getBeanNamesForType(DataSource.class);
        Stream.of(names).forEach(System.out::println);
        System.out.println(ac.getBeanDefinitionCount());
    }

    @Test
    public void testProfile02(){
        //创建IOC容器
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.getEnvironment().setActiveProfiles("prod");
        ac.register(ProfileConfig.class);
        ac.refresh();
        String[] names = ac.getBeanNamesForType(DataSource.class);
        Stream.of(names).forEach(System.out::println);
    }
}
