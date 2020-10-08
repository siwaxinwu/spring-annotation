package io.roy.spring.plugins.register.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * description：
 * author：dingyawu
 * date：created in 19:36 2020/8/5
 * history:
 */
@Repository
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDao {
    private String remark = "1";

}
