package com.ict.edu.searchtreeadservice;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.edu.searchtreeadvo.SearchTreeAdVO;

@Service
public class SearchTreeAdServiceImpl implements SearchTreeAdService {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public List<SearchTreeAdVO> searchTreesByAddress(String address) {
        return sqlSessionTemplate.selectList("searchtreead-mapper.searchTreesByAddress", address);
    }

    @Override
    public List<SearchTreeAdVO> getTop4Trees() {
        return sqlSessionTemplate.selectList("searchtreead-mapper.getTop4Trees");
    }

    @Override
    public List<SearchTreeAdVO> getAllTrees() {
        return sqlSessionTemplate.selectList("searchtreead-mapper.getAllTrees");
    }

    @Override
    public List<SearchTreeAdVO> searchTreesByRegion(String region) {
        return sqlSessionTemplate.selectList("searchtreead-mapper.searchTreesByRegion", region);
    }
}