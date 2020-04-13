package com.xblog.modules.article.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xblog.modules.article.entity.Article;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xsy
 * @since 2020-04-13
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

}
