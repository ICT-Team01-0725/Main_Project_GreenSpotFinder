package com.ict.edu.parkdao;

import java.util.List;

import com.ict.edu.parkvo.ParkVO;

public interface ParkDAO {

	List<ParkVO> getParkList();
	
	List<ParkVO> searchParksByAddress(String searchKeyword);
	
}
