package com.crrchz.userserverprovider.service.impl;

import com.crrchz.userserverapi.model.dto.UserDto;
import com.crrchz.userserverapi.model.vo.UserVo;
import com.crrchz.userserverprovider.dao.BaseUserMapper;
import com.crrchz.userserverprovider.model.domain.BaseUser;
import com.crrchz.userserverprovider.service.BaseUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lhj
 * @Description:
 * @Date: 2019/1/15 1:18
 */
@Service
public class BaseUserServiceImpl implements BaseUserService {

    @Resource
    BaseUserMapper baseUserMapper;

    @Override
    public BaseUser getUser(BaseUser baseUser) {
        return baseUserMapper.selectObjectByUser(baseUser);
    }

    @Override
    public List<BaseUser> getUserList(BaseUser baseUser) {
        return baseUserMapper.selectListByUser(baseUser);
    }
}
