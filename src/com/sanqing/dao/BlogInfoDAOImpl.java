package com.sanqing.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sanqing.po.BlogInfo;

/**
 * Created by Administrator on 2017/7/3.
 */
public class BlogInfoDAOImpl extends HibernateDaoSupport implements BlogInfoDAO{

	@Override
	public void save(BlogInfo info) {
		this.getHibernateTemplate().saveOrUpdate(info);
		
	}

	@Override
	public BlogInfo get(String username) {
		List list = this.getHibernateTemplate().find("select bi from BlogInfo bi where bi.username = ?",username);
		if(list.size() == 0){
			return null;
		}else{
			return (BlogInfo)list.get(0);
		}
	}
}
