package com.ict.project.admin.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.project.admin.dao.AdminDAO;
import com.ict.project.admin.vo.AdminVO;
import com.ict.project.comment.service.CommentService;
import com.ict.project.fna.service.FnaService;
import com.ict.project.inquery.service.InqueryService;
import com.ict.project.login.service.LoginService;
import com.ict.project.notice.service.NoticeService;
import com.ict.project.qna.service.QnaService;
import com.ict.project.review.service.ReviewService;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDAO adminDAO;
	@Autowired
	private LoginService loginService;
	@Autowired
	private QnaService qnaService;
	@Autowired
	private FnaService fnaService;
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private InqueryService inqueryService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private ReviewService reviewService;
	
	@Override
	public List<AdminVO> adminList(int offset, int limit) {
		return adminDAO.adminList(offset, limit);
	}

	@Override
	public int adminUpdate(AdminVO avo) {
		return adminDAO.adminUpdate(avo);
	}

	@Override
	public int adminDelete(AdminVO lvo) {
		return adminDAO.adminDelete(lvo);
	}

	@Override
	public int adminInsert(AdminVO lvo) {
		return adminDAO.adminInsert(lvo);
	}

	@Override
	public AdminVO adminDetail(String u_idx) {
		return adminDAO.adminDetail(u_idx);
	}

	@Override
	public int adminCount() {
		return adminDAO.adminCount();
	}
	
	@Override
	public LoginService loginService() {
		return loginService;
	}

	@Override
	public QnaService qnaService() {
		return qnaService;
	}

	@Override
	public FnaService fnaService() {
		return fnaService;
	}

	@Override
	public NoticeService noticeService() {
		return noticeService;
	}

	@Override
	public InqueryService inqueryService() {
		return inqueryService;
	}

	@Override
	public CommentService commentService() {
		return commentService;
	}

	@Override
	public ReviewService reviewService() {
		return reviewService;
	}


	
}
