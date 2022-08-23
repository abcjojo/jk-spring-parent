package com.liyijun.jk.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @Description:  master 数据源配置  https://www.cnblogs.com/liyhbk/p/16198444.html
 * @author: liyijun
 * @date: 2022年08月18日 17:04
 */

@Configuration
@MapperScan(basePackages = {"com.liyijun.jk.mapper.master"}, sqlSessionFactoryRef = "masterSqlSessionFactory")
public class MasterDataSourceConfig {

    @Value("${spring.datasource.druid.master.jdbc-url}")
    private String url;
    @Value("${spring.datasource.druid.master.username}")
    private String username;
    @Value("${spring.datasource.druid.master.password}")
    private String password;
    @Value("${spring.datasource.druid.master.driver-class-name}")
    private String driverClassName;

    /**
    * 指定数据源
    */
    @Bean(name = "masterDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid.master")
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .build();
    }

    /** 配置事务管理器， 不配置事务不起作用 */
    @Bean
    public PlatformTransactionManager masterTxManager() {
        return new DataSourceTransactionManager(this.dataSource());
    }

    @Primary
    @Bean(name = "masterSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier(value = "masterDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath*:mapping/master/*.xml"));
        sqlSessionFactoryBean.setTypeAliasesPackage("com.liyijun.jk.entity");
        sqlSessionFactoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return sqlSessionFactoryBean.getObject();
    }



}
