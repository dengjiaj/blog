package com.sanqing.dao;

import com.sanqing.po.Dianjiliang;

import java.util.Date;
import java.util.List;

public interface DianjiliangDAO {
	
	//���ظ����£���IP����ʱ��ķ��ʼ�¼
	public List queryByAId(int AId,String IP,Date time);
	
	//��ӷ��ʼ�¼
	public void addJilu(Dianjiliang dianjiliang);
}
