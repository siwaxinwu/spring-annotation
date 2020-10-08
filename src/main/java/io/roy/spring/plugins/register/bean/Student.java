package io.roy.spring.plugins.register.bean;

/**
 * description：测试bean的初始化和销毁方法
 * author：dingyawu
 * date：created in 13:13 2020/9/28
 * history:
 */
public class Student {

    public Student(){
        System.out.println("Student类的构造方法");
    }

    public void init(){
        System.out.println("初始化Student对象");
    }

    public void destroy(){
        System.out.println("销毁Student对象");
    }
}
