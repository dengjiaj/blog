package com.sanqing.service;

import java.util.List;

import com.sanqing.dao.CritiqueDAO;
import com.sanqing.fenye.Page;
import com.sanqing.fenye.PageUtil;
import com.sanqing.fenye.Result;
import com.sanqing.po.Critique;

/**
 * Created by Administrator on 2017/7/3.
 */
public class CritiqueServiceImpl implements CritiqueService{
	private CritiqueDAO critiqueDAO;
	
	

	public CritiqueDAO getCritiqueDAO() {
		return critiqueDAO;
	}

	public void setCritiqueDAO(CritiqueDAO critiqueDAO) {
		this.critiqueDAO = critiqueDAO;
	}

	@Override
	public void addCritique(Critique critique) {
		critiqueDAO.addCritique(critique);
	}

	@Override
	public Result showCritiqueByPage(int AId, Page page) {
		page = PageUtil.createPage(page,critiqueDAO.queryCritiqueCount(AId));
		List<Critique> list = critiqueDAO.queryByPage(AId, page);
		Result result = new Result();
		result.setPage(page);
		result.setList(list);
		return result;
	}

	@Override
	public int getCritiqueCount(int AId) {
		return critiqueDAO.queryCritiqueCount(AId);
	}
}
