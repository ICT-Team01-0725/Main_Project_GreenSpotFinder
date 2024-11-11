package com.ict.project.comment.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.project.comment.vo.CommentVO;


@Repository
public class CommentDAOImpl implements CommentDAO{
	

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<CommentVO> getCommentList(CommentVO cvo) {
		Map<String , String> map = new HashMap<String, String>();
		map.put("c_ref", cvo.getC_ref());
		map.put("c_bor", cvo.getC_bor());
		
		return sqlSessionTemplate.selectList("Comment.Comment_list",map);
	}

	@Override
	public CommentVO getCommentDetail(String idx) {
		return sqlSessionTemplate.selectOne("Comment.Comment_detail",idx);
	}

	@Override
	public int getCommentInsert(CommentVO cvo) {
		return sqlSessionTemplate.insert("Comment.Comment_insert",cvo);
	}

	@Override
	public int getCommentUpdate(CommentVO cvo) {
		return sqlSessionTemplate.update("Comment.Comment_update",cvo);
	}

	@Override
	public int getCommentDelete(String idx) {
		return sqlSessionTemplate.delete("Comment.Comment_delete",idx);
	}

	@Override
	public int getCommentCount() {
		return sqlSessionTemplate.selectOne("Comment.Comment_count");
	}

	@Override
	public List<CommentVO> getCommentList(int offset, int limit) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("offset",offset);
		map.put("limit", limit);
		return sqlSessionTemplate.selectList("Comment.Comment_listall", map);
	}
	
	
	
}
