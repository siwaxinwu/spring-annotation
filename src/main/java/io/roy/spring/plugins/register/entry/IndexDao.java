package io.roy.spring.plugins.register.entry;

import org.springframework.stereotype.Component;

/**
 * description： 测试容器和AOP
 * author：dingyawu
 * date：created in 15:23 2020/9/10
 * history:
 */
@Component
public class IndexDao {
    public void query(){
        System.out.println("dao----query");
    }
}
