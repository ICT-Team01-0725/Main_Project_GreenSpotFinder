package com.ict.edu.searchtreeadservice;

import java.util.List;

import com.ict.edu.searchtreeadvo.SearchTreeAdVO;

public interface SearchTreeAdService {


    List<SearchTreeAdVO> searchTreesByAddress(String address);
    
    List<SearchTreeAdVO> getTop4Trees();
    
    List<SearchTreeAdVO> getAllTrees();
    
    List<SearchTreeAdVO> searchTreesByRegion(String region);
    
}
