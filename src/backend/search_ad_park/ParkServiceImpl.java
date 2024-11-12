package com.ict.edu.parkservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.edu.parkdao.ParkDAO;
import com.ict.edu.parkvo.ParkVO;

@Service
public class ParkServiceImpl implements ParkService {


    @Autowired
    private ParkDAO parkDAO;  // ParkDAO 주입

    // 첫 화면에 4개 공원 가져오기
    @Override
    public List<ParkVO> getTop4Parks() {
    	return parkDAO.getTop4Parks();  // ParkDAO의 메서드를 사용하여 공원 리스트 가져오기
    }

    // 주소로 공원 검색
    @Override
    public List<ParkVO> searchParksByAddress(String p_ad) {
        return parkDAO.searchParksByAddress(p_ad);  // ParkDAO의 searchParks 메서드를 사용
    }

    // 지역별 공원 목록 조회
    @Override
    public List<ParkVO> getParksByRegion(String region) {
        return parkDAO.getParksByRegion(region);  // 지역별 공원 조회
    }
}
