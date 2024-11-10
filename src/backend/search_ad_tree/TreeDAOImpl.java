package com.ict.edu.treedao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.edu.treevo.TreeVO;

@Repository
public class TreeDAOImpl implements TreeDAO {
    
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    // 보호수 검색 (t_ad로 검색, t_rad 추가 파라미터 사용)
    @Override
    public List<TreeVO> searchTrees(String t_ad, String t_rad) {
        Map<String, Object> params = new HashMap<>();

        params.put("t_ad", (t_ad != null && !t_ad.isEmpty()) ? "%" + t_ad + "%" : null);
        params.put("t_rad", (t_rad != null && !t_rad.isEmpty()) ? "%" + t_rad + "%" : null);

        return sqlSessionTemplate.selectList("tree-mapper.searchTrees", params);
    }

    // 기본 보호수 리스트 조회 (가나다순 4개)
    @Override
    public List<TreeVO> getTop4Trees() {
        return sqlSessionTemplate.selectList("tree-mapper.getTop4Trees");
    }
}
