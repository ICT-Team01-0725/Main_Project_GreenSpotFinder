package com.ict.edu.finalroadsearchservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.edu.finalroadsearchdao.FinalRoadSearchDAO;
import com.ict.edu.finalroadsearchvo.FinalRoadSearchVO;

@Service
public class FinalRoadSearchServiceImpl implements FinalRoadSearchService {

    @Autowired
    private FinalRoadSearchDAO finalRoadSearchDAO;

    @Override
    public List<FinalRoadSearchVO> searchRoadByAddress(String r_ce_ad) {
        return finalRoadSearchDAO.searchRoadByAddress(r_ce_ad);
    }

    @Override
    public List<FinalRoadSearchVO> searchRoadByRegion(String region) {
        return finalRoadSearchDAO.searchRoadByRegion(region);
    }
}