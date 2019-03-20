package com.crrchz.authserverprovider.service.impl;

import com.crrchz.authserverprovider.service.RoleService;
import com.crrchz.authserverprovider.service.UserService;
import com.crrchz.commonbase.enums.StatusCodeEnum;
import com.crrchz.commonbase.vo.ResultObject;
import com.crrchz.commoncore.vo.RoleVo;
import com.crrchz.userserverapi.model.vo.UserVo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author lhj
 * @Description:
 * @Date: 2019/1/17 11:00
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
//    @Autowired
//    private PermissionService permissionService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ResultObject<UserVo> userResult = userService.findByUsername(username);
        if (userResult.getCode() != StatusCodeEnum.STATUS_SUCCESS.code()) {
            throw new UsernameNotFoundException("用户:" + username + ",不存在!");
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        boolean enabled = true; // 可用性 :true:可用 false:不可用
        boolean accountNonExpired = true; // 过期性 :true:没过期 false:过期
        boolean credentialsNonExpired = true; // 有效性 :true:凭证有效 false:凭证无效
        boolean accountNonLocked = true; // 锁定性 :true:未锁定 false:已锁定
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(userResult.getData(),userVo);
        ResultObject<List<RoleVo>> roleResult = roleService.getRoleByUserId(userVo.getId());
        if (roleResult.getCode() != StatusCodeEnum.STATUS_SUCCESS.code()){
            List<RoleVo> roleVoList = roleResult.getData();
            for (RoleVo role:roleVoList){
                //角色必须是ROLE_开头，可以在数据库中设置
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_"+role.getValue());
                grantedAuthorities.add(grantedAuthority);
                //获取权限
//                Result<List<MenuVo>> perResult  = permissionService.getRolePermission(role.getId());
//                if (perResult.getCode() != StatusCode.SUCCESS_CODE){
//                    List<MenuVo> permissionList = perResult.getData();
//                    for (MenuVo menu:permissionList
//                    ) {
//                        GrantedAuthority authority = new SimpleGrantedAuthority(menu.getCode());
//                        grantedAuthorities.add(authority);
//                    }
//                }
            }
        }
        User user = new User(userVo.getUserName(), userVo.getUserPassword(),
                enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuthorities);
        return user;
    }
}
