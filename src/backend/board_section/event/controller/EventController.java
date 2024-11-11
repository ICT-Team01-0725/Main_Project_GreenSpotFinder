package com.ict.project.event.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ict.project.comm.Paging;
import com.ict.project.comm.PagingService;
import com.ict.project.comm.PerPageConstant;
import com.ict.project.event.service.EventService;
import com.ict.project.event.vo.EventVO;

@Controller
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private PagingService pagingService;
	
	
	// 리스트형 검색(페이징 O)
	@RequestMapping("/ev/list")
	public ModelAndView getEventList(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("search/sub4-2");
		
		// pagingservice 메서드에 넣을 값
		int count = eventService.getTotalCount();
		String cPage = request.getParameter("cPage");
		PerPageConstant pageConstant = new PerPageConstant();
		int perpage = pageConstant.getEventpage();
				
		// 페이징 기법
		Paging paging = pagingService.pagingservice(count, cPage, perpage);
		
		// DB 갔다가 오기 
		List<EventVO> list = eventService.getEventList(paging.getOffset(), paging.getNumPerPage());
		
		mv.addObject("list", list);
		mv.addObject("paging", paging);
		return mv;
	}
	
	// 조건문 검색 (현재 쓸모 x)
	@RequestMapping("/ev/search")
	public ModelAndView getEventSearch(HttpServletRequest request, String[] str) {
		ModelAndView mv = new ModelAndView();
		
		// pagingservice 메서드에 넣을 값
		int count = eventService.getTotalCount();
		String cPage = request.getParameter("cPage");
		PerPageConstant pageConstant = new PerPageConstant();
		int perpage = pageConstant.getEventpage();
						
		// 페이징 기법
		Paging paging = pagingService.pagingservice(count, cPage, perpage);
		int offset = paging.getOffset();
		int limit = paging.getNumPerPage();
		
		List<EventVO> list = eventService.getEventSearch(str, offset, limit);
		mv.addObject("list", list);
		
		return mv;
	}
	
	// 전체 검색(캘린더용)
	@RequestMapping("/ev/cal")
	public ModelAndView getEventCalender(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("");
		
		List<EventVO> list = eventService.getEventCalender();
		mv.addObject("list", list);
		
		return mv;
	}
	
	// json을 EventVO에 담아서 화면에 출력
	@RequestMapping("/ev/json")
	public ModelAndView displayEvents() {
		ModelAndView mv = new ModelAndView("sub/sub4-1");
        List<EventVO> events = eventService.loadEvents();
         
        mv.addObject("events", events);
        
        return mv;
    }
}
