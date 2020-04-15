package com.xblog.modules.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

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

    @ApiModelProperty("用户ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String userName;

    /**
     * 是否是管理员
     */
    @ApiModelProperty("是否为管理员")
    private Boolean isAdmin;

    /**
     * 头像
     */
    @ApiModelProperty("头像链接")
    private String avatar;

    @ApiModelProperty("电子邮件")
    private String email;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("昵称")
    private String nickName;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createdDate;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("MD5盐")
    private String salt;

    @ApiModelProperty("状态")
    private String status;

    @ApiModelProperty("最后登录日期")
    private Date lastLogin;

    /**
     * 删除标记
     */
    @ApiModelProperty("删除标记")
    private Boolean deleted;


    public void setAccount(String a) {
    }
}
