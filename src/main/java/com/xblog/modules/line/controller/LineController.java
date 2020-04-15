package com.xblog.modules.line.controller;


import com.xblog.common.result.Result;
import com.xblog.modules.line.entity.Line;
import com.xblog.modules.line.service.LineService;
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
@Controller
@RequestMapping("/line")
public class LineController {

    @Autowired
    private LineService lineService;

    @GetMapping("list")
    @ResponseBody
    public Result queryLineList(){
        return lineService.queryLineList();
    }


    @PostMapping
    public Result createLine(@RequestBody Line line){
        return lineService.createLine(line);
    }

}

