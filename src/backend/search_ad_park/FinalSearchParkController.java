package com.ict.edu.finalsearchparkcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ict.edu.finalsearchparkservice.FinalSearchParkService;
import com.ict.edu.finalsearchparkvo.FinalSearchParkVO;

@Controller
@RequestMapping("/finalsearchpark")
public class FinalSearchParkController {

    @Autowired
    private FinalSearchParkService finalSearchParkService;

    // 메인 화면으로 리다이렉트
    @GetMapping("/")
    public String redirectToMain() {
        return "redirect:/finalsearchpark/main";
    }

    // 메인 화면 표시 (기본 화면에 지역별 공원 리스트를 보여주는 부분)
    @GetMapping("/main")
    public ModelAndView showMainPage() {
        ModelAndView mv = new ModelAndView("sub2-2"); // JSP 뷰 이름
        List<FinalSearchParkVO> parkList = finalSearchParkService.searchParkByRegion("서울"); // 기본적으로 서울 데이터 가져오기
        mv.addObject("parkList", parkList);
        return mv;
    }

    // 지역별로 공원 검색
    @GetMapping("/findParkByRegion")
    public ModelAndView findParkByRegion(@RequestParam("region") String region) {
        ModelAndView mv = new ModelAndView("sub2-2"); // 결과를 보여줄 JSP 페이지
        List<FinalSearchParkVO> parkList = finalSearchParkService.searchParkByRegion(region);
        mv.addObject("parkList", parkList);
        mv.addObject("region", region); // 선택된 지역을 넘겨서 표시
        return mv;
    }

    // 주소로 공원 검색
    @GetMapping("/searchParkByAddress")
    public ModelAndView searchParkByAddress(@RequestParam(value = "address", required = false) String address) {
        ModelAndView mv = new ModelAndView("sub2-2");

        // 주소로 공원 검색
        if (address != null && !address.isEmpty()) {
            List<FinalSearchParkVO> searchResult = finalSearchParkService.searchParkByAddress(address);
            mv.addObject("parkList", searchResult);
        } else {
            mv.addObject("parkList", null); // 검색 결과 없음
        }

        return mv;
    }
}