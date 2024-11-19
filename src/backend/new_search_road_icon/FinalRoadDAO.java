package com.ict.edu.finalroaddao;

import java.util.List;

import com.ict.edu.finalroadvo.FinalRoadVO;

public interface FinalRoadDAO {
    
    // 나무 종류별 도로 리스트를 페이지 처리하여 가져오기
    List<FinalRoadVO> getRoadsByTreeType(String type, int offset, int pageSize);

    // 나무 종류에 해당하는 총 도로 수 가져오기
    int getTotalRoadsByTreeType(String type);
}