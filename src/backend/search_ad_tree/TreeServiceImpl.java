package com.ict.edu.treeservice;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.edu.treevo.TreeVO;

@Service
public class TreeServiceImpl implements TreeService {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    // 첫 화면에 4개 보호수 가져오기
    @Override
    public List<TreeVO> getTop4Trees() {
        return sqlSessionTemplate.selectList("park-mapper.getTop4Parks"); // MyBatis 쿼리 실행
    }

    // 주소로 보호수 검색하기 (t_ad, t_rad 두 파라미터를 처리)
    @Override
    public List<TreeVO> searchTrees(String t_ad, String t_rad) {
        // MyBatis 쿼리 실행
        return sqlSessionTemplate.selectList("tree-mapper.searchTrees", new Object[] { t_ad, t_rad });
    }
}
