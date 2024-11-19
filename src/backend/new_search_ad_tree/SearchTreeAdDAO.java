package com.ict.edu.searchtreeaddao;

import java.util.List;

import com.ict.edu.searchtreeadvo.SearchTreeAdVO;

public interface SearchTreeAdDAO {

    List<SearchTreeAdVO> searchTreesByAddress(String t_sta_ad);
    
    List<SearchTreeAdVO> getTop4Trees();
}