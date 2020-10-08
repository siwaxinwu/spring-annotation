package io.roy.spring.plugins.register.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

/**
 * description： 测试多数据源
 * @Profile标注在类上说明只有这个环境，配置才会生效
 * -Dspring.profiles.active=test: 指定数据源
 * author：dingyawu
 * date：created in 16:46 2020/9/28
 * history:
 */

//@Profile("dev")
@Configuration
public class ProfileConfig {

    @Profile("dev")
    //@Profile("default")
    @Bean("devDataSource")
    public DataSource dataSourceDev() throws Exception{
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test_dev");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        return dataSource;
    }
    @Profile("test")
    @Bean("testDataSource")
    public DataSource dataSourceTest() throws Exception{
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test_test");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        return dataSource;
    }
    @Profile("prod")
    @Bean("prodDataDource")
    public DataSource dataSourceProd() throws Exception{
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test_prod");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        return dataSource;
    }
}