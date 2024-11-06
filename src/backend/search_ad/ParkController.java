package com.ict.edu.parkcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ict.edu.parkservice.ParkService;
import com.ict.edu.parkvo.ParkVO;

@Controller
public class ParkController {

	 @Autowired
	    private ParkService parkService;

	    // 공원 목록 조회
	    @RequestMapping("/index")
	    public ModelAndView showParkList() {
	        ModelAndView mav = new ModelAndView("index");  // index.jsp로 이동
	        List<ParkVO> parkList = parkService.getParkList();  // 모든 공원 목록 조회
	        mav.addObject("parkList", parkList);
	        return mav;
	    }

	    // 공원 검색 처리
	    @RequestMapping("/searchParks")
	    public ModelAndView searchParks(@RequestParam(value = "searchKeyword", required = false) String searchKeyword) {
	        ModelAndView mav = new ModelAndView("index");  // 검색 후에도 index.jsp로 이동
	        // 'searchKeyword' 파라미터가 없으면 전체 공원 목록을 불러옵니다.
	        if (searchKeyword == null || searchKeyword.trim().isEmpty()) {
	            searchKeyword = "";  // 기본값 설정
	        }
	        List<ParkVO> parkList = parkService.searchParksByAddress(searchKeyword);  // 주소로 공원 검색
	        mav.addObject("parkList", parkList);
	        mav.addObject("searchKeyword", searchKeyword);  // 검색어를 다시 텍스트박스에 보이도록
	        return mav;
	    }

	}