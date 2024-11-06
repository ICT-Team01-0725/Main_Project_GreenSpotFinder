package com.ict.edu.parkservice;

import java.util.List;

import com.ict.edu.parkvo.ParkVO;

public interface ParkService { 
	List<ParkVO> getParkList();
	List<ParkVO> searchParksByAddress(String searchKeyword);
}