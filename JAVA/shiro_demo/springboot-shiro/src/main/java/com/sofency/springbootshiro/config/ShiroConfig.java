package com.sofency.springbootshiro.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author sofency
 * @date 2020/5/7 20:09
 * @package IntelliJ IDEA
 * @description
 */
@Configuration
public class ShiroConfig {
    //ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(defaultWebSecurityManager);
        //添加shiro的内置过滤器
        /**
         * 添加shiro的内置过滤器
         * anon  无序认证就可以访问
         * authc: 必须认证了才能访问
         * user  必须拥有记住我 功能才能使用
         * perms  拥有对某个资源的权限才能访问
         * role  拥有某个角色的权限才能访问
         */
        Map<String,String> filterMap = new LinkedHashMap<>();
        filterMap.put("/user/add","perms[user:add]"); //登录add页面时 必须是user用户并且具有add的权限
        filterMap.put("/user/update","perms[user:delete]");
        bean.setFilterChainDefinitionMap(filterMap);
        bean.setUnauthorizedUrl("/noAuth");
        return bean;
    }


    //DefaultWebSecurityManager
    @Bean
    public DefaultWebSecurityManager securityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联UserRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }


    //创建realm 对象  需要自定义类

    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }


    //整合ShiroDialect 用来整合 shiro和thymeleaf
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }


}
