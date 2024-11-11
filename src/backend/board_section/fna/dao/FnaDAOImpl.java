package com.ict.project.fna.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.project.fna.vo.FnaVO;


@Repository
public class FnaDAOImpl implements FnaDAO{
	
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<FnaVO> getFnaList(int offset, int limit) {
		Map<String , Integer> map = new HashMap<String, Integer>();
		map.put("offset", offset);
		map.put("limit", limit);
		
		return sqlSessionTemplate.selectList("fna.fna_list",map);
	}

	@Override
	public FnaVO getFnaDetail(String idx) {
		return sqlSessionTemplate.selectOne("fna.fna_detail",idx);
	}

	@Override
	public int getFnaInsert(FnaVO fvo) {
		return sqlSessionTemplate.insert("fna.fna_insert",fvo);
	}

	@Override
	public int getFnaUpdate(FnaVO fvo) {
		return sqlSessionTemplate.update("fna.fna_update",fvo);
	}

	@Override
	public int getFnaDelete(String idx) {
		return sqlSessionTemplate.delete("fna.fna_delete",idx);
	}

	@Override
	public int getFnaCount() {
		return sqlSessionTemplate.selectOne("fna.fna_count");
	}
	
	
	
}
