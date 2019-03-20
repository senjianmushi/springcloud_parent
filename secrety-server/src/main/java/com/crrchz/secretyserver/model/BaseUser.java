package com.crrchz.secretyserver.model;

import lombok.Data;

/**
 * @author lhj
 * @Description:
 * @Date: 2019/1/22 1:01
 */
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

}
