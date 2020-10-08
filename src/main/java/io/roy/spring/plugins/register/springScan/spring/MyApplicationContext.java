package io.roy.spring.plugins.register.springScan.spring;

import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.ComponentScan;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

/**
 * description：
 * author：dingyawu
 * date：created in 7:34 2020/9/30
 * history:
 */
public class MyApplicationContext {
    private ConcurrentHashMap<String,MyBeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String,Object> singletonObjects = new ConcurrentHashMap<>();
    private List<MyBeanPostProcessor> beanPostProcessorList = new ArrayList<>();
    public MyApplicationContext(Class configClass) throws Exception {
        List<Class> classList = scan(configClass);

        for (Class clazz : classList){
            if (clazz.isAnnotationPresent(MyComponent.class)) {
                MyBeanDefinition myBeanDefinition = new MyBeanDefinition();
                myBeanDefinition.setBeanClass(clazz);

                MyComponent component = (MyComponent) clazz.getAnnotation(MyComponent.class);
                String beanName = component.value();
                System.out.println("beanName = " + beanName);
                if (clazz.isAnnotationPresent(MyScope.class)) {
                    MyScope myScope = (MyScope) clazz.getAnnotation(MyScope.class);
                    myBeanDefinition.setScope(myScope.value());
                }else {
                    myBeanDefinition.setScope("singleton");
                }
                //是否实现BeanPostProcessor
                if (MyBeanPostProcessor.class.isAssignableFrom(clazz)){
                    MyBeanPostProcessor bpp = (MyBeanPostProcessor)clazz.getDeclaredConstructor().newInstance();
                    beanPostProcessorList.add(bpp);
                }

                beanDefinitionMap.put(beanName, myBeanDefinition);
            }
        }
        for (String beanName : beanDefinitionMap.keySet()){
            MyBeanDefinition myBeanDefinition = beanDefinitionMap.get(beanName);
            if ("singleton".equals(myBeanDefinition.getScope())){
                //实例化
                Object bean = createBean(beanName, myBeanDefinition);
                singletonObjects.put(beanName, bean);
            }
        }

    }

    /**
     * 根据beanDefinition创建bean实例,利用反射并且填充要注入的属性
     * @param myBeanDefinition
     * @throws Exception
     */
    private Object createBean( String beanName,MyBeanDefinition myBeanDefinition) throws Exception{
        Class beanClass = myBeanDefinition.getBeanClass();
        Object bean = beanClass.getDeclaredConstructor().newInstance();
        //判断哪些属性是需要填充的
        Field[] fields = beanClass.getDeclaredFields();
        for (Field field : fields){
            if (field.isAnnotationPresent(MyAutoWired.class)) {
                //存在@myAutowired属性,去单例池中获取
                Object object = getBean(field.getName());
                field.setAccessible(true);
                field.set(bean, object);
            }
        }
        //Aware
        if (bean instanceof MyBeanNameAware){
            ((MyBeanNameAware) bean).setBeanName(beanName);
        }

        //调用自定义的逻辑
        if (null != beanPostProcessorList) {
            for (MyBeanPostProcessor bpp : beanPostProcessorList){
                bpp.postProcessBeforeInitialization(bean, beanName);
            }
        }

        //初始化
        if (bean instanceof MyInitializingBean) {
            ((MyInitializingBean) bean).afterPropertiesSet();
        }

        //调用自定义的逻辑
        if (null != beanPostProcessorList) {
            for (MyBeanPostProcessor bpp : beanPostProcessorList){
                bpp.postProcessAfterInitialization(bean, beanName);
            }
        }
        return bean;
    }


    public Object getBean(String beanName) throws Exception {
        MyBeanDefinition myBeanDefinition = beanDefinitionMap.get(beanName);
        if ("prototype".equals(myBeanDefinition.getScope())){
            return createBean(beanName, myBeanDefinition);
        }else {
            Object bean = singletonObjects.get(beanName);
            if (null== bean){
                 bean = createBean(beanName, myBeanDefinition);
                 singletonObjects.put(beanName, bean);
            }
            return bean;
        }

    }

    /**
     * 扫描配置类上需要创建bean的Class
     * @param configClass   配置类的Class
     * @return  Class对象
     */
    private List<Class> scan(Class configClass) {

        ArrayList<Class> classList = new ArrayList<>();
        //扫描类，生成单例bean，放入单例池
        MyComponentScan myComponentScan = (MyComponentScan)configClass.getAnnotation(MyComponentScan.class);
        String scanPath = myComponentScan.value();
        System.out.println("扫描路径：" + scanPath);
        //如何扫描类，扫描到了类以后，如何解析这个类
        scanPath = scanPath.replace(".", "/");
        ClassLoader loader = MyApplicationContext.class.getClassLoader();
        URL resource = loader.getResource(scanPath);
        File file = new File(resource.getFile());//目录对象
        //指定的目录下的文件列表，可能是class，也有可能是txt
        File[] files = file.listFiles();
        for(File f: files){
            System.out.println(f);
            String absolutePath = f.getAbsolutePath();
            absolutePath = absolutePath.substring(absolutePath.indexOf("io\\roy"), absolutePath.indexOf(".class"));
            absolutePath= absolutePath.replace("\\", ".");

            try {
                Class<?> aClass = loader.loadClass(absolutePath);
                classList.add(aClass);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return classList;
    }
}
