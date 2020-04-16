package com.xblog.modules.article.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xblog.modules.article.request.ArticlePageRequest;
import com.xblog.modules.article.entity.Article;
import com.xblog.modules.article.mapper.ArticleMapper;
import com.xblog.modules.article.request.PagesRequest;
import com.xblog.modules.article.response.ArticlePageResponse;
import com.xblog.modules.article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zr
 * @since 2020-04-13
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;


    @Override
    public List<Article> queryHotArticlesList(int limit) {
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        queryWrapper.ne("deleted","1");
        queryWrapper.orderBy(true,false,"view_counts");
        queryWrapper.last("limit " + limit);
        List<Article> hotArticlesList = list(queryWrapper);
        return hotArticlesList;
    }

    @Override
    public List<Article> queryNewArticlesList(int limit) {
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        queryWrapper.ne("deleted","1");
        queryWrapper.orderBy(true,false,"created_date");
        queryWrapper.last("limit " + limit);
        List<Article> hotArticlesList = list(queryWrapper);
        return hotArticlesList;
    }

    @Override
    public List<ArticlePageResponse> queryArticlesList(ArticlePageRequest articlePageRequest, PagesRequest pagesRequest) {
        IPage<ArticlePageResponse> page = new Page<>(pagesRequest.getPageNumber(), pagesRequest.getPageSize());
        List<ArticlePageResponse> articlePageResponseList = articleMapper.queryArticlesList(page,articlePageRequest);
        return articlePageResponseList;
    }
}
