package com.xblog.modules.user.controller;


import com.xblog.common.result.Result;
import com.xblog.modules.user.entity.User;
import com.xblog.modules.user.request.UserLoginRequest;
import com.xblog.modules.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 *  前端控制器  放行
 * </p>
 *
 * @author xsy
 * @since 2020-04-16
 */
@Api(tags = "用户放行接口")
@Controller
@RequestMapping("/pass/user")
public class UserPassController {

    @Autowired
    private UserService userService;

    @ApiOperation("用户登录")
    @PostMapping
    public Result createLine(@RequestBody UserLoginRequest request){
        return userService.login(request);
    }
}

