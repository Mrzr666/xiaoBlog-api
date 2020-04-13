package com.xblog.modules.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author xsy
 * @since 2020-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("me_user")
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 是否是管理员
     */
    private Boolean isAdmin;

    /**
     * 头像
     */
    private String avatar;

    private String email;

    private String phone;

    private String nickName;

    /**
     * 创建时间
     */
    private LocalDateTime createdDate;

    private String password;

    private String salt;

    private String status;

    private LocalDateTime lastLogin;

    /**
     * 删除标记
     */
    private Boolean deleted;


}
