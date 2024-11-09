package com.ict.project.searchlist.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ict.project.comm.Paging;
import com.ict.project.searchlist.service.SearchListService;
import com.ict.project.searchlist.vo.TreeVO;

@Controller
public class SearchListController {
	// search / sub3-3
	@Autowired
	private SearchListService searchListService;
	
	@Autowired
	private Paging paging;
	
	
	
	// 리스트 불러오기(페이징)
	@RequestMapping("/treelist")
	public ModelAndView getTreeList(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("search/sub3-3");
		int count = searchListService.getTotalCount();
		// 총 데이터 갯수
		paging.setTotalRecord(count);
		
		// 총 데이터 수가 페이지당 데이터 수보다 작으면
		if(paging.getTotalRecord() <= paging.getNumPerPage()) {
			// 최대 페이지를 1로 만듬
			paging.setTotalPage(1);
		}else {
			// 총 데이터 수를 페이지당 데이터 수로 나눠서 총합 페이지수를 구하고
			paging.setTotalPage(paging.getTotalRecord() / paging.getNumPerPage());
			// 페이지당 데이터 수로 나눴을때 나머지가 발생하면
			if(paging.getTotalRecord() % paging.getNumPerPage() != 0) {
				// 총합 페이지수를 하나 더 늘린다.
				paging.setTotalPage(paging.getTotalPage() + 1 );
			}
		}
		// cpage는 페이지값을 파라미터로 받는값
		String cPage = request.getParameter("cPage");
		// cpage값이 없으면
		if(cPage == null) {
			// 현재 페이지를 1로 설정
			paging.setNowPage(1);
		}else {
			// 현재 페이지를 cpage 설정
			paging.setNowPage(Integer.parseInt(cPage));
		}
		
		// 현재 블럭을 구한다
		paging.setNowBlock((paging.getNowPage()-1)/paging.getPagePerBlock()+1);
		
		// offset(DB에서 값을 가져올때 지나간 데이터(현재 2페이지일때 1페이지데이터)를 넘기는 갯수
		// 페이지당 데이터 수와 현재 페이지 -1 만큼 offset을 설정 
		paging.setOffset(paging.getNumPerPage() * (paging.getNowPage()-1));
		
		// 시작 블럭 세팅
		paging.setBeginBlock(
				// 현재 블럭의 index값에 블럭당 페이지값을 곱해주고 그다음에 1을 더한다.
				(int)((paging.getNowBlock()-1) * paging.getPagePerBlock()+1));
		// 마지막 블럭은 시작블럭에 블럭당 페이지수를 더하고 1을 빼준다.
		paging.setEndBlock(paging.getNowBlock()*paging.getPagePerBlock());
		
		// 만약 마지막 블럭이 총 페이지보다 크면
		if(paging.getEndBlock() >  paging.getTotalPage()) {
			// 마지막 블럭을 총 페이지값으로 한다.
			paging.setEndBlock(paging.getTotalPage());
		}
		
		
		// DB 갔다가 오기 
		List<TreeVO> list = searchListService.getTreeList(paging.getOffset(), paging.getNumPerPage());
		
		mv.addObject("list", list);
		mv.addObject("paging", paging);
		return mv;
		

	}
}
