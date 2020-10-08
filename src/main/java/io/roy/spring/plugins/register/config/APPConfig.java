package io.roy.spring.plugins.register.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * description：
 * author：dingyawu
 * date：created in 15:21 2020/9/10
 * history:
 */

@Configuration
@ComponentScan("io.roy.spring.plugins.register.service")
@EnableAspectJAutoProxy
public class APPConfig {
}
