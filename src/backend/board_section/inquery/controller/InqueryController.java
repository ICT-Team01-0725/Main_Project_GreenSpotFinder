package com.ict.project.inquery.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ict.project.comm.Paging;
import com.ict.project.comm.PagingService;
import com.ict.project.comm.PerPageConstant;
import com.ict.project.inquery.service.InqueryService;
import com.ict.project.inquery.vo.InqueryVO;

@Controller
public class InqueryController {
	
	@Autowired
	private InqueryService inqueryService;
	@Autowired
	private PagingService pagingService;
	
	
	@GetMapping("/inquery/list")
	public ModelAndView getInqueryList(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		
		int count = inqueryService.getInqueryCount();
		// pagingservice 메서드에 넣을 값
		String cPage = request.getParameter("cPage");
		PerPageConstant pageConstant = new PerPageConstant();
		int perpage = pageConstant.getFreeboardpage();
				
		// 페이징 기법 설정
		Paging paging = pagingService.pagingservice(count, cPage, perpage);
		// DB 갔다가 오기 
		List<InqueryVO> list = inqueryService.getInqueryList(paging.getOffset(), paging.getNumPerPage());
		
		mv.addObject("list", list);
		mv.addObject("paging", paging);
		
		return mv;
	}
	
	@PostMapping("/inquery/detail")
	public ModelAndView getInqueryDetail(String idx) {
		ModelAndView mv = new ModelAndView();
		InqueryVO fbvo = inqueryService.getInqueryDetail(idx);
		mv.addObject("fbvo", fbvo);
		return mv;
	}
	
	@PostMapping("/inquery/insert")
	public ModelAndView getInqueryInsert(InqueryVO fbvo) {
		ModelAndView mv = new ModelAndView();
		inqueryService.getInqueryInsert(fbvo);
		return mv;
	}
	
	@PostMapping("/inquery/update")
	public ModelAndView getInqueryUpdate(InqueryVO fbvo) {
		ModelAndView mv = new ModelAndView();
		inqueryService.getInqueryUpdate(fbvo);
		return mv;
	}
	
	@PostMapping("/inquery/delete")
	public ModelAndView getInqueryDelete(String idx) {
		ModelAndView mv = new ModelAndView();
		inqueryService.getInqueryDelete(idx);
		return mv;
	}
	
	@PostMapping("/inquery/admin")
	public ModelAndView getAdminUpdate(InqueryVO ivo) {
		ModelAndView mv = new ModelAndView();
		inqueryService.getAdminUpdate(ivo);
		return mv;
	}
	
}
