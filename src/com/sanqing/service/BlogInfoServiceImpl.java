package com.sanqing.service;

import com.sanqing.dao.BlogInfoDAO;
import com.sanqing.po.BlogInfo;

/**
 * Created by Administrator on 2017/7/3.
 */
public class BlogInfoServiceImpl implements BlogInfoService{
	private BlogInfoDAO blogInfoDAO;
	
	public BlogInfoDAO getBlogInfoDAO() {
		return blogInfoDAO;
	}

	public void setBlogInfoDAO(BlogInfoDAO blogInfoDAO) {
		this.blogInfoDAO = blogInfoDAO;
	}

	@Override
	public void setBlogInfo(BlogInfo blogInfo) {
		blogInfoDAO.save(blogInfo);
	}

	@Override
	public BlogInfo getBlogInfo(String name) {
		
		return blogInfoDAO.get(name);
	}
}
