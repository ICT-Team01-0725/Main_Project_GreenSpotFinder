package com.ict.project.qna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.project.qna.dao.QnaDAO;
import com.ict.project.qna.vo.QnaVO;


@Service
public class QnaServiceImpl implements QnaService{
	
	@Autowired
	private QnaDAO qnaDAO; 

	@Override
	public List<QnaVO> getQnaList(int offset, int limit) {
		return qnaDAO.getQnaList(offset, limit);
	}

	@Override
	public QnaVO getQnaDetail(String idx) {
		return qnaDAO.getQnaDetail(idx);
	}

	@Override
	public int getQnaInsert(QnaVO qvo) {
		return qnaDAO.getQnaInsert(qvo);
	}

	@Override
	public int getQnaUpdate(QnaVO qvo) {
		return qnaDAO.getQnaUpdate(qvo);
	}

	@Override
	public int getQnaDelete(String idx) {
		return qnaDAO.getQnaDelete(idx);
	}

	@Override
	public int getQnaCount() {
		return qnaDAO.getQnaCount();
	}

	@Override
	public List<QnaVO> getQnaUserList(String u_idx, int offset, int limit) {
		return qnaDAO.getQnaUserList(u_idx, offset, limit);
	}

	@Override
	public int getQnaUserCount(String u_idx) {
		return qnaDAO.getQnaUserCount(u_idx);
	}

}
