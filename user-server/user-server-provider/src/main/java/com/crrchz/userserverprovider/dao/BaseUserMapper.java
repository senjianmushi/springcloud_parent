package com.crrchz.userserverprovider.dao;


import com.crrchz.userserverprovider.model.domain.BaseUser;

import java.util.List;

public interface BaseUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BaseUser record);

    int insertSelective(BaseUser record);

    BaseUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseUser record);

    int updateByPrimaryKey(BaseUser record);

    BaseUser selectObjectByUser(BaseUser baseUser);

    List<BaseUser> selectListByUser(BaseUser baseUser);
}