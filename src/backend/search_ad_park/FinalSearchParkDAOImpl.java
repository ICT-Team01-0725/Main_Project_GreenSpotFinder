package com.ict.edu.finalsearchparkdao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.edu.finalsearchparkvo.FinalSearchParkVO;

@Repository
public class FinalSearchParkDAOImpl implements FinalSearchParkDAO {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public List<FinalSearchParkVO> searchParkByAddress(String p_ad) {
        return sqlSessionTemplate.selectList("finalsearchpark-mapper.searchParkByAddress", p_ad);
    }

    @Override
    public List<FinalSearchParkVO> searchParkByRegion(String region) {
        return sqlSessionTemplate.selectList("finalsearchpark-mapper.searchParkByRegion", region);
    }
}