package com.crrchz.authserverprovider.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author lhj
 * @Description:
 * @Date: 2019/1/16 11:32
 */
@Controller
public class WebController {

    @GetMapping(value = "/login")
    public ModelAndView loginPage(Map<String, Object> model) {
        return new ModelAndView("login", model);
    }

    @GetMapping(value = "/hello")
    @ResponseBody
    public String  hello(String name) {
        return "hello: "+ name;
    }
}
