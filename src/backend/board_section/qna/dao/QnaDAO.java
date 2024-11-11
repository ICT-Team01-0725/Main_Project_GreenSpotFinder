package com.ict.project.qna.dao;

import java.util.List;

import com.ict.project.qna.vo.QnaVO;


public interface QnaDAO {
	
	public int getQnaCount();
	
	public List<QnaVO> getQnaList(int offset, int limit);
	
	public QnaVO getQnaDetail(String q_idx);
	
	public int getQnaInsert(QnaVO qvo);
	
	public int getQnaUpdate(QnaVO qvo);
	
	public int getQnaDelete(String q_idx);
	
	public List<QnaVO> getQnaUserList(String u_idx, int offset, int limit);
	
	public int getQnaUserCount(String u_idx);

	}
