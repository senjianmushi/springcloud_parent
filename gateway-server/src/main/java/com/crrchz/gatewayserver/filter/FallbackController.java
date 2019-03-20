package com.crrchz.gatewayserver.filter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lhj
 * @Description:
 * @Date: 2019/1/15 19:44
 */
@RestController
public class FallbackController {

    @GetMapping("/fallback")
    public String fallback(){
        return "spring cloud gateway fallback ~~~~~";
    }


}
