package com.crrchz.secretyserver.controller;

import com.crrchz.secretyserver.dao.BaseUserMapper;
import com.crrchz.secretyserver.model.BaseUser;
import com.crrchz.secretyserver.model.JwtToken;
import com.crrchz.secretyserver.service.UserService;
import com.crrchz.secretyserver.util.JwtUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lhj
 * @Description:
 * @Date: 2019/1/17 19:37
 */
@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @Resource
    BaseUserMapper baseUserMapper;

    /**
     * shrio的登录验证，验证成功后返回token
     * @param
     */
    @PostMapping("dologin")
    public String dologin(String username, String password){
        try{
            Subject subject= SecurityUtils.getSubject();
            //这个是jwt根据用户名+密码+过期时间来生成token信息
            String jwtTokenStr = JwtUtil.sign(username,password);
            JwtToken jwtToken = new JwtToken(jwtTokenStr);
            subject.login(jwtToken);//这里会吧token信息存放到head里面
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        return JwtUtil.sign(username,password);
    }

    @GetMapping("hello")
    public String hello(){
        return "hello";
    }
}
