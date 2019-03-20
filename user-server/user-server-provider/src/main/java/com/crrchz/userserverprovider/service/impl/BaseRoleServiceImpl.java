package com.crrchz.userserverprovider.service.impl;

import com.crrchz.userserverprovider.dao.BaseMapperUserRoleMapper;
import com.crrchz.userserverprovider.model.domain.BaseMapperUserRole;
import com.crrchz.userserverprovider.service.BaseRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lhj
 * @Description:
 * @Date: 2019/1/15 12:06
 */
@Service
public class BaseRoleServiceImpl implements BaseRoleService {

    @Resource
    BaseMapperUserRoleMapper baseMapperUserRoleMapper;

    @Override
    public List<BaseMapperUserRole> getRoleList(Integer userId) {
        return baseMapperUserRoleMapper.selectRoleByUserId(userId);

    }
}
