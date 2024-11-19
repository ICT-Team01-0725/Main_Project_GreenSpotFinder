package com.ict.edu.finalroadcontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.ict.edu.finalroadservice.FinalRoadService;
import com.ict.edu.finalroadvo.FinalRoadVO;


@Controller
public class FinalRoadController {

    @Autowired
    private FinalRoadService finalRoadService;

    // 카테고리별 나무 리스트 조회
    @GetMapping("/roads")
    public String getRoadsByTreeType(@RequestParam(defaultValue = "벚나무") String type, 
                                      @RequestParam(defaultValue = "1") int page, 
                                      HttpServletRequest request) {

        // 페이지당 가로수길 결과의 수
        int pageSize = 4;
        
        // 페이지 그룹에 표시할 최대 페이지 수
        int pageGroupSize = 5;
        
        // 페이지 처리 로직
        List<FinalRoadVO> roads = finalRoadService.getRoadsByTreeType(type, page, pageSize);
        
        // 총 가로수길 수
        int totalRoads = finalRoadService.getTotalRoadsByTreeType(type);
        
        // 총 페이지 수 계산
        int totalPages = (int) Math.ceil((double) totalRoads / pageSize);
        
        // 현재 페이지 그룹의 첫 페이지와 끝 페이지 계산
        int pageGroupStart = ((page - 1) / pageGroupSize) * pageGroupSize + 1;
        int pageGroupEnd = Math.min(pageGroupStart + pageGroupSize - 1, totalPages);
        
        // 이전, 다음 그룹 존재 여부
        boolean prevGroup = pageGroupStart > 1;
        boolean nextGroup = pageGroupEnd < totalPages;
        
        // 첫 페이지 그룹(1~5, 6~10 등)
        int firstGroupStart = 1;
        int lastGroupStart = (totalPages / pageGroupSize) * pageGroupSize + 1;

        // 모델에 데이터 추가
        request.setAttribute("roads", roads);
        request.setAttribute("type", type);
        request.setAttribute("currentPage", page);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("pageGroupStart", pageGroupStart);
        request.setAttribute("pageGroupEnd", pageGroupEnd);
        request.setAttribute("prevGroup", prevGroup);
        request.setAttribute("nextGroup", nextGroup);
        request.setAttribute("firstGroupStart", firstGroupStart);
        request.setAttribute("lastGroupStart", lastGroupStart);
        
        // roads 데이터를 JSON으로 변환하여 JSP로 전달
        String roadsJson = new Gson().toJson(roads);
        request.setAttribute("roadsJson", roadsJson);
        
        return "sub2-4"; 
    }
}
