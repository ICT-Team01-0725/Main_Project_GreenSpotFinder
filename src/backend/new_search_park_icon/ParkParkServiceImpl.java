package com.ict.edu.parkparkservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.edu.parkparkdao.ParkParkDAO;
import com.ict.edu.parkparkvo.ParkParkVO;

@Service
public class ParkParkServiceImpl implements ParkParkService {

    @Autowired
    private ParkParkDAO parkParkDAO;

    @Override
    public List<ParkParkVO> getParksByCategory(String category, int page, int pageSize) {
        int offset = (page - 1) * pageSize; // 페이지에 맞는 offset 계산
        return parkParkDAO.getParksByCategory(category, offset, pageSize);
    }

    @Override
    public int getTotalParksByCategory(String category) {
        return parkParkDAO.getTotalParksByCategory(category);
    }

    @Override
    public int getTotalPages(int totalItems, int pageSize) {
        return (int) Math.ceil((double) totalItems / pageSize); // 페이지 수 계산
    }
}