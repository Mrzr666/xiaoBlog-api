package com.xblog.modules.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xblog.modules.user.entity.Permission;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 */
public interface PermissionService extends IService<Permission> {

    List<Permission> getRolePermissions(Integer roleId);
}
