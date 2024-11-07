package com.ict.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ict.edu.service.roadService;
import com.ict.edu.vo.roadVO;

@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
	private roadService roadService;


	@GetMapping("searchRoad")
	public ModelAndView searchParks(@RequestParam(value = "searchKeyword", required = false) String searchKeyword) {
		
		ModelAndView mv = new ModelAndView("/index"); 
		
		if (searchKeyword == null || searchKeyword.trim().isEmpty()) {
		    System.out.println("값이 없다");
		} else {
		    System.out.println("검색어: " + searchKeyword);
		}
		
		
		
		List<roadVO> roadList = roadService.roadSearchByAddress(searchKeyword); 
		
		mv.addObject("roadList", roadList);
		mv.addObject("searchKeyword", searchKeyword); 
		
		return mv;
	}

}
