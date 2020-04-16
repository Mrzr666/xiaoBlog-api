package com.xblog.modules.user.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xblog.modules.user.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

    List<Permission> getRolePermissions(@Param("roleId") Integer roleId);
}
