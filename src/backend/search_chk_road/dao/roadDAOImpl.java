package com.ict.edu.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.edu.vo.roadVO;

@Repository
public class roadDAOImpl implements roadDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<roadVO> roadSearchByAddress(String searchKeyword) {

		return sqlSessionTemplate.selectList("road.searchRoadByAddress", "%" + searchKeyword + "%");
	}

}
