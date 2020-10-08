package io.roy.spring.plugins.register.service.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * description：
 * author：dingyawu
 * date：created in 19:51 2020/9/27
 * history:
 */
/*@Aspect
@Component*/
public class MyAspect {
    @Around("execution(* io.roy.spring.plugins.register.service.BService.test())")
    public void invoke(ProceedingJoinPoint pjt) throws Throwable {
        System.out.println("aop");
        pjt.proceed();
    }
}
