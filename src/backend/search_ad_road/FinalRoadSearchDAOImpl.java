package com.ict.edu.finalroadsearchdao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.edu.finalroadsearchvo.FinalRoadSearchVO;

@Repository
public class FinalRoadSearchDAOImpl implements FinalRoadSearchDAO {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public List<FinalRoadSearchVO> searchRoadByAddress(String r_ce_ad) {
        return sqlSessionTemplate.selectList("finalroadsearch-mapper.searchRoadByAddress", r_ce_ad);
    }

    @Override
    public List<FinalRoadSearchVO> searchRoadByRegion(String region) {
        return sqlSessionTemplate.selectList("finalroadsearch-mapper.searchRoadByRegion", region);
    }
}