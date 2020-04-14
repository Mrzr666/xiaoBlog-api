package com.xblog.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xblog.BlogApiApplicationTests;
import com.xblog.modules.article.entity.Article;
import com.xblog.modules.article.request.ArticlePageRequest;
import com.xblog.modules.article.request.PagesRequest;
import com.xblog.modules.article.response.ArticlePageResponse;
import com.xblog.modules.article.service.ArticleService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public class ArticleServiceTest extends BlogApiApplicationTests{

	@Autowired
	private ArticleService articleService;



	@Test
	public void listArticlesByTagTest() {
		int id = 1;
		List<Article> as = articleService.queryHotArticlesList(6);

		System.out.println(as);

	}

	@Test
	public void queryArticlesListTest(){
		ArticlePageRequest articlePageRequest = new ArticlePageRequest();
		PagesRequest pagesRequest = new PagesRequest();
		pagesRequest.setPageSize(10);
		pagesRequest.setPageNumber(1);
		List<ArticlePageResponse> as = articleService.queryArticlesList(articlePageRequest,pagesRequest);
		System.out.println(as);
	}
//
//	@Test
//	public void listArticlesByCategoryTest() {
//		int id = 1;
//
//		List<Article> as = articleService.listArticlesByCategory(id);
//
//		System.out.println(as.size());
//	}
//
//	@Test
//	public void listHotArticlesTest() {
//
//		List<Article> as = articleService.listHotArticles(4);
//
//		as.stream().forEach( a -> System.out.println(a.getTitle()));
//		System.out.println(as.size());
//	}
//
//	@Test
//	public void listNewArticlesTest() {
//
//		List<Article> as = articleService.listNewArticles(4);
//
//		as.stream().forEach( a -> System.out.println(a.getTitle()));
//		System.out.println(as.size());
//	}
//
//	@Test
//	public void listArticlesTest() {
//
//		PageVo p = new PageVo();
//		p.setPageNumber(1);
//		p.setPageSize(5);
//		p.setName("createDate");
//		p.setSort("desc");
//
//		List<Article> as = articleService.listArticles(p);
//
//		as.stream().forEach( a -> System.out.println(a.getId()));
//
//	}
//
//	@Test
//	public void listArticlesTest2() {
//
//		PageVo p = new PageVo();
//		p.setPageNumber(1);
//		p.setPageSize(5);
//		p.setName("a.createDate");
//		p.setSort("desc");
//
//		ArticleVo articleVo = new ArticleVo();
//		articleVo.setYear(2018);
//		articleVo.setMonth(2);
//		//articleVo.setTagId(2);
//		//articleVo.setCategoryId(3);
//
//		List<Article> as = articleService.listArticles(articleVo, p);
//
//		as.stream().forEach( a -> {
//			System.out.println(a.getId());
//			System.out.println(a.getTitle());
//
//		});
//
//	}
}
