package com.crrchz.userserverapi.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lhj
 * @Description:
 * @Date: 2019/1/15 10:42
 */
@Data
public class RoleDto implements Serializable {
    private Integer id;
    private Integer userId;
    private Integer roleId;
    private String roleCode;

    public RoleDto(){};

    public RoleDto(Integer id,Integer userId,Integer roleId,String roleCode){
        this.id = id;
        this.userId = userId;
        this.roleId = roleId;
        this.roleCode = roleCode;
    }
}
