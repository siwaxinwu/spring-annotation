package io.roy.spring.plugins.register.service;

import io.roy.spring.plugins.register.bean.myBean.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * description：
 * author：dingyawu
 * date：created in 19:53 2020/9/28
 * history:
 */
public class UserService {
    /*注入的就是Mapper代理对象,被spring管理的对象才能被注入,那如何让userMapper
    这个代理对象注入spring*/
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private User22 user22;

    public void test(){
        userMapper.selectById(1);
    }
}
