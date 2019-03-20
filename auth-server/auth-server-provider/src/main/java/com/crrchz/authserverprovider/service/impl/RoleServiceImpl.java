package com.crrchz.authserverprovider.service.impl;


import com.crrchz.authserverprovider.service.RoleService;
import com.crrchz.commonbase.enums.StatusCodeEnum;
import com.crrchz.commonbase.vo.ResultObject;
import com.crrchz.commoncore.vo.RoleVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author lhj
 * @Description:
 * @Date: 2019/1/17 13:35
 */
@Service
@Slf4j
public class RoleServiceImpl implements RoleService {
    @Override
    public ResultObject<List<RoleVo>> getRoleByUserId(Integer userId) {
        log.info("调用{}失败","getRoleByUserId");
        return new ResultObject(StatusCodeEnum.STATUS_ERROR,"调用getRoleByUserId失败");
    }
}
