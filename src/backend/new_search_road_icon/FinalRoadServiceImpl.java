package com.ict.edu.finalroadservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.edu.finalroaddao.FinalRoadDAO;
import com.ict.edu.finalroadvo.FinalRoadVO;

@Service
public class FinalRoadServiceImpl implements FinalRoadService {

    @Autowired
    private FinalRoadDAO finalRoadDAO;

    @Override
    public List<FinalRoadVO> getRoadsByTreeType(String type, int page, int pageSize) {
        int offset = (page - 1) * pageSize; // 페이지에 맞는 offset 계산
        return finalRoadDAO.getRoadsByTreeType(type, offset, pageSize);
    }

    @Override
    public int getTotalRoadsByTreeType(String type) {
        return finalRoadDAO.getTotalRoadsByTreeType(type);
    }

    @Override
    public int getTotalPages(int totalItems, int pageSize) {
        return (int) Math.ceil((double) totalItems / pageSize); // 페이지 수 계산
    }
}