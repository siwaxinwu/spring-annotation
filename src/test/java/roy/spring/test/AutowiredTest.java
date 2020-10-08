package roy.spring.test;

import io.roy.spring.plugins.register.bean1.Professor;
import io.roy.spring.plugins.register.config.AutowiredConfig;
import io.roy.spring.plugins.register.dao.PersonDao;
import io.roy.spring.plugins.register.service.PersonService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.Arrays;

/**
 * description：@autowired注解的测试
 * @Autowired是spring专有注解，@Resource是java中JSR250中的规范，@Inject是java中JSR330中的规范
 * @Autowired支持参数required=false，@Resource，@Inject都不支持
 * @Autowired，和@Inject支持@Primary注解优先注入，@Resource不支持
 * @Autowired通过@Qualifier指定注入特定bean,@Resource可以通过参数name指定注入bean，@Inject需要@Named注解指定注入bean
 * author：dingyawu
 * date：created in 17:18 2020/9/28
 * history:
 */
public class AutowiredTest {

    @Test
    public void testAutowired01(){
        //创建IOC容器
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutowiredConfig.class);
        PersonService personService = ac.getBean(PersonService.class);
        System.out.println(personService);
        /*PersonDao personDao = ac.getBean(PersonDao.class);
        System.out.println(personDao);*/
        String[] names = ac.getBeanNamesForType(PersonDao.class);
        System.out.println("names = " + Arrays.toString(names));
        ac.close();
    }


    /**
     * 使用@Autowired注解标注在构造方法上时，构造方法中的参数对象也都是从IOC容器中获取的。
     * 无论Autowired注解标注在字段上、实例方法上、构造方法上还是参数上，都是从IOC容器中获取参数组件的值。
     * 如果Spring的bean只有一个有参构造方法，并且这个有参构造方法只有一个参数，并且这个参数是IOC容器中的对象，
     * 当@Autowired注解标注在这个构造方法的参数上时，我们可以将@Autowired注解省略。
     */
    @Test
    public void testAutowired03(){
        //创建IOC容器
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutowiredConfig.class);
        Professor professor = ac.getBean(Professor.class);
        System.out.println(professor.toString());
    }
}
