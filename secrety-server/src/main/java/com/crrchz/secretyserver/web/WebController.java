package com.crrchz.secretyserver.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lhj
 * @Description:
 * @Date: 2019/1/17 18:13
 */
@Controller
@RequestMapping("view")
public class WebController {

    @RequestMapping("login")
    public String viewLogin(){
        return "login";
    }

    @RequestMapping("403")
    public String viewLogin403(){
        return "403";
    }

    @RequestMapping("hello")
    public String hello(){
        return "hello";
    }
}
