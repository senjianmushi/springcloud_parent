package com.crrchz.authserverapi.service;



/**
 * Created by fp295 on 2018/4/17.
 */
//@FeignClient(name = InterfaceService.SERVICE_NAME, fallback = BaseRoleFeignHystrix.class)
public interface BaseRoleFeignApi {
    /**
     * 根据userId查询角色
     * @param userId
     * @return
     */
//    @RequestMapping(value = "/auth/role/userId/{userId}", method = RequestMethod.GET)
//    ResponseData<List<BaseRole>> getRoleByUserId(@PathVariable("userId") Integer userId);
}
