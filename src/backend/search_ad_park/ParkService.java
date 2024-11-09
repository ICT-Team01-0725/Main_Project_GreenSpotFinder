package com.ict.edu.parkservice;

import java.util.List;

import com.ict.edu.parkvo.ParkVO;

public interface ParkService {
	
	// 첫 화면에 공원 리스트 4개 가나다 순으로 가져오기
    List<ParkVO> getTop4Parks();

    // 주소로 공원 검색하기
    List<ParkVO> searchParks(String p_ad);
}