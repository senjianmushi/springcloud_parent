package com.crrchz.authserverprovider.service.impl;

import com.crrchz.authserverprovider.service.UserService;
import com.crrchz.commonbase.enums.StatusCodeEnum;
import com.crrchz.commonbase.vo.ResultObject;
import com.crrchz.userserverapi.model.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * @author lhj
 * @Description:
 * @Date: 2019/1/17 12:40
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Override
    public ResultObject<UserVo> findByUsername(String username) {
        log.info("调用{}失败","findByUsername");
        return new ResultObject(StatusCodeEnum.STATUS_ERROR,"调用接口失败");
    }
}
