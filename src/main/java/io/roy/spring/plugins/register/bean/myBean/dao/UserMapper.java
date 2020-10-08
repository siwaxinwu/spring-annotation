package io.roy.spring.plugins.register.bean.myBean.dao;

import org.apache.ibatis.annotations.Select;

/**
 * description：
 * author：dingyawu
 * date：created in 19:12 2020/9/26
 * history:
 */
public interface UserMapper {
    @Select("Select user")
    String selectById(Integer id);
}
