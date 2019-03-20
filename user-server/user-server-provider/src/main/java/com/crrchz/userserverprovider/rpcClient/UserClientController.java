package com.crrchz.userserverprovider.rpcClient;

import com.crrchz.commonbase.enums.StatusCodeEnum;
import com.crrchz.commonbase.vo.ResultObject;
import com.crrchz.userserverapi.model.dto.RoleDto;
import com.crrchz.userserverapi.model.dto.UserDto;
import com.crrchz.userserverapi.model.vo.UserVo;
import com.crrchz.userserverapi.service.RoleFeignApi;
import com.crrchz.userserverapi.service.UserFeignApi;
import com.crrchz.userserverprovider.dao.BaseRoleMapper;
import com.crrchz.userserverprovider.model.domain.BaseMapperUserRole;
import com.crrchz.userserverprovider.model.domain.BaseRole;
import com.crrchz.userserverprovider.model.domain.BaseUser;
import com.crrchz.userserverprovider.service.BaseRoleService;
import com.crrchz.userserverprovider.service.BaseUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserClientController implements UserFeignApi, RoleFeignApi {

    @Autowired
    BaseUserService baseUserService;
    @Autowired
    BaseRoleService baseRoleService;


    @Override
    @PostMapping("/user/getUser")
    public UserDto getUser(UserDto userDto) {
        if(userDto == null){
            return null;
        }
        BaseUser baseUser = baseUserService.getUser(new BaseUser(userDto));
        return new UserDto(baseUser.getId(),baseUser.getUserName(),baseUser.getUserPassword());
    }

    @GetMapping("findByUsername/{username}")
    public ResultObject findByUsername(@PathVariable("username") String username){
        BaseUser user = baseUserService.getUser(new BaseUser(username));
        if (user == null){
            return new ResultObject(StatusCodeEnum.STATUS_ERROR,"用户不存在");
        }
        return new ResultObject(StatusCodeEnum.STATUS_SUCCESS,user);
    }

    @Override
    @PostMapping("/user/getUserList")
    public List<UserDto> getUserList(UserDto userDto) {
        System.out.println("开始查找");
        if(userDto == null){
            return null;
        }
        List<BaseUser> baseUserList = baseUserService.getUserList(new BaseUser(userDto));
        return wrapUserDtoList(baseUserList);
    }
    private List<UserDto> wrapUserDtoList(List<BaseUser> userList){
        List<UserDto> userDtoList = new ArrayList<>();
        for(BaseUser baseUser : userList){
            userDtoList.add(new UserDto(baseUser.getId(),baseUser.getUserName(),baseUser.getUserPassword()));
        }
        return userDtoList;
    }

    @Override
    @PostMapping("/user/getRoleList")
    public List<RoleDto> getRoleList(Integer userId) {
        if(userId == null){
            return null;
        }
        List<BaseMapperUserRole> roleList =  baseRoleService.getRoleList(userId);
        return wrapRoleList(roleList);
    }
    private List<RoleDto> wrapRoleList(List<BaseMapperUserRole> list){
        List<RoleDto> RoleDtoList = new ArrayList<>();
        for(BaseMapperUserRole baseRole : list){
            RoleDtoList.add(new RoleDto(baseRole.getId(),
                    baseRole.getUserId(), baseRole.getRoleId(),
                    baseRole.getRoleCode() ));
        }
        return RoleDtoList;
    }
}
