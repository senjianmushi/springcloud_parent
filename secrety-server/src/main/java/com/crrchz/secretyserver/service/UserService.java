package com.crrchz.secretyserver.service;

import com.crrchz.secretyserver.model.BaseUser;

/**
 * @author lhj
 * @Description:
 * @Date: 2019/1/22 8:22
 */
public interface UserService {

    BaseUser findByUserName(String userName);
}
