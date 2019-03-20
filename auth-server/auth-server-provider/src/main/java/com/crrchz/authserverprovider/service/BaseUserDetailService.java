package com.crrchz.authserverprovider.service;

import com.crrchz.authserverapi.model.ResponseCode;
import com.crrchz.authserverapi.model.auth.BaseUserDetail;
import com.crrchz.authserverapi.service.BaseRoleFeignApi;

import com.crrchz.userserverapi.model.dto.RoleDto;
import com.crrchz.userserverapi.model.dto.UserDto;
import com.crrchz.userserverapi.service.RoleFeignApi;
import com.crrchz.userserverapi.service.UserFeignApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;


/**
 * 自定义的用户获取接口欧，从数据库直接获取用户信息
 */
public abstract class BaseUserDetailService implements UserDetailsService, RoleFeignApi, UserFeignApi {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RoleFeignApi roleFeignApi;
    @Autowired
    private UserFeignApi userFeignApi;

    //@Autowired
    //private RedisTemplate<String, RoleDto> redisTemplate;


    @Override
    public UserDetails loadUserByUsername(String var1) throws UsernameNotFoundException {
        UserDto baseUser = getUser(var1);
        UserDto userDto = userFeignApi.getUser(new UserDto(var1));
        // 调用FeignClient查询角色
        List<RoleDto> rolelist = roleFeignApi.getRoleList(userDto.getId());

        //ResponseData<List<BaseRole>> baseRoleListResponseData = baseRoleService.getRoleByUserId(baseUser.getId());
        List<RoleDto> roles;
        if(rolelist == null ||  rolelist.size() > 0){
            logger.error("查询角色失败！");
            roles = new ArrayList<>();
        }else {
            roles = rolelist;
        }
        //调用FeignClient查询菜单
        //ResponseData<List<BaseModuleResources>> baseModuleResourceListResponseData = baseModuleResourceService.getMenusByUserId(baseUser.getId());

        // 获取用户权限列表
        List<GrantedAuthority> authorities = convertToAuthorities(baseUser, roles);

        // 存储菜单到redis
//        if( ResponseCode.SUCCESS.getCode().equals(baseModuleResourceListResponseData.getCode()) && baseModuleResourceListResponseData.getData() != null){
//            resourcesTemplate.delete(baseUser.getId() + "-menu");
//            baseModuleResourceListResponseData.getData().forEach(e -> {
//                resourcesTemplate.opsForList().leftPush(baseUser.getId() + "-menu", e);
//            });
//        }
        // 返回带有用户权限信息的User
        org.springframework.security.core.userdetails.User user =  new org.springframework.security.core.userdetails.User(baseUser.getName(),
                baseUser.getPassword(), true/* isActive(baseUser.getActive()) */, true, true, true, authorities);
        return new BaseUserDetail(user);
    }

    protected abstract UserDto getUser(String var1) ;


    private List<GrantedAuthority> convertToAuthorities(UserDto baseUser, List<RoleDto> roles) {
        List<GrantedAuthority> authorities = new ArrayList();
        // 清除 Redis 中用户的角色
        //redisTemplate.delete(baseUser.getId().toString());
        roles.forEach(e -> {
            // 存储用户、角色信息到GrantedAuthority，并放到GrantedAuthority列表
            GrantedAuthority authority = new SimpleGrantedAuthority(e.getRoleCode());
            authorities.add(authority);
            //存储角色到redis
            //redisTemplate.opsForList().rightPush(baseUser.getId().toString(), e);
        });
        return authorities;
    }
}
