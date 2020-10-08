package io.roy.spring.plugins.register.bean1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * description： 测试@componentScan
 * author：dingyawu
 * date：created in 13:01 2020/9/28
 * history:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class Teacher {
    private String name;
    private Integer age;
}
