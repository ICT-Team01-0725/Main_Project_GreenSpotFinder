package com.ict.edu.finalsearchparkservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.edu.finalsearchparkdao.FinalSearchParkDAO;
import com.ict.edu.finalsearchparkvo.FinalSearchParkVO;

@Service
public class FinalSearchParkServiceImpl implements FinalSearchParkService {

    @Autowired
    private FinalSearchParkDAO finalSearchParkDAO;

    @Override
    public List<FinalSearchParkVO> searchParkByAddress(String p_ad) {
        return finalSearchParkDAO.searchParkByAddress(p_ad);
    }

    @Override
    public List<FinalSearchParkVO> searchParkByRegion(String region) {
        return finalSearchParkDAO.searchParkByRegion(region);
    }
}