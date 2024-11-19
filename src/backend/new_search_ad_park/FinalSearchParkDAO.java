package com.ict.edu.finalsearchparkdao;

import java.util.List;

import com.ict.edu.finalsearchparkvo.FinalSearchParkVO;

public interface FinalSearchParkDAO {

    // 주소로 공원 검색
    List<FinalSearchParkVO> searchParkByAddress(String p_ad);

    // 지역별 공원 검색
    List<FinalSearchParkVO> searchParkByRegion(String region);
}