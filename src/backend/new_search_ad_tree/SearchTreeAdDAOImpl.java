package com.ict.edu.searchtreeaddao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.edu.searchtreeadvo.SearchTreeAdVO;

@Repository
public class SearchTreeAdDAOImpl implements SearchTreeAdDAO {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public List<SearchTreeAdVO> searchTreesByAddress(String t_sta_ad) {
        return sqlSessionTemplate.selectList("searchtreead-mapper.searchTrees", t_sta_ad);
    }

    @Override
    public List<SearchTreeAdVO> getTop4Trees() {
        return sqlSessionTemplate.selectList("searchtreead-mapper.getTop4Trees");
    }
}