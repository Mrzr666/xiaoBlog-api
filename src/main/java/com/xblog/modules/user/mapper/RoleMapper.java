package com.xblog.modules.user.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xblog.modules.user.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    List<Role> getUserRoles(@Param("userId") Long userId);
}
