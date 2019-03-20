package com.crrchz.userserverapi.model.vo;

import lombok.Data;

/**
 * 输入的参数
 */
@Data
public class UserVo {
    private Integer id;
    private String userName;
    private String userPassword;
    private String nikeName;
    private Integer status;
}
