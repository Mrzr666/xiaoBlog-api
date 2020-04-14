package com.xblog.modules.category.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xblog.common.result.Result;
import com.xblog.modules.category.entity.Category;
import com.xblog.modules.category.mapper.CategoryMapper;
import com.xblog.modules.category.service.CategoryService;
import com.xblog.modules.tag.entity.Tag;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xsy
 * @since 2020-04-13
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Override
    public Result queryCategoryList() {
        LambdaQueryWrapper<Category> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(Category::getDeleted,0);
        List<Category> datas = getBaseMapper().selectList(wrapper);
        return Result.success(datas);
    }
}
