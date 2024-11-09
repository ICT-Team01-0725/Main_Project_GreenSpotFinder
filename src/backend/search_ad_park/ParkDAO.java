package com.ict.edu.parkdao;

import java.util.List;

import com.ict.edu.parkvo.ParkVO;

public interface ParkDAO {
    // 주소로 공원 검색
    List<ParkVO> searchParks(String p_ad);

    // 기본 공원 리스트 조회
    List<ParkVO> getTop4Parks();
}