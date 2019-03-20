package com.crrchz.userserverprovider.dao;


import com.crrchz.userserverprovider.model.domain.BaseRole;

public interface BaseRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BaseRole record);

    int insertSelective(BaseRole record);

    BaseRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseRole record);

    int updateByPrimaryKey(BaseRole record);
}