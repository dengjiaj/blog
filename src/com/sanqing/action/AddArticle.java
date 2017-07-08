package com.sanqing.action;

import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sanqing.po.Article;
import com.sanqing.service.ArticleService;

public class AddArticle extends ActionSupport{
	private String title;
	private String content;
	private ArticleService articleService;
	
	public String execute()throws Exception{
		Map map=ActionContext.getContext().getSession();
		String username=(String) map.get("username");
		Article article =new Article();
		article.setTitle(title);
		article.setContent(content);
		article.setUsername(username);
		article.setDate(new Date());
		article.setHasread(0);
		articleService.addArticle(article);
		return this.SUCCESS;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public ArticleService getArticleService() {
		return articleService;
	}
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
}
