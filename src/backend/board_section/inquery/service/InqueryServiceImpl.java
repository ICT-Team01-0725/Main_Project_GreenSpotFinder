package com.ict.project.inquery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.project.inquery.dao.InqueryDAO;
import com.ict.project.inquery.vo.InqueryVO;



@Service
public class InqueryServiceImpl implements InqueryService{
	
	@Autowired
	private InqueryDAO inqueryDAO;

	@Override
	public List<InqueryVO> getInqueryList(int offset, int limit) {
		return inqueryDAO.getInqueryList(offset, limit);
	}

	@Override
	public InqueryVO getInqueryDetail(String idx) {
		return inqueryDAO.getInqueryDetail(idx);
	}

	@Override
	public int getInqueryInsert(InqueryVO ivo) {
		return inqueryDAO.getInqueryInsert(ivo);
	}

	@Override
	public int getInqueryUpdate(InqueryVO ivo) {
		return inqueryDAO.getInqueryUpdate(ivo);
	}

	@Override
	public int getInqueryDelete(String idx) {
		return inqueryDAO.getInqueryDelete(idx);
	}

	@Override
	public int getInqueryCount() {
		return inqueryDAO.getInqueryCount();
	}

	@Override
	public int getAdminUpdate(InqueryVO ivo) {
		return inqueryDAO.getAdminUpdate(ivo);
	}

}
