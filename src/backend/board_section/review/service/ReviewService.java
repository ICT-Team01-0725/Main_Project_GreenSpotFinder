package com.ict.project.review.service;

import java.util.List;

import com.ict.project.review.vo.ReviewVO;



public interface ReviewService {
	
	public int getReviewCount();
	
	public List<ReviewVO> getReviewList(int offset, int limit);
	
	public ReviewVO getReviewDetail(String idx);
	
	public int getReviewInsert(ReviewVO rvo);
	
	public int getReviewUpdate(ReviewVO rvo);
	
	public int getReviewDelete(String idx);
}
