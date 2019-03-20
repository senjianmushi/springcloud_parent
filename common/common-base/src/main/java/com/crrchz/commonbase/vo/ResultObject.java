package com.crrchz.commonbase.vo;
import com.crrchz.commonbase.enums.StatusCodeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
/**
 * @author lhj
 * @Description:
 * @Date: 2019/1/17 9:13
 */
@Data
public class ResultObject<T> {

    private static final String CODE = "code";
    private static final String MSG = "msg";

    private Integer code=200;
    private String msg="操作成功";
    private String description;
    private T data;

    private HashMap<String,Object> exend;


    @JsonIgnore
    public HashMap<String, Object> getExend() {
        return exend;
    }

    public ResultObject() {
        exend = new HashMap<>();
    }


    public ResultObject(StatusCodeEnum result){
        this.code = result.code();
        this.msg = result.msg();
    }

    public ResultObject(StatusCodeEnum result,T data){
        this.code = result.code();
        this.msg = result.msg();
        if(data != null){
            //this.value = value.toString();
            this.data = data;
        }
    }
}
