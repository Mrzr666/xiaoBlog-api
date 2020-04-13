package com.shimh.service.impl;

import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.shimh.vo.ArticleVo;
import com.shimh.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shimh.common.util.UserUtils;
import com.shimh.entity.Article;
import com.shimh.entity.Category;
import com.shimh.entity.Tag;
import com.shimh.entity.User;
import com.shimh.dao.ArticleMapper;
import com.shimh.service.ArticleService;

/**
 * @author shimh
 * <p>
 * 2018年1月25日
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;


    @Override
    public List<Article> listArticles(ArticleVo article, PageVo page) {
        LambdaQueryWrapper<Article> wrapper = Wrappers.lambdaQuery();

//        StringBuilder hql = new StringBuilder("from Article a ");

        if (null != article.getTagId()) {
            wrapper
            hql.append(" inner join fetch a.tags t");
        }

        hql.append(" where 1=1 ");

        if (null != article.getCategoryId()) {

            hql.append(" and a.category.id = :categoryId");
        }

        if (null != article.getTagId()) {

            hql.append(" and t.id = :tagId");
        }


        if (null != article.getYear() && !"".equals(article.getYear())) {
            hql.append(" and YEAR(a.createDate) = :year");
        }

        if (null != article.getMonth() && !"".equals(article.getMonth())) {
            hql.append(" and MONTH(a.createDate) = :month");
        }

        if (null != page.getName() && !"".equals(page.getName())) {
            hql.append(" order by ");
            hql.append(page.getName());
        }

        if (null != page.getSort() && !"".equals(page.getSort())) {
            hql.append(" ");
            hql.append(page.getSort());
        }


        Query query = getSession().createQuery(hql.toString());


        if (null != article.getYear() && !"".equals(article.getYear())) {
            query.setParameter("year", article.getYear());
        }

        if (null != article.getMonth() && !"".equals(article.getMonth())) {
            query.setParameter("month", article.getMonth());
        }

        if (null != article.getTagId()) {
            query.setParameter("tagId", article.getTagId());
        }

        if (null != article.getCategoryId()) {
            query.setParameter("categoryId", article.getCategoryId());
        }

        if (null != page.getPageNumber() && null != page.getPageSize()) {
            query.setFirstResult(page.getPageSize() * (page.getPageNumber() - 1));
            query.setMaxResults(page.getPageSize());
        }

        return query.list();

        return articleMapper.listArticles(article, page);
    }

    @Override
    public List<Article> findAll() {
        return articleMapper.findAll();
    }

    @Override
    public Article getArticleById(Integer id) {
        return articleMapper.getOne(id);
    }

    @Override
    @Transactional
    public Integer publishArticle(Article article) {

        if(null != article.getId()){
            return this.updateArticle(article);
        }else{
            return this.saveArticle(article);
        }

    }

    @Override
    @Transactional
    public Integer saveArticle(Article article) {

        User currentUser = UserUtils.getCurrentUser();

        if (null != currentUser) {
            article.setAuthor(currentUser);
        }

        article.setCreateDate(new Date());
        article.setWeight(Article.Article_Common);

        return articleMapper.save(article).getId();
    }

    @Override
    @Transactional
    public Integer updateArticle(Article article) {
        Article oldArticle = articleMapper.getOne(article.getId());

        oldArticle.setTitle(article.getTitle());
        oldArticle.setSummary(article.getSummary());
        oldArticle.setBody(article.getBody());
        oldArticle.setCategory(article.getCategory());
        oldArticle.setTags(article.getTags());

        return oldArticle.getId();
    }

    @Override
    @Transactional
    public void deleteArticleById(Integer id) {
        articleMapper.delete(id);
    }

    @Override
    public List<Article> listArticlesByTag(Integer id) {
        Tag t = new Tag();
        t.setId(id);
        return articleMapper.findByTags(t);
    }

    @Override
    public List<Article> listArticlesByCategory(Integer id) {
        Category c = new Category();
        c.setId(id);

        return articleMapper.findByCategory(c);
    }

    @Override
    @Transactional
    public Article getArticleAndAddViews(Integer id) {
        int count = 1;
        Article article = articleMapper.getOne(id);
        article.setViewCounts(article.getViewCounts() + count);
        return article;
    }

    @Override
    public List<Article> listHotArticles(int limit) {

        return articleMapper.findOrderByViewsAndLimit(limit);
    }

    @Override
    public List<Article> listNewArticles(int limit) {

        return articleMapper.findOrderByCreateDateAndLimit(limit);
    }

    @Override
    public List<ArticleVo> listArchives() {

        return articleMapper.listArchives();
    }
}
