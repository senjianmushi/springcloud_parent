package com.crrchz.secretyserver.service.impl;

import com.crrchz.secretyserver.dao.BaseUserMapper;
import com.crrchz.secretyserver.model.BaseUser;
import com.crrchz.secretyserver.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lhj
 * @Description:
 * @Date: 2019/1/22 8:22
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    BaseUserMapper baseUserMapper;

    @Override
    public BaseUser findByUserName(String userName) {
        BaseUser baseUser= new BaseUser(userName);
        return baseUserMapper.selectObjectByUser(baseUser);
    }
}
