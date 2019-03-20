package com.crrchz.commoncore.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
/**
 * @author lhj
 * @Description:
 * @Date: 2019/1/17 13:40
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoleVo implements Serializable {
    private static final long serialVersionUID = 2179037393108205286L;
    private Integer id;
    private String name;
    private String value;
    private String tips;
    private Date createTime;
    private Date updateTime;
    private Integer status;
}

