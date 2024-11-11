package com.ict.project.qna.service;

import javax.servlet.http.HttpServletRequest;

import com.ict.project.qna.vo.QnaVO;

public interface QnaFileService {
	public QnaVO qnaFileUpload(HttpServletRequest request, QnaVO qvo);
	
	public QnaVO qnaFileUpdate(HttpServletRequest request, QnaVO qvo);
	
	public void qnaFileDelete(HttpServletRequest request, QnaVO qvo);
}
