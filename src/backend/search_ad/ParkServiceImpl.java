package com.ict.edu.parkservice;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ict.edu.parkdao.ParkDAO;
import com.ict.edu.parkvo.ParkVO;

@Service  
public class ParkServiceImpl implements ParkService {

	@Autowired
	private ParkDAO parkDAO;
	
	@Override
	public List<ParkVO> getParkList() {
		return parkDAO.getParkList();
	}
	
	@Override
	public List<ParkVO> searchParksByAddress(String searchKeyword) {
		return parkDAO.searchParksByAddress(searchKeyword);
	}



}