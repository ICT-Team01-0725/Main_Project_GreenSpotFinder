package com.ict.project.searchlist.service;

import java.util.List;

import com.ict.project.searchlist.vo.TreeVO;

public interface SearchListService {
	
	public int getTotalCount();
	
	public List<TreeVO> getTreeList(int offset, int limit);
}
