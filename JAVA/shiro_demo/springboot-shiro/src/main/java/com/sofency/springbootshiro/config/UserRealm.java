package com.sofency.springbootshiro.config;

import com.sofency.springbootshiro.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author sofency
 * @date 2020/5/7 20:12
 * @package IntelliJ IDEA
 * @description
 */
public class UserRealm extends AuthorizingRealm {
    private static List<User> list= new ArrayList<>();
    static {
        User user = new User(1,"sofency","121212","user:add");
        User user1 = new User(2,"alice","1234","user:delete");
        list.add(user);
        list.add(user1);
    }
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了授权的方法");
        //简单的验证
        SimpleAuthorizationInfo Info = new SimpleAuthorizationInfo();

        //获取当前登录的对象
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();//拿到user对象

        //从数据库中拿取用户的权限进行设置权限
        Info.addStringPermission(user.getPerms());

        return Info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了认证的方法");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        String username = token.getUsername();
        List<User> collect = list.stream().filter(user -> user.getUsername().equals(username)).collect(Collectors.toList());
        if(collect.size()==0){
            return null;
        }

        return new SimpleAuthenticationInfo(collect.get(0),collect.get(0).getPassword(),"");
    }

}
