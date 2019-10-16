package com.lucy.demo.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
public class MybatisDataSourceConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource MybatisDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public SqlSessionFactory MybatisSqlSessionFactory(DataSource MybatisDataSource,
            ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(MybatisDataSource);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mapper/**/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate MybatisSqlSessionTemplate(SqlSessionFactory MybatisSqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(MybatisSqlSessionFactory);
    }

    @Bean
    public DataSourceTransactionManager MybatisDataSourceTransactionManager(DataSource MybatisDataSource) {
        return new DataSourceTransactionManager(MybatisDataSource);
    }

}
