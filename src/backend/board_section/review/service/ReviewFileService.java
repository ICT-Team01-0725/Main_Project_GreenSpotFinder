package com.ict.project.review.service;

import javax.servlet.http.HttpServletRequest;

import com.ict.project.review.vo.ReviewVO;

public interface ReviewFileService {
	public ReviewVO reviewFileUpload(HttpServletRequest request, ReviewVO rvo);
	
	public ReviewVO reviewFileUpdate(HttpServletRequest request, ReviewVO rvo);
}
