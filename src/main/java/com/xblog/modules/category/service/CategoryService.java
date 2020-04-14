package com.xblog.modules.category.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xblog.common.result.Result;
import com.xblog.modules.category.entity.Category;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xsy
 * @since 2020-04-13
 */
public interface CategoryService extends IService<Category> {
    Result queryCategoryList();

}
