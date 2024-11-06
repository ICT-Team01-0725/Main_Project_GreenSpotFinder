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
	
	@Override
	public List<ParkVO> getParkList() {
		return sqlSessionTemplate.selectList("park-mapper.getParkList");
	}
	
	@Override
	public List<ParkVO> searchParksByAddress(String searchKeyword) {
		return sqlSessionTemplate.selectList("park-mapper.searchParksByAddress", "%" + searchKeyword + "%");
	}


	
	
}