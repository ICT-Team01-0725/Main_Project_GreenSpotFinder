package com.ict.edu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ict.edu.vo.roadVO;


public interface roadService {

	List<roadVO> roadSearchByAddress(String searchKeyword);
	
}
