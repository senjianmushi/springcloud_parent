package com.crrchz.secretyserver.model;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author lhj
 * @Description:
 * @Date: 2019/1/22 8:06
 */
public class JwtToken implements AuthenticationToken {

    private String token;

    public JwtToken(String token) {
        this.token = token;
    }


    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
