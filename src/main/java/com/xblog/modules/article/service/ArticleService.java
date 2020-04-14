package com.xblog.modules.article.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xblog.modules.article.request.ArticlePageRequest;
import com.xblog.modules.article.entity.Article;
import com.xblog.modules.article.request.PagesRequest;
import com.xblog.modules.article.response.ArticlePageResponse;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xsy
 * @since 2020-04-13
 */
public interface ArticleService extends IService<Article> {

    List<Article> queryHotArticlesList(int limit);

    List<Article> queryNewArticlesList(int limit);

    List<ArticlePageResponse> queryArticlesList(ArticlePageRequest articlePageRequest, PagesRequest pagesRequest);
}
