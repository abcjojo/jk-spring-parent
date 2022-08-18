package com.liyijun.jk.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @Description:  master 数据源配置  https://www.cnblogs.com/liyhbk/p/16198444.html
 * @author: liyijun
 * @date: 2022年08月18日 17:04
 */

@Configuration
public class DataSourceMasterConfig {

    

    /**
    * 指定数据源
    */
    @Bean(name = "masterDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    /** 配置事务管理器， 不配置事务不起作用 */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(this.dataSource());
    }



}
