package com.crrchz.userserverprovider.service;

import com.crrchz.userserverprovider.model.domain.BaseUser;

import java.util.List;

/**
 * @author lhj
 * @Description:
 * @Date: 2019/1/15 1:15
 */
public interface BaseUserService {

    /**
     * 查询用户信息
     * @param baseUser
     * @return
     */
    BaseUser getUser(BaseUser baseUser);

    List<BaseUser> getUserList(BaseUser baseUser);
}
