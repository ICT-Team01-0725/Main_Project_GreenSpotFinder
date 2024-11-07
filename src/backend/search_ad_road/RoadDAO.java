package com.ict.edu.roaddao;

import java.util.List;

import com.ict.edu.roadvo.RoadVO;

public interface RoadDAO {
	// 가로수길 목록 조회
	List<RoadVO> getRoadList();
	
	// 도로명으로 가로수길 검색
	List<RoadVO> searchRoadsByAddress(String searchKeyword);
}
