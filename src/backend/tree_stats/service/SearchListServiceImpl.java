package com.ict.project.searchlist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.project.searchlist.dao.SearchListDAO;
import com.ict.project.searchlist.vo.TreeVO;

@Service
public class SearchListServiceImpl implements SearchListService{
	
	@Autowired
	public SearchListDAO searchListDAO;
	
	@Override
	public int getTotalCount() {
		return searchListDAO.getTotalCount();
	}

	@Override
	public List<TreeVO> getTreeList(int offset, int limit) {
		return searchListDAO.getTreeList(offset, limit);
	}

}
