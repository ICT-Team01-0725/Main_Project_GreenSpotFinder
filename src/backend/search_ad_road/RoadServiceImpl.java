package com.ict.edu.roadservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.edu.roaddao.RoadDAO;
import com.ict.edu.roadvo.RoadVO;

@Service
public class RoadServiceImpl implements RoadService{

	@Autowired
	private RoadDAO roadDAO;
	
    @Override
    public List<RoadVO> getRoadList() {
    	// 모든 가로수길 목록 자져오기
        return roadDAO.getRoadList(); 
    }

    @Override
    public List<RoadVO> searchRoadsByAddress(String searchKeyword) {
    	// 도로명으로 검색
        return roadDAO.searchRoadsByAddress(searchKeyword);  
    }
    
}
