package com.ict.edu.finalroaddao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.edu.finalroadvo.FinalRoadVO;

@Repository
public class FinalRoadDAOImpl implements FinalRoadDAO {

    private final SqlSessionTemplate sqlSessionTemplate;
    
    @Autowired
    public FinalRoadDAOImpl(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public List<FinalRoadVO> getRoadsByTreeType(String type, int offset, int pageSize) {
        // 파라미터 맵으로 전달
        Map<String, Object> params = new HashMap<>();
        params.put("type", type);
        params.put("offset", offset);
        params.put("pageSize", pageSize);
        
        // 쿼리 실행 (Mapper XML에서 정의된 쿼리 호출)
        return sqlSessionTemplate.selectList("finalroad-mapper.selectRoadsByTreeType", params);
    }

    @Override
    public int getTotalRoadsByTreeType(String type) {
        // 나무 종류에 해당하는 도로 수를 조회
        return sqlSessionTemplate.selectOne("finalroad-mapper.selectTotalRoadsByTreeType", type);
    }
}