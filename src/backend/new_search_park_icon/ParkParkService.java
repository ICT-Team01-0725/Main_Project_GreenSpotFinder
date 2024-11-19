package com.ict.edu.parkparkservice;

import java.util.List;

import com.ict.edu.parkparkvo.ParkParkVO;

public interface ParkParkService {
	
	 // 카테고리에 맞는 공원 목록을 페이지별로 반환
    List<ParkParkVO> getParksByCategory(String category, int page, int pageSize);

    // 카테고리에 해당하는 총 공원 수를 반환
    int getTotalParksByCategory(String category);
    
    // 페이지 수 계산
    int getTotalPages(int totalItems, int pageSize);
}
