package io.roy.spring.plugins.register.config;

import io.roy.spring.plugins.register.bean.Department;
import io.roy.spring.plugins.register.bean.Employee;
import io.roy.spring.plugins.register.condition.MyImportBeanDefinitionRegister;
import io.roy.spring.plugins.register.selector.MyImportSelector;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * description： 测试@import注册bean的demo
 * ImportSelector接口是至spring中导入外部配置的核心接口，在SpringBoot的自动化配置和@EnableXXX(功能性注解)都有它的存在
 * ImportBeanDefinitionRegistrar需要配合@Configuration和@Import注解
 *
 * author：dingyawu
 * date：created in 16:14 2020/8/6
 * history:
 */
@Configuration
@Import({Department.class, Employee.class, MyImportSelector.class, MyImportBeanDefinitionRegister.class})
public class PersonConfig11 {
}
