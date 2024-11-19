package com.ict.edu.parkparkdao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.edu.parkparkvo.ParkParkVO;

@Repository
public class ParkParkDAOImpl implements ParkParkDAO {
    
    private final SqlSessionTemplate sqlSessionTemplate;
    
    @Autowired
    public ParkParkDAOImpl(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public List<ParkParkVO> getParksByCategory(String category, int offset, int pageSize) {
        // 파라미터 맵으로 전달
        Map<String, Object> params = new HashMap<>();
        params.put("category", category);
        params.put("offset", offset);
        params.put("pageSize", pageSize);
        
        // 쿼리 실행 (Mapper XML에서 정의된 쿼리 호출)
        return sqlSessionTemplate.selectList("parkpark-mapper.selectParksByCategory", params);
    }

    @Override
    public int getTotalParksByCategory(String category) {
        // 카테고리에 해당하는 공원 수를 조회
        return sqlSessionTemplate.selectOne("parkpark-mapper.selectTotalParksByCategory", category);
    }
}