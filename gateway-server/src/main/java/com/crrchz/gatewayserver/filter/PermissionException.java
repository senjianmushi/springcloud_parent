package com.crrchz.gatewayserver.filter;

/**
 * @author lhj
 * @Description:
 * @Date: 2019/1/16 0:48
 */
public class PermissionException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public PermissionException(String msg) {
        super(msg);
    }
}