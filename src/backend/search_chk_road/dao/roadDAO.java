package com.ict.edu.dao;

import java.util.List;

import com.ict.edu.vo.roadVO;

public interface roadDAO {


	List<roadVO> roadSearchByAddress(String searchKeyword);
}
