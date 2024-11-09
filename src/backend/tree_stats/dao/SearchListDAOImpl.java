package com.ict.project.searchlist.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.project.searchlist.vo.TreeVO;


@Repository
public class SearchListDAOImpl implements SearchListDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public int getTotalCount() {
		return sqlSessionTemplate.selectOne("tree.count");
	}

	@Override
	public List<TreeVO> getTreeList(int offset, int limit) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("limit", limit);
		map.put("offset", offset);
		
		return sqlSessionTemplate.selectList("tree.pagelist", map);
	}
	
}
