package com.ict.project.inquery.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.project.inquery.vo.InqueryVO;



@Repository
public class InqueryDAOImpl implements InqueryDAO{
	
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<InqueryVO> getInqueryList(int offset, int limit) {
		Map<String , Integer> map = new HashMap<String, Integer>();
		map.put("offset", offset);
		map.put("limit", limit);
		
		return sqlSessionTemplate.selectList("inquery.inquery_list",map);
	}

	@Override
	public InqueryVO getInqueryDetail(String idx) {
		return sqlSessionTemplate.selectOne("inquery.inquery_detail",idx);
	}

	@Override
	public int getInqueryInsert(InqueryVO ivo) {
		return sqlSessionTemplate.insert("inquery.inquery_insert",ivo);
	}

	@Override
	public int getInqueryUpdate(InqueryVO ivo) {
		return sqlSessionTemplate.update("inquery.inquery_update",ivo);
	}

	@Override
	public int getInqueryDelete(String idx) {
		return sqlSessionTemplate.delete("inquery.inquery_delete",idx);
	}

	@Override
	public int getInqueryCount() {
		return sqlSessionTemplate.selectOne("inquery.inquery_count");
	}

	@Override
	public int getAdminUpdate(InqueryVO ivo) {
		return sqlSessionTemplate.update("inquery.inquery_adminup", ivo);
	}
	
	
	
}
