package com.xblog.common.util;

import com.xblog.modules.user.entity.User;
import org.apache.shiro.SecurityUtils;

import com.xblog.common.constant.Base;

/**
 * @author shimh
 * <p>
 * 2018年1月25日
 */
public class UserUtils {

    public static User getCurrentUser() {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute(Base.CURRENT_USER);
        return user;
    }
}
