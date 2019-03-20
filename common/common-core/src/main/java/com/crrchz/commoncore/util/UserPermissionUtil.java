package com.crrchz.commoncore.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.crrchz.commoncore.vo.UserVo;
import org.springframework.util.StringUtils;

/**
 * 权限验证：这块要根据是实际的功能来进行完善
 * @author lhj
 * @Description:
 * @Date: 2019/1/16 1:20
 */
public class UserPermissionUtil {

    /**
     * 模拟权限校验, 可以根据自己项目需要定制不同的策略,如查询数据库获取具体的菜单url或者角色等等.
     * @param user
     */
    public static boolean verify(UserVo user, HttpServletRequest request){
        System.out.println("开始鉴权");
        String url = request.getHeader("x-user-serviceName");
        if(StringUtils.isEmpty(user)) {
            return false;
        }else {
            List<String> str = user.getAllowPermissionService();
            for (String permissionService : str) {
                if(url.equalsIgnoreCase(permissionService)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * 模拟权限赋值, 可以根据自己项目需要定制不同的策略,如查询数据库获取具体的菜单url或者角色等等.
     * @param user
     */
    public static void permission(UserVo user){
        System.out.println("开始赋权："+ user);
        if(user.getUserName().equals("admin")) {
            List allowPermissionService = new ArrayList();
            allowPermissionService.add("client-service");
            allowPermissionService.add("provider-service");
            user.setAllowPermissionService(allowPermissionService);
        }else if(user.getUserName().equals("spring")) {
            List allowPermissionService = new ArrayList();
            allowPermissionService.add("client-service");
            user.setAllowPermissionService(allowPermissionService);
        } else {
            List allowPermissionService = new ArrayList();
            user.setAllowPermissionService(allowPermissionService);
        }
    }

}