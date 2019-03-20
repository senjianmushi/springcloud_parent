package com.crrchz.authserverprovider.service;

import com.crrchz.authserverprovider.service.impl.RoleServiceImpl;
import com.crrchz.commonbase.vo.ResultObject;
import com.crrchz.commoncore.vo.RoleVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author lhj
 * @Description:
 * @Date: 2019/1/17 13:34
 */
@FeignClient(name = "mss-upms",fallback = RoleServiceImpl.class)
public interface RoleService {
    @GetMapping("role/getRoleByUserId/{userId}")
    ResultObject<List<RoleVo>> getRoleByUserId(@PathVariable("userId") Integer userId);
}