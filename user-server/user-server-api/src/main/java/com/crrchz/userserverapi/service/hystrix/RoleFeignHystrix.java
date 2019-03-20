package com.crrchz.userserverapi.service.hystrix;

import com.crrchz.userserverapi.model.dto.RoleDto;
import com.crrchz.userserverapi.service.RoleFeignApi;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * @author lhj
 * @Description:
 * @Date: 2019/1/15 10:36
 */
@Component
public class RoleFeignHystrix implements RoleFeignApi {

    @Override
    public List<RoleDto> getRoleList(Integer userId) {
        return Collections.emptyList();
    }
}
