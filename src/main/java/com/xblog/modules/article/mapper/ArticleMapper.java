package com.xblog.modules.article.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xblog.modules.article.entity.Article;
import com.xblog.modules.article.request.ArticlePageRequest;
import com.xblog.modules.article.response.ArticlePageResponse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zr
 * @since 2020-04-13
 */
@Mapper
@Repository
public interface ArticleMapper extends BaseMapper<Article> {

    List<ArticlePageResponse> queryArticlesList(ArticlePageRequest articlePageRequest);

    List<ArticlePageResponse> queryArchivesList();
}
