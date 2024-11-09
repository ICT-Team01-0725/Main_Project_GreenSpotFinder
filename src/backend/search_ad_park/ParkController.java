package com.ict.edu.parkcontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ict.edu.parkservice.ParkService;
import com.ict.edu.parkvo.ParkVO;

@Controller
@RequestMapping("/park")
public class ParkController {

	 @Autowired
	    private ParkService parkService;

	    // 첫 화면에 가나다순으로 공원 4개의 리스트를 가져오기
	    @GetMapping("/main")  
	    public String showParkList(HttpServletRequest request) {
	        // 첫 화면에 공원 4개 가져오기
	        List<ParkVO> top4Parks = parkService.getTop4Parks();  // getTop4Parks 호출

	        // request 객체에 parkList를 담아 JSP로 전달
	        request.setAttribute("parkList", top4Parks);

	        return "sub1-2";  // JSP 파일 이름
	    }

	    // 첫 화면인 "/" 경로를 "/park/main"으로 리디렉션
	    @GetMapping("/")  
	    public String redirectToMain() {
	        return "redirect:/park/main";  // "/park/main"으로 리디렉션
	    }

	    // 공원 검색
	    @GetMapping("/searchPark")  // 공원 검색
	    public String searchParks(@RequestParam("p_ad") String p_ad, HttpServletRequest request) {
	        List<ParkVO> searchResult = parkService.searchParks(p_ad);  // 검색 결과 가져오기
	        
	        // 검색 결과를 request 객체에 담아 JSP로 전달
	        request.setAttribute("parkList", searchResult);

	        return "sub1-2";  // 검색 결과 페이지로 이동
	    }
	}