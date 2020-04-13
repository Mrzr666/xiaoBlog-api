package com.xblog.modules.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xblog.modules.user.entity.User;

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

}
