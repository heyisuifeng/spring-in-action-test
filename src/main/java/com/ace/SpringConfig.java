package com.ace;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Created by yecanyi on 2016/11/13.
 */
@Configuration
public class SpringConfig {
    @Bean
    public DataSource dataSource() throws PropertyVetoException{
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/shiro_test?useUnicode\\=true;characterEncoding\\=utf8;autoReconnect\\=true");
        dataSource.setUsername("root");
        dataSource.setPassword("p@ssw0rd");
        dataSource.setInitialSize(5);
        dataSource.setMaxActive(10);
        PlatformTransactionManager;
        JpaTransactionManager
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws PropertyVetoException{
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setDataSource(dataSource());
        return transactionManager;
    }

    @Bean
    public FactoryBean shiroFilterFactoryBean() throws PropertyVetoException{
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        return shiroFilter;
    }
}
