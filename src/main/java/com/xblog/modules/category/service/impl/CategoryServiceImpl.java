package com.xblog.modules.category.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xblog.modules.category.entity.Category;
import com.xblog.modules.category.mapper.CategoryMapper;
import com.xblog.modules.category.service.CategoryService;
import org.springframework.stereotype.Service;

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

}
