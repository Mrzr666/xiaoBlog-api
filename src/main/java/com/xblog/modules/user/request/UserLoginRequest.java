package com.xblog.modules.user.request;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("me_user")
public class UserLoginRequest {
    @ApiModelProperty("用户名")
    @NotNull
    private String userName;

    @ApiModelProperty("密码")
    @NotNull
    private String passWord;

}
