package com.ict.edu.parkdao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	    public List<ParkVO> searchParks(String p_ad) {
	        Map<String, Object> params = new HashMap<>();
	        params.put("p_ad", "%" + p_ad + "%");

	        return sqlSessionTemplate.selectList("park-mapper.searchParks", params);
	    }

	    // 기본 공원 리스트 조회 (가나다순 4개)
	    @Override
	    public List<ParkVO> getTop4Parks() {
	        return sqlSessionTemplate.selectList("park-mapper.getTop4Parks");
	}
}