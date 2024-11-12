package com.ict.edu.parkdao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.edu.parkvo.ParkVO;

@Repository
public class ParkDAOImpl implements ParkDAO {
	
	  @Autowired
	    private SqlSessionTemplate sqlSessionTemplate;

	    // 공원 검색 (p_ad로 검색)
	    @Override
	    public List<ParkVO> searchParksByAddress(String p_ad) {
	        return sqlSessionTemplate.selectList("park-mapper.searchParks", p_ad);
	    }

	    // 기본 공원 리스트 조회 (가나다순 4개)
	    @Override
	    public List<ParkVO> getTop4Parks() {
	    	System.out.println("데이터2");
	    	return sqlSessionTemplate.selectList("park-mapper.getTop4Parks");
	    }

	    // 지역별 공원 목록 조회
	    @Override
	    public List<ParkVO> getParksByRegion(String region) {
	        return sqlSessionTemplate.selectList("park-mapper.getParksByRegion", region);
	    }
	}
