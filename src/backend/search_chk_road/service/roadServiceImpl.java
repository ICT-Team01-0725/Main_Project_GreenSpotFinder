package com.ict.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.edu.dao.roadDAO;
import com.ict.edu.vo.roadVO;


@Service
public class roadServiceImpl implements roadService {

	@Autowired
	private roadDAO roadDAO;
	

	@Override
	public List<roadVO> roadSearchByAddress(String searchKeyword) {

		return roadDAO.roadSearchByAddress(searchKeyword);
	}

	
}
