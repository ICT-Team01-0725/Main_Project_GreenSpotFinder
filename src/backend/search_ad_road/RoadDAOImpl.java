package com.ict.edu.roaddao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.edu.roadvo.RoadVO;

@Repository
public class RoadDAOImpl implements RoadDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	// 가로수길 목록 조회
	@Override
	public List<RoadVO> getRoadList() {
		return sqlSessionTemplate.selectList("road-mapper.getRoadList");
	}
	
	// 도로명으로 가로수길 검색
	@Override
	public List<RoadVO> searchRoadsByAddress(String searchKeyword) {
		return sqlSessionTemplate.selectList("road-mapper.searchRoadsByAddress", "%" + searchKeyword + "%");
		}
}
