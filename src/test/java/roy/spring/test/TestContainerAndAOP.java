package roy.spring.test;

import io.roy.spring.plugins.register.entry.IndexDao;
import io.roy.spring.plugins.register.config.AopConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * description： 测试容器和AOP
 * author：dingyawu
 * date：created in 15:24 2020/9/10
 * history:
 */
public class TestContainerAndAOP {
    @Test
    public void  test(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AopConfig.class);
        ac.start();
        IndexDao bean = ac.getBean(IndexDao.class);
        bean.query();
    }
}
