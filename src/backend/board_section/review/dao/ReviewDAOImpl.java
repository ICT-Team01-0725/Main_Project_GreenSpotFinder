package com.ict.project.review.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.project.review.vo.ReviewVO;


@Repository
public class ReviewDAOImpl implements ReviewDAO{
	
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<ReviewVO> getReviewList(int offset, int limit) {
		Map<String , Integer> map = new HashMap<String, Integer>();
		map.put("offset", offset);
		map.put("limit", limit);
		
		return sqlSessionTemplate.selectList("review.review_list",map);
	}

	@Override
	public ReviewVO getReviewDetail(String rev_idx) {
		return sqlSessionTemplate.selectOne("review.review_detail",rev_idx);
	}

	@Override
	public int getReviewInsert(ReviewVO rvo) {
		return sqlSessionTemplate.insert("review.review_insert",rvo);
	}

	@Override
	public int getReviewUpdate(ReviewVO rvo) {
		return sqlSessionTemplate.update("review.review_update",rvo);
	}

	@Override
	public int getReviewDelete(String rev_idx) {
		return sqlSessionTemplate.delete("review.review_delete",rev_idx);
	}

	@Override
	public int getReviewCount() {
		return sqlSessionTemplate.selectOne("review.review_count");
	}
	
	
	
}
