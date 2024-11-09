package com.ict.edu.parkservice;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.edu.parkvo.ParkVO;

@Service
public class ParkServiceImpl implements ParkService {


    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    // 첫 화면에 4개 공원 가져오기
    @Override
    public List<ParkVO> getTop4Parks() {
        return sqlSessionTemplate.selectList("park-mapper.getTop4Parks");  // MyBatis 쿼리 실행
    }

    // 주소로 공원 검색
    @Override
    public List<ParkVO> searchParks(String p_ad) {
        return sqlSessionTemplate.selectList("park-mapper.searchParks", p_ad);
    }
}