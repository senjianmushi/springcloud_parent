package com.crrchz.authserverprovider.service;

import com.crrchz.authserverprovider.service.impl.UserServiceImpl;
import com.crrchz.commonbase.vo.ResultObject;
import com.crrchz.userserverapi.model.vo.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
/**
 * @author lhj
 * @Description:
 * @Date: 2019/1/17 13:26
 */
@FeignClient(name = "user-server-provider",fallback = UserServiceImpl.class)
public interface UserService {
    @GetMapping("user/findByUsername/{username}")
    ResultObject<UserVo> findByUsername(@PathVariable("username") String username);
}