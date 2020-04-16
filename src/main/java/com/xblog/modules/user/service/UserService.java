package com.xblog.modules.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xblog.common.result.Result;
import com.xblog.modules.user.entity.User;
import com.xblog.modules.user.request.UserLoginRequest;
import org.apache.shiro.session.Session;

import java.util.Collection;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xsy
 * @since 2020-04-13
 */
public interface UserService extends IService<User> {


    //根据用户名查找用户
    User queryUserByAccount(String account);

    Result login(UserLoginRequest request);

    //获取已经登录的用户列表
    Result queryLoginedUser();

}
