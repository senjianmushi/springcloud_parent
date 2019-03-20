package com.crrchz.authserverprovider.controller;

import com.crrchz.commonbase.enums.StatusCodeEnum;
import com.crrchz.commonbase.vo.ResultObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author lhj
 * @Description:
 * @Date: 2019/1/16 15:21
 */
@RestController
public class LogoutController {
    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    @DeleteMapping(value = "/exit")
    public @ResponseBody
    ResultObject revokeToken(String access_token){
        if (consumerTokenServices.revokeToken(access_token)){
            return new ResultObject(StatusCodeEnum.STATUS_SUCCESS,"注销成功");
        }else {
            return new ResultObject(StatusCodeEnum.STATUS_ERROR,"注销失败");
        }
    }
}