package com.xblog.modules.article.controller;


import com.alibaba.fastjson.support.spring.annotation.FastJsonFilter;
import com.alibaba.fastjson.support.spring.annotation.FastJsonView;
import com.xblog.common.annotation.LogAnnotation;
import com.xblog.common.result.Result;
import com.xblog.modules.article.request.ArticlePageRequest;
import com.xblog.modules.article.entity.Article;
import com.xblog.modules.article.request.PagesRequest;
import com.xblog.modules.article.response.ArticlePageResponse;
import com.xblog.modules.article.service.ArticleService;
import com.xblog.modules.tag.entity.Tag;
import com.xblog.modules.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zr
 * @since 2020-04-13
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping
    @FastJsonView(
            exclude = {
                    @FastJsonFilter(clazz = Article.class, props = {"body", "category", "comments"}),
                    @FastJsonFilter(clazz = Tag.class, props = {"id", "avatar"})},
            include = {@FastJsonFilter(clazz = User.class, props = {"nickname"})})
    @LogAnnotation(module = "文章", operation = "获取所有文章")
    @ResponseBody
    public Result listArticles(ArticlePageRequest articlePageRequest, PagesRequest pagesRequest) {
        System.out.println(articlePageRequest);

        System.out.println(pagesRequest);
        List<ArticlePageResponse> articles = articleService.queryArticlesList(articlePageRequest, pagesRequest);
        return Result.success(articles);
    }


    @GetMapping("/hot")
    @FastJsonView(include = {@FastJsonFilter(clazz = Article.class, props = {"id", "title"})})
    @LogAnnotation(module = "文章", operation = "获取最热文章")
    @ResponseBody
    public Result listHotArticles() {
        int limit = 6;
        List<Article> articles = articleService.queryHotArticlesList(limit);
        return Result.success(articles);
    }


    @GetMapping("/new")
    @FastJsonView(include = {@FastJsonFilter(clazz = Article.class, props = {"id", "title"})})
    @LogAnnotation(module = "文章", operation = "获取最新文章")
    @ResponseBody
    public Result listNewArticles() {
        int limit = 6;
        List<Article> articles = articleService.queryNewArticlesList(limit);
        return Result.success(articles);
    }
}

