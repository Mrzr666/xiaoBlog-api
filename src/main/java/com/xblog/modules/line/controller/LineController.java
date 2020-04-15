package com.xblog.modules.line.controller;


import com.xblog.common.result.Result;
import com.xblog.modules.line.entity.Line;
import com.xblog.modules.line.service.LineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xsy
 * @since 2020-04-15
 */
@Api(tags = "日志时间线接口")
@Controller
@RequestMapping("/line")
public class LineController {

    @Autowired
    private LineService lineService;

    @ApiOperation("获取时间线总列表")
    @GetMapping("list")
    @ResponseBody
    public Result queryLineList(){
        return lineService.queryLineList();
    }

    @ApiOperation("创建时间线")
    @PostMapping
    public Result createLine(@RequestBody Line line){
        return lineService.createLine(line);
    }

}

