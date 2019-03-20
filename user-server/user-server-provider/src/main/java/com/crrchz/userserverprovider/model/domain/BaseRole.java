package com.crrchz.userserverprovider.model.domain;

import lombok.Data;

@Data
public class BaseRole {
    private Integer id;
    private String roleCode;
    private String roleName;
    private String remark;

}