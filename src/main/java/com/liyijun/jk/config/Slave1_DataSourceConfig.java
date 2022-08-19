package com.liyijun.jk.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @Description:
 * @author: liyijun
 * @date: 2022年08月19日 10:39
 */

@Configuration
@MapperScan(basePackages = {"com.liyijun.jk.mapper.slave1"}, sqlSessionFactoryRef = "slave1_SqlSessionFactory")
public class Slave1_DataSourceConfig {

    @Bean(value = "slave1_DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.salve1")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("slave1_SqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier(value = "slave1_DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath*:mapping/slave1/*.xml"));
        sqlSessionFactoryBean.setTypeAliasesPackage("com.liyijun.jk.entity");
        sqlSessionFactoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return sqlSessionFactoryBean.getObject();
    }

    /**
    * @Description:  此处没有创建事务管理器
    */
    @Bean
    public PlatformTransactionManager slaveTxManager(@Qualifier(value = "slave1_DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
