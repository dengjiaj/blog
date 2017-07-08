package com.sanqing.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sanqing.po.User;

public class UserDAOImpl extends HibernateDaoSupport implements UserDAO{
	public void add(User user) {
		this.getHibernateTemplate().save(user);
	}

	
	public void delete(User user) {
		this.getHibernateTemplate().delete(user);
		
	}

	public void update(User user) {
		this.getHibernateTemplate().update(user);
		
	}

	public List queryAll() {
		List list = this.getHibernateTemplate().find("select * from User");
		return list;
	}

	public User queryByID(String username) {//定义用户名是否存在
		List list = this.getHibernateTemplate().find("select user from User user where user.username = '" + username + "'");
		
		if(list.size() == 0) {
			return null;
		} else {
			return (User)list.get(0);
		}
	}

}
