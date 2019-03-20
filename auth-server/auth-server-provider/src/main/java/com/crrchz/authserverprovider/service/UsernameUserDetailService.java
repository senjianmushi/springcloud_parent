package com.crrchz.authserverprovider.service;

import com.crrchz.authserverapi.model.ResponseCode;
import com.crrchz.authserverapi.service.BaseUserFeignApi;
import com.crrchz.userserverapi.model.dto.RoleDto;
import com.crrchz.userserverapi.model.dto.UserDto;
import com.crrchz.userserverapi.service.UserFeignApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fp295 on 2018/11/25.
 */
@Service
public class UsernameUserDetailService extends BaseUserDetailService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    protected UserFeignApi userFeignApi;

    @Override
    protected UserDto getUser(String username) {
        // 账号密码登陆调用FeignClient根据用户名查询用户
        UserDto userDto = userFeignApi.getUser(new UserDto(username));
        if(userDto == null ){
            logger.error("找不到该用户，用户名：" + username);
            throw new UsernameNotFoundException("找不到该用户，用户名：" + username);
        }
        return userDto;
    }

    @Override
    public List<RoleDto> getRoleList(Integer userId) {
        return null;
    }

    @Override
    public UserDto getUser(UserDto userDto) {
        return null;
    }

    @Override
    public List<UserDto> getUserList(UserDto UserDto) {
        return null;
    }
}
