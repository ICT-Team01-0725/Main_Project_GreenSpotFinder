package com.ict.edu.parkparkdao;

import java.util.List;

import com.ict.edu.parkparkvo.ParkParkVO;

public interface ParkParkDAO {
	
	 // 카테고리별 공원 목록을 페이지 처리를 해서 가져오기
    List<ParkParkVO> getParksByCategory(String category, int offset, int pageSize);

    // 카테고리에 해당하는 공원 수 가져오기
    int getTotalParksByCategory(String category);
}