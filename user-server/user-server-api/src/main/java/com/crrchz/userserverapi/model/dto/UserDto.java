package com.crrchz.userserverapi.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 对接接口的参数
 */
@Data
public class UserDto implements Serializable {
    private Integer id;
    private String name;
    private String password;

    public UserDto(){}

    public UserDto(Integer id,String name){
        this.id = id;
        this.name = name;
    }
    public UserDto(Integer id,String name,String password){
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public UserDto(String name){
        this.name = name;
    }
}
