package io.roy.spring.plugins.register.springScan.spring;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description：
 * author：dingyawu
 * date：created in 10:55 2020/9/30
 * history:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyBeanDefinition {
    private String scope;
    private Class beanClass;
}
