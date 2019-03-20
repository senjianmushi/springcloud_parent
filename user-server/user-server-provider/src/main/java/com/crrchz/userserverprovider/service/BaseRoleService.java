package com.crrchz.userserverprovider.service;

import com.crrchz.userserverprovider.dao.BaseMapperUserRoleMapper;
import com.crrchz.userserverprovider.model.domain.BaseMapperUserRole;

import java.util.List;

/**
 * @author lhj
 * @Description:
 * @Date: 2019/1/15 12:05
 */
public interface BaseRoleService {
    List<BaseMapperUserRole> getRoleList(Integer userId);
}
