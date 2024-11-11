package com.ict.project.comment.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ict.project.comm.Paging;
import com.ict.project.comm.PagingService;
import com.ict.project.comment.service.CommentService;
import com.ict.project.comment.vo.CommentVO;

@Controller
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private PagingService pagingService;
	
	@PostMapping("/comment/delete")
	public ModelAndView commentDelete(CommentVO cvo, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		String cPage = String.valueOf(request.getAttribute("cPage"));
		int count = (int)request.getAttribute("count");
		int perpage = (int)request.getAttribute("perpage");
		
		String c_idx = cvo.getC_idx();
		commentService.getCommentDelete(c_idx);
		
		Paging paging = pagingService.pagingservice(count, cPage, perpage);
		mv.addObject("paging",paging);
		mv.setViewName(cvo.getC_bor()+"");
		return mv;
	}
}
