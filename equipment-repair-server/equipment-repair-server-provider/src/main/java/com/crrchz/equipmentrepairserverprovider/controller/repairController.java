package com.crrchz.equipmentrepairserverprovider.controller;

import com.crrchz.userserverapi.model.dto.UserDto;
import com.crrchz.userserverapi.service.UserFeignApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lhj
 * @Description: 通过这种写法去调用其他服务器上的服务
 * @Date: 2019/1/15 9:54
 */
@RestController
public class repairController implements UserFeignApi{

    @Autowired
    UserFeignApi userFeignApi;

    @PostMapping("getUserInfoString")
    public String getUserInfoString(UserDto userDto){
        String result = this.getUser(userDto).toString();
        return result;
    }

    @Override
    public UserDto getUser(UserDto userDto) {
        return userFeignApi.getUser(userDto);
    }

    @Override
    public List<UserDto> getUserList(UserDto UserDto) {
        return userFeignApi.getUserList(UserDto);
    }
}
