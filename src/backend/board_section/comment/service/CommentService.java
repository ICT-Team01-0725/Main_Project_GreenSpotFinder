package com.ict.project.comment.service;

import java.util.List;

import com.ict.project.comment.vo.CommentVO;

public interface CommentService {

	public int getCommentCount();
	
	public List<CommentVO> getCommentList(CommentVO cvo);
	
	public CommentVO getCommentDetail(String idx);
	
	public int getCommentInsert(CommentVO cvo);
	
	public int getCommentUpdate(CommentVO cvo);
	
	public int getCommentDelete(String idx);
	
	public List<CommentVO> getCommentList(int offset, int limit);
}
