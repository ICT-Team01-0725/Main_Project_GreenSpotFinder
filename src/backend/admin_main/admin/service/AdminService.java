package com.ict.project.admin.service;

import java.util.List;

import com.ict.project.admin.vo.AdminVO;
import com.ict.project.comment.service.CommentService;
import com.ict.project.fna.service.FnaService;
import com.ict.project.inquery.service.InqueryService;
import com.ict.project.login.service.LoginService;
import com.ict.project.notice.service.NoticeService;
import com.ict.project.qna.service.QnaService;
import com.ict.project.review.service.ReviewService;

public interface AdminService {
	
	public List<AdminVO> adminList(int offset, int limit);
	public int adminUpdate(AdminVO avo);
	public int adminDelete(AdminVO avo);
	public int adminInsert(AdminVO avo);
	public AdminVO adminDetail(String a_idx);
	public int adminCount();
	
	LoginService loginService();
	QnaService qnaService();
	FnaService fnaService();
	NoticeService noticeService();
	InqueryService inqueryService();
	CommentService commentService();
	ReviewService reviewService();
}
