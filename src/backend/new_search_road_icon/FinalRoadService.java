package com.ict.edu.finalroadservice;

import java.util.List;

import com.ict.edu.finalroadvo.FinalRoadVO;

public interface FinalRoadService {
    
    // 나무 종류에 맞는 도로 리스트를 페이지별로 반환
    List<FinalRoadVO> getRoadsByTreeType(String type, int page, int pageSize);

    // 나무 종류에 해당하는 총 도로 수를 반환
    int getTotalRoadsByTreeType(String type);
    
    // 페이지 수 계산
    int getTotalPages(int totalItems, int pageSize);
}