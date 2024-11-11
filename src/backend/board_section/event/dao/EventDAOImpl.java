package com.ict.project.event.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.project.event.vo.EventVO;

@Repository
public class EventDAOImpl implements EventDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int getTotalCount() {
		return sqlSessionTemplate.selectOne("event.evcount");
	}

	@Override
	public List<EventVO> getEventList(int offset, int limit) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("offset", String.valueOf(offset));
		map.put("limit", String.valueOf(limit));
		
		return sqlSessionTemplate.selectList("event.evlist", map);
	}

	@Override
	public List<EventVO> getEventSearch(String[] str, int offset, int limit) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("str", str);
		map.put("offset", String.valueOf(offset));
		map.put("limit", String.valueOf(limit));
		return sqlSessionTemplate.selectList("event.evsearch", map);
	}

	@Override
	public List<EventVO> getEventCalender() {
		return sqlSessionTemplate.selectList("event.evcal");
	}
}
