//package com.xblog.common.util;
//
//import org.apache.shiro.SecurityUtils;
//
//import com.xblog.common.constant.Base;
//import com.xblog.entity.User;
//
///**
// * @author shimh
// * <p>
// * 2018年1月25日
// */
//public class UserUtils {
//
//    public static User getCurrentUser() {
//        User user = (User) SecurityUtils.getSubject().getSession().getAttribute(Base.CURRENT_USER);
//        return user;
//    }
//}
