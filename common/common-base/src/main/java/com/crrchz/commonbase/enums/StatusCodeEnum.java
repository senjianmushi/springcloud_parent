package com.crrchz.commonbase.enums;

public enum StatusCodeEnum {

    STATUS_SUCCESS(200, "返回成功"),
    STATUS_ERROR(10001, "返回错误"),
    STATUS_PARAMETER(10002, "参数传递错误"),;

    private Integer code;
    private String msg;

    public String msg() {
        return msg;
    }
    public int code() {
        return code;
    }
    StatusCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public static StatusCodeEnum getEnum(int code) {
        for (StatusCodeEnum ele : StatusCodeEnum.values()) {
            if (ele.code() == code) {
                return ele;
            }
        }
        return null;
    }
}
