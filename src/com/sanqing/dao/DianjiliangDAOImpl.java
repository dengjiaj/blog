package com.sanqing.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sanqing.po.Dianjiliang;

/**
 * Created by Administrator on 2017/7/3.
 */
public class DianjiliangDAOImpl extends HibernateDaoSupport implements DianjiliangDAO{

	@Override
	public List queryByAId(final int AId, final String IP,final Date time) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query = session.createQuery("select djl from Dianjiliang djl where "
						+ "djl.AId = ? and djl.ip = ? and djl.time = ?");
				//设置参数
				query.setParameter(0, AId);
				//设置每页显示多少个，设置多大结果。
				query.setParameter(1, IP);
				//设置起点
				query.setParameter(2, time);
				return query.list();
				
			}
		});
	}

	@Override
	public void addJilu(Dianjiliang dianjiliang) {
		this.getHibernateTemplate().save(dianjiliang);
		
	}
	
}
