package com.ict.project.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.project.review.dao.ReviewDAO;
import com.ict.project.review.vo.ReviewVO;


@Service
public class ReviewServiceImpl implements ReviewService{
	
	@Autowired
	private ReviewDAO reviewDAO; 

	@Override
	public List<ReviewVO> getReviewList(int offset, int limit) {
		return reviewDAO.getReviewList(offset, limit);
	}

	@Override
	public ReviewVO getReviewDetail(String idx) {
		return reviewDAO.getReviewDetail(idx);
	}

	@Override
	public int getReviewInsert(ReviewVO rvo) {
		return reviewDAO.getReviewInsert(rvo);
	}

	@Override
	public int getReviewUpdate(ReviewVO rvo) {
		return reviewDAO.getReviewUpdate(rvo);
	}

	@Override
	public int getReviewDelete(String idx) {
		return reviewDAO.getReviewDelete(idx);
	}

	@Override
	public int getReviewCount() {
		return reviewDAO.getReviewCount();
	}

}
