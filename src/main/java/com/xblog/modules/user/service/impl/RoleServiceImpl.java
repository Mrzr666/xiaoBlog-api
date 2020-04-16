package com.xblog.modules.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xblog.modules.user.entity.Role;
import com.xblog.modules.user.mapper.RoleMapper;
import com.xblog.modules.user.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<Role> getUserRoles(Long userId) {
        return roleMapper.getUserRoles(userId);
    }
}
