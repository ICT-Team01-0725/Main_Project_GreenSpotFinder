package com.ict.edu.finalroadsearchcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ict.edu.finalroadsearchservice.FinalRoadSearchService;
import com.ict.edu.finalroadsearchvo.FinalRoadSearchVO;


@Controller
@RequestMapping("/finalroadsearch")
public class FinalRoadSearchController {

    @Autowired
    private FinalRoadSearchService finalRoadSearchService;

    // 메인 화면으로 리다이렉트
    @GetMapping("/")
    public String redirectToMain() {
        return "redirect:/finalroadsearch/main";
    }

    // 메인 화면 표시 (기본 화면에 지역별 가로수길 리스트를 보여주는 부분)
    @GetMapping("/main")
    public ModelAndView showMainPage() {
        ModelAndView mv = new ModelAndView("sub2-2"); // JSP 뷰 이름
        List<FinalRoadSearchVO> roadList = finalRoadSearchService.searchRoadByRegion("서울"); // 기본적으로 서울 데이터 가져오기
        mv.addObject("roadList", roadList);
        return mv;
    }

    // 지역별로 가로수길 검색
    @GetMapping("/findRoadByRegion")
    public ModelAndView findRoadByRegion(@RequestParam("region") String region) {
        ModelAndView mv = new ModelAndView("sub2-2"); // 결과를 보여줄 JSP 페이지
        List<FinalRoadSearchVO> roadList = finalRoadSearchService.searchRoadByRegion(region);
        mv.addObject("roadList", roadList);
        mv.addObject("region", region); // 선택된 지역을 넘겨서 표시
        return mv;
    }

    // 가로수길 검색 (주소로 검색)
    @GetMapping("/searchRoadByAddress")
    public ModelAndView searchRoadByAddress(@RequestParam(value = "address", required = false) String address) {
        ModelAndView mv = new ModelAndView("sub2-2");

        // 주소로 검색
        if (address != null && !address.isEmpty()) {
            // 주소에 해당하는 가로수길을 서비스에서 처리하여 반환
            List<FinalRoadSearchVO> searchResult = finalRoadSearchService.searchRoadByAddress(address);
            mv.addObject("roadList", searchResult);
        } else {
            // 주소가 비어있을 경우 빈 리스트 반환
            mv.addObject("roadList", new ArrayList<>());
        }

        return mv;
    }

    // 시각화 페이지를 위한 링크 (지도를 표시하는 페이지)
    @GetMapping("/visual")
    public String showRoadVisual() {
        return "road_visual_D3_leaflet.html"; // 지도 시각화를 위한 HTML 파일
    }

}