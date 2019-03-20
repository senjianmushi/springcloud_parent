package com.crrchz.userserverapi.service;

import com.crrchz.userserverapi.model.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.crrchz.userserverapi.service.hystrix.UserFeignHystrix;

import java.util.List;

//@FeignClient(value = "user-server-provider", configuration = OAuth2FeignAutoConfiguration.class, fallback = MdcExceptionLogFeignHystrix.class)
@FeignClient(value = "user-server-provider", fallback = UserFeignHystrix.class)
public interface UserFeignApi {

    @PostMapping("/user/getUser")
    UserDto getUser(@RequestBody UserDto userDto);

    @PostMapping("/user/getUserList")
    List<UserDto> getUserList(@RequestBody UserDto UserDto);
}
