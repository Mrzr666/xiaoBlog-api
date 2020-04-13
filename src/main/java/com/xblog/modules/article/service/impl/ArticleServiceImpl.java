package com.xblog.modules.article.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xblog.modules.article.entity.Article;
import com.xblog.modules.article.mapper.ArticleMapper;
import com.xblog.modules.article.service.ArticleService;
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
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

}
