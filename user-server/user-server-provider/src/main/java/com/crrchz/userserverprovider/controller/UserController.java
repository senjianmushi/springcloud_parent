package com.crrchz.userserverprovider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @RequestMapping("sayHello")
    public String SayHello(String name){
        return "hello: "+ name;
    }
}
