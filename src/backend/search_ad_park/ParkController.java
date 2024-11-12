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
@RequestMapping("/park")
public class ParkController {

	  @Autowired
	    private ParkService parkService;

	// 첫 화면에 공원 4개 가져오기 (가나다순)
	  @GetMapping("/main")
	  public ModelAndView showParkList() {
	      ModelAndView mv = new ModelAndView("sub1-2");  // 첫 화면을 위한 JSP 파일
	      List<ParkVO> parkList = parkService.getTop4Parks();  // 첫 화면에 공원 4개 가져오기
	      mv.addObject("parkList", parkList);  // parkList를 JSP로 전달
	      mv.addObject("isFirstVisit", true);  // 첫 방문 여부 표시
	      return mv;
	  }

	  @GetMapping("/searchPark")
	  public String searchPark(@RequestParam(value = "p_ad", required = false) String p_ad, Model model) {
	      if (p_ad == null || p_ad.trim().isEmpty()) {
	          model.addAttribute("isFirstVisit", true);  // 첫 방문 시에는 검색 없이 공원 4개만
	          return "sub1-2";  // 첫 화면으로 리턴
	      }

	      List<ParkVO> searchResults = parkService.searchParksByAddress(p_ad);  // 주소로 공원 검색
	      model.addAttribute("parkList", searchResults);
	      model.addAttribute("isFirstVisit", false);  // 검색 결과 화면
	      return "sub1-2";  // 검색 결과를 동일한 JSP에서 처리
	  }

	    // 지역별 공원 목록 조회
	    @GetMapping("/findPark")
	    public ModelAndView findPark(@RequestParam("region") String region) {
	        List<ParkVO> parksInRegion = parkService.getParksByRegion(region);
	        ModelAndView mv = new ModelAndView("sub1-2");
	        mv.addObject("parkList", parksInRegion);  // parkList를 JSP로 전달
	        return mv;
	    }
	}
