package com.crrchz.userserverapi.service.hystrix;

import com.crrchz.userserverapi.model.dto.UserDto;
import com.crrchz.userserverapi.service.UserFeignApi;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class UserFeignHystrix implements UserFeignApi {

    @Override
    public UserDto getUser(UserDto userDto) {
        return null;
    }

    @Override
    public List<UserDto> getUserList(UserDto UserDto) {
        return Collections.emptyList();
    }
}
