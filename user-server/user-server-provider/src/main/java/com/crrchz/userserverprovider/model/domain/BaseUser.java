package com.crrchz.userserverprovider.model.domain;

import com.crrchz.userserverapi.model.dto.UserDto;
import com.crrchz.userserverapi.model.vo.UserVo;
import lombok.Data;

@Data
public class BaseUser {
    private Integer id;
    private String userName;
    private String userPassword;
    private String nikeName;
    private Integer status;

    public BaseUser(){}

    public BaseUser(String userName){
        this.userName = userName;
    }

    public BaseUser(UserDto userDto){
        this.id = userDto.getId();
        this.userName = userDto.getName();
    }
}