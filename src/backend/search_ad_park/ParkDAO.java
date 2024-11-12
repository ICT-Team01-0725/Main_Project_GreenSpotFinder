package com.ict.edu.parkdao;

import java.util.List;

import com.ict.edu.parkvo.ParkVO;

public interface ParkDAO {
    // 주소로 공원 검색
    List<ParkVO> searchParksByAddress(String p_ad);

    // 기본 공원 리스트 조회
    List<ParkVO> getTop4Parks();
    
    // 지역별 공원 목록 조회
    List<ParkVO> getParksByRegion(String region);
}
