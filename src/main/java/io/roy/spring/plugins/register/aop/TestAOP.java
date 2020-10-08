package io.roy.spring.plugins.register.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * description：切面一定要交给spring的bean管理
 * author：dingyawu
 * date：created in 15:30 2020/9/10
 * history:
 */
@Component
@Aspect
public class TestAOP {
    @Pointcut("execution(* io.roy.spring.plugins.register.entry.*.*(..))")
    public void pointCut(){

    }

    @After("io.roy.spring.plugins.register.aop.TestAOP.pointCut()")
    public void after(){
        System.out.println("after");
    }

    @Before("io.roy.spring.plugins.register.aop.TestAOP.pointCut()")
    public void before(){
        System.out.println("before");
    }
}
