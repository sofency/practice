package com.sofency.springbootshiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sofency
 * @date 2020/5/7 20:02
 * @package IntelliJ IDEA
 * @description
 */
@Controller
public class MyController {

    @RequestMapping({"/","/index"})
    public String toIndex(Model model){
        model.addAttribute("msg","sofency");
        return "login";
    }

    @RequestMapping("/user/add")
    public String addMsg(){
        return "user/add";
    }

    @RequestMapping("/user/update")
    public String updateMsg(){
        return "user/update";
    }

    @RequestMapping("/login")
    public String login(String username,String password,Model model){
        //获取当前的用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登陆数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        //登录
        try {
            subject.login(token);
            return "index";
        }catch (UnknownAccountException ex){
            model.addAttribute("msg","用户名错误");
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
        }
        return "login";
    }


    @RequestMapping("/noAuth")
    @ResponseBody
    public String unauthorized(){
        return "未经授权无法访问页面";
    }
}
