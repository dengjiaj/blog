package com.sanqing.service;

import java.util.Date;

import com.sanqing.dao.DianjiliangDAO;
import com.sanqing.po.Dianjiliang;

/**
 * Created by Administrator on 2017/7/3.
 */
public class DianjiliangServiceImpl implements DianjiliangService{
	private DianjiliangDAO dianjiliangDAO;
	
	public DianjiliangDAO getDianjiliangDAO() {
		return dianjiliangDAO;
	}

	public void setDianjiliangDAO(DianjiliangDAO dianjiliangDAO) {
		this.dianjiliangDAO = dianjiliangDAO;
	}

	@Override
	public boolean isVistor(int AId, String IP, Date time) {
		if(dianjiliangDAO.queryByAId(AId, IP, time).size()!=0){
			return true;
		}else{
			Dianjiliang djl = new Dianjiliang();
			djl.setAId(AId);
			djl.setIp(IP);
			djl.setTime(time);
			dianjiliangDAO.addJilu(djl);
			return false;
		}
	}
}
