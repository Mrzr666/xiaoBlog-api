package com.xblog.modules.category.controller;


import com.xblog.common.result.Result;
import com.xblog.modules.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xsy
 * @since 2020-04-13
 */
@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("list")
    @ResponseBody
    public Result queryCategoryList(){
        return categoryService.queryCategoryList();
    }
}

