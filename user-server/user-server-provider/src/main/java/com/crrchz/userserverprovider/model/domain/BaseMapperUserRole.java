package com.crrchz.userserverprovider.model.domain;

import lombok.Data;

@Data
public class BaseMapperUserRole {
    private Integer id;
    private Integer userId;
    private Integer roleId;

    //补充字段
    private String roleCode;
}