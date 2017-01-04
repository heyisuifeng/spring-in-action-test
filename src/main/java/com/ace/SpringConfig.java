package com.ace;

import com.ace.service.ShiroService;
import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yecanyi on 2016/11/13.
 */
@Configuration
@EnableWebMvc
public class SpringConfig {

    @Bean
    public InternalResourceViewResolver resourceViewResolver() throws PropertyVetoException{
        InternalResourceViewResolver resourceViewResolver = new InternalResourceViewResolver();
        resourceViewResolver.setPrefix("/WEB-INF/jsp/");
        resourceViewResolver.setSuffix(".jsp");
        return resourceViewResolver;
    }

    @Bean
    public DataSource dataSource() throws PropertyVetoException{
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/shiro_test?useUnicode\\=true;characterEncoding\\=utf8;autoReconnect\\=true");
        dataSource.setUsername("root");
        dataSource.setPassword("p@ssw0rd");
        dataSource.setInitialSize(5);
        dataSource.setMaxActive(10);
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws PropertyVetoException{
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setDataSource(dataSource());
        return transactionManager;
    }


    //配置权限管理器
    @Bean
    public DefaultWebSecurityManager shiroSecurityManager() throws PropertyVetoException{
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(new ShiroService());
        securityManager.setCacheManager(new MemoryConstrainedCacheManager());
        return securityManager;
    }

    @Bean
    public FactoryBean<ShiroFilterFactoryBean> shiroFilterFactoryBean() throws PropertyVetoException{
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(shiroSecurityManager());
        shiroFilter.setLoginUrl("/");
        shiroFilter.setSuccessUrl("/search");
        shiroFilter.setUnauthorizedUrl("/403");
        Map<String,String> map = new HashMap<>();
        map.put("/static/**","");
        map.put("/login","anon");
        map.put("/user","perms[user:query]");
        map.put("/user/add","roles[manager]");
        map.put("/user/del/**","roles[admin]");
        map.put("/user/edit/**","roles[manager]");
        map.put("/**","authc");
        shiroFilter.setFilterChainDefinitionMap(map);
        return shiroFilter;
    }
}
