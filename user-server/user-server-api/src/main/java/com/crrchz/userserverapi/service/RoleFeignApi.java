package com.crrchz.userserverapi.service;

import com.crrchz.userserverapi.model.dto.RoleDto;
import com.crrchz.userserverapi.service.hystrix.RoleFeignHystrix;
import com.crrchz.userserverapi.service.hystrix.UserFeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author lhj
 * @Description:
 * @Date: 2019/1/15 10:31
 */
@FeignClient(value = "user-server-provider", fallback = RoleFeignHystrix.class)
public interface RoleFeignApi {

    /**
     *  通过用户id去查找用户角色
     * @param userId
     * @return
     */
    @PostMapping("/user/getRoleList")
    List<RoleDto> getRoleList(Integer userId);
}
