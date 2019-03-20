package com.crrchz.commoncore.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
/**
 * @author lhj
 * @Description:
 * @Date: 2019/1/16 1:19
 */
@Data
public class UserVo implements Serializable {
    private static final long serialVersionUID = -4083327605430665846L;
    public final static String CONTEXT_KEY_USERID = "x-user-id";
    private String userId;
    private String userName;
    private List<String> allowPermissionService;

    public UserVo() {
    }

}