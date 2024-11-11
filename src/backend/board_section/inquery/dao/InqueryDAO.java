package com.ict.project.inquery.dao;

import java.util.List;

import com.ict.project.inquery.vo.InqueryVO;


public interface InqueryDAO {
	
	public int getInqueryCount();
	
	public List<InqueryVO> getInqueryList(int offset, int limit);
	
	public InqueryVO getInqueryDetail(String idx);
	
	public int getInqueryInsert(InqueryVO ivo);
	
	public int getInqueryUpdate(InqueryVO ivo);
	
	public int getInqueryDelete(String idx);
	
	public int getAdminUpdate(InqueryVO ivo);
}
