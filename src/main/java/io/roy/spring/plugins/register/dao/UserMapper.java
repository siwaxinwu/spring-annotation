package io.roy.spring.plugins.register.dao;

import org.apache.ibatis.annotations.Select;

/**
 * description：
 * author：dingyawu
 * date：created in 19:54 2020/9/28
 * history:
 */
public interface UserMapper {
    @Select("select user")
    String selectById(Integer id);
}
