package io.roy.spring.plugins.register.bean.myBean;

import io.roy.spring.plugins.register.bean.myBean.dao.OrderMapper;
import io.roy.spring.plugins.register.bean.myBean.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * description：
 * author：dingyawu
 * date：created in 19:21 2020/9/26
 * history:
 */
@Component
public class UserService {

    @Autowired
    private UserMapper userMapper;//mybatis代理对象

    @Autowired
    private OrderMapper orderMapper;

    public void test(){
        System.out.println(userMapper);
        userMapper.selectById(1);
        orderMapper.selectById(1);
    }
}
