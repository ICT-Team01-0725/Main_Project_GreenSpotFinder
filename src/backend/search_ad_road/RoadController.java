package com.ict.edu.roadcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ict.edu.roadservice.RoadService;
import com.ict.edu.roadvo.RoadVO;

@Controller
public class RoadController {
	
	@Autowired
	private RoadService roadService;
	
	
	// 가로수길 목록조회
	@RequestMapping("/index")
	public ModelAndView showRoadList() {
		ModelAndView mv = new ModelAndView("index"); 
		List<RoadVO> roadList = roadService.getRoadList(); // 모든 가로수길 목록 조회
		mv.addObject("roadList", roadList);
		return mv;
	}
	// 가로수길 검색 처리
	@RequestMapping("/searchRoads")
	public ModelAndView searchRoads(@RequestParam(value = "searchKeyword", required = false) String searchKeyword) {
	ModelAndView mv = new ModelAndView("index");
		// 'searchKeyword' 파라미터가 없으면 전체 가로수길 목록을 가져옴
		   if (searchKeyword == null || searchKeyword.trim().isEmpty()) {
	            searchKeyword = "";  // 기본값 설정
	        }
		   
		   // 도로구간으로 가로수길 검색
	        List<RoadVO> roadList = roadService.searchRoadsByAddress(searchKeyword);  // 도로명으로 가로수길 검색
	        
	        mv.addObject("roadList", roadList);
	        mv.addObject("searchKeyword", searchKeyword);  // 검색어를 다시 텍스트박스에 보이도록
	        return mv;
	    }
	}