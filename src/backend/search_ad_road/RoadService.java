package com.ict.edu.roadservice;

import java.util.List;

import com.ict.edu.roadvo.RoadVO;

public interface RoadService{
	// 가로수길 목록 조회
	List<RoadVO> getRoadList();
	
	// 도로명 검색으로 가로수길 검색
	List<RoadVO> searchRoadsByAddress(String searchKeyword);
}
