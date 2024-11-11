package com.ict.project.fna.controller;

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
import com.ict.project.fna.service.FnaService;
import com.ict.project.fna.vo.FnaVO;

@Controller
public class FnaController {
	
	@Autowired
	private FnaService fnaService;
	@Autowired
	private PagingService pagingService;
	
	
	@GetMapping("/fna/list")
	public ModelAndView getFnaList(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		
		int count = fnaService.getFnaCount();
		// pagingservice 메서드에 넣을 값
		String cPage = request.getParameter("cPage");
		PerPageConstant pageConstant = new PerPageConstant();
		int perpage = pageConstant.getFnapage();
				
		// 페이징 기법 설정
		Paging paging = pagingService.pagingservice(count, cPage, perpage);
		// DB 갔다가 오기 
		List<FnaVO> list = fnaService.getFnaList(paging.getOffset(), paging.getNumPerPage());
		
		mv.addObject("list", list);
		mv.addObject("paging", paging);
		
		return mv;
	}
	
	@PostMapping("/fna/detail")
	public ModelAndView getFnaDetail(String idx) {
		ModelAndView mv = new ModelAndView();
		FnaVO fvo = fnaService.getFnaDetail(idx);
		mv.addObject("fvo", fvo);
		return mv;
	}
	
	@PostMapping("/fna/insert")
	public ModelAndView getFnaInsert(FnaVO fvo) {
		ModelAndView mv = new ModelAndView();
		fnaService.getFnaInsert(fvo);
		return mv;
	}
	
	@PostMapping("/fna/update")
	public ModelAndView getFnaUpdate(FnaVO fvo) {
		ModelAndView mv = new ModelAndView();
		fnaService.getFnaUpdate(fvo);
		return mv;
	}
	
	@PostMapping("/fna/delete")
	public ModelAndView getFnaDelete(String idx) {
		ModelAndView mv = new ModelAndView();
		fnaService.getFnaDelete(idx);
		return mv;
	}
	
}
