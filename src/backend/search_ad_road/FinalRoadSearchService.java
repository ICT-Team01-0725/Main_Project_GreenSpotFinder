package com.ict.edu.finalroadsearchservice;

import java.util.List;

import com.ict.edu.finalroadsearchvo.FinalRoadSearchVO;

public interface FinalRoadSearchService {
    // 지역명으로 가로수길 검색
    List<FinalRoadSearchVO> searchRoadByAddress(String r_ce_ad);

    // 지역별 가로수길 검색
    List<FinalRoadSearchVO> searchRoadByRegion(String region);
}