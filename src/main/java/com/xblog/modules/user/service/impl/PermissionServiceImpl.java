package com.xblog.modules.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xblog.modules.user.entity.Permission;
import com.xblog.modules.user.mapper.PermissionMapper;
import com.xblog.modules.user.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> getRolePermissions(Integer roleId) {
        return permissionMapper.getRolePermissions(roleId);
    }
}
