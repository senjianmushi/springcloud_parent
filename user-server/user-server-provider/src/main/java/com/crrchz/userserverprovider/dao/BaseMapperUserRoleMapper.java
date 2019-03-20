package com.crrchz.userserverprovider.dao;


import com.crrchz.userserverprovider.model.domain.BaseMapperUserRole;

import java.util.List;

public interface BaseMapperUserRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BaseMapperUserRole record);

    int insertSelective(BaseMapperUserRole record);

    BaseMapperUserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseMapperUserRole record);

    int updateByPrimaryKey(BaseMapperUserRole record);

    List<BaseMapperUserRole> selectRoleByUserId(Integer userId);
}