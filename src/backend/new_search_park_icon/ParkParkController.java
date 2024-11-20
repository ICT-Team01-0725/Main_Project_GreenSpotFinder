package com.ict.project.parkpark.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.ict.project.parkpark.vo.ParkParkVO;

@Controller
public class ParkParkController {

    @Autowired
    private com.ict.project.parkpark.service.ParkParkService parkParkService;

    // 카테고리별 공원 목록 조회
    @GetMapping("/parks")
    public String getParksByCategory(@RequestParam(defaultValue = "어린이공원") String category, 
                                      @RequestParam(defaultValue = "1") int page, 
                                      HttpServletRequest request) {
        
        // 페이지당 공원 수
        int pageSize = 4;
        
        // 페이지 그룹에 표시할 최대 페이지 수
        int pageGroupSize = 5;
        
        // 페이지 처리 로직
        List<ParkParkVO> parks = parkParkService.getParksByCategory(category, page, pageSize);
        
        // 총 공원 수
        int totalParks = parkParkService.getTotalParksByCategory(category);
        
        // 총 페이지 수 계산
        int totalPages = (int) Math.ceil((double) totalParks / pageSize);
        
        // 현재 페이지 그룹의 첫 페이지와 끝 페이지 계산
        int pageGroupStart = ((page - 1) / pageGroupSize) * pageGroupSize + 1;
        int pageGroupEnd = Math.min(pageGroupStart + pageGroupSize - 1, totalPages);
        
        // 이전, 다음 그룹 존재 여부
        boolean prevGroup = pageGroupStart > 1;
        boolean nextGroup = pageGroupEnd < totalPages;
        
        // 첫 페이지 그룹(1~5, 6~10 등)
        int firstGroupStart = 1;
        int lastGroupStart = (totalPages / pageGroupSize) * pageGroupSize + 1;
        
        // 이전 그룹의 첫 번째 페이지
        int prevGroupStart = Math.max(pageGroupStart - pageGroupSize, 1);

        // 모델에 데이터 추가
        request.setAttribute("parks", parks);
        request.setAttribute("category", category);
        request.setAttribute("currentPage", page);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("pageGroupStart", pageGroupStart);
        request.setAttribute("pageGroupEnd", pageGroupEnd);
        request.setAttribute("prevGroup", prevGroup);
        request.setAttribute("nextGroup", nextGroup);
        request.setAttribute("firstGroupStart", firstGroupStart);
        request.setAttribute("lastGroupStart", lastGroupStart);
        request.setAttribute("prevGroupStart", prevGroupStart);
        
        // parks 데이터를 JSON으로 변환하여 JSP로 전달
        String parksJson = new Gson().toJson(parks); // Gson을 이용한 JSON 변환
        request.setAttribute("parksJson", parksJson);
        
        return "sub/sub1-3"; // JSP로 이동
    }
}
