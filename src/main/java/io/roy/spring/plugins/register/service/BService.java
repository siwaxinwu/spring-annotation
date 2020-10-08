package io.roy.spring.plugins.register.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * description：
 * author：dingyawu
 * date：created in 21:13 2020/9/26
 * history:
 */
@Component
public class BService {
    @Autowired
    private AService aService;

    public void test(){
        System.out.println(aService.getClass());
    }


}
