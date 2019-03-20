package com.crrchz.commoncore.intercepter;

import com.crrchz.commoncore.vo.UserVo;

/**
 * @author lhj
 * @Description:
 * @Date: 2019/1/16 1:23
 */
public class UserContextHolder {
    public static ThreadLocal<UserVo> context = new ThreadLocal<UserVo>();
    public static UserVo currentUser() {
        return context.get();
    }
    public static void set(UserVo user) {
        context.set(user);
    }
    public static void shutdown() {
        context.remove();
    }
}