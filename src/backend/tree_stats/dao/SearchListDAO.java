package com.ict.project.searchlist.dao;

import java.util.List;

import com.ict.project.searchlist.vo.TreeVO;

public interface SearchListDAO {
	
	public int getTotalCount();
	
	public List<TreeVO> getTreeList(int offset, int limit);
}
