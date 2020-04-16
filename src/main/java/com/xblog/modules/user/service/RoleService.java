package com.xblog.modules.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xblog.modules.user.entity.Role;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 */
public interface RoleService extends IService<Role> {
    List<Role> getUserRoles(Long userId);
}
