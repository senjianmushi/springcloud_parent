package com.crrchz.authserverapi.service;



/**
 * Created by fp295 on 2018/4/9.
 */
//@FeignClient(name = InterfaceService.SERVICE_NAME, fallback = BaseUserFeignHystrix.class)
public interface BaseUserFeignApi{
    /**
     * 根据用户名查询用户
     * @param userName
     * @return
     */
//    @RequestMapping(value = "auth/user/name/{userName}", method = RequestMethod.GET)
//    ResponseData<BaseUser> getUserByUserName(@PathVariable("userName") String userName);
}
