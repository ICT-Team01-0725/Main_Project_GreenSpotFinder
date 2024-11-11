package com.ict.project.qna.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.project.qna.vo.QnaVO;


@Repository
public class QnaDAOImpl implements QnaDAO{
	
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<QnaVO> getQnaList(int offset, int limit) {
		Map<String , Integer> map = new HashMap<String, Integer>();
		map.put("offset", offset);
		map.put("limit", limit);
		
		return sqlSessionTemplate.selectList("qna.qna_list",map);
	}

	@Override
	public QnaVO getQnaDetail(String q_idx) {
		return sqlSessionTemplate.selectOne("qna.qna_detail",q_idx);
	}

	@Override
	public int getQnaInsert(QnaVO qvo) {
		return sqlSessionTemplate.insert("qna.qna_insert",qvo);
	}

	@Override
	public int getQnaUpdate(QnaVO qvo) {
		return sqlSessionTemplate.update("qna.qna_update",qvo);
	}

	@Override
	public int getQnaDelete(String q_idx) {
		return sqlSessionTemplate.delete("qna.qna_delete",q_idx);
	}

	@Override
	public int getQnaCount() {
		return sqlSessionTemplate.selectOne("qna.qna_count");
	}

	@Override
	public List<QnaVO> getQnaUserList(String u_idx, int offset, int limit) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("u_idx", u_idx);
		map.put("offset", offset);
		map.put("limit", limit);
		
		return sqlSessionTemplate.selectList("qna.qna_userlist", map);
	}

	@Override
	public int getQnaUserCount(String u_idx) {
		return sqlSessionTemplate.selectOne("qna.qna_usercount", u_idx);
	}
	
	
	
}
