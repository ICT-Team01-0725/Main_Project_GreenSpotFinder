package com.ict.edu.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ict.edu.vo.CalendarVO1;

@Repository
public class CalendarDAOImpl implements CalendarDAO {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public int getCalendarInsert(CalendarVO1 cvo) {
        return sqlSessionTemplate.insert("Calendar.insert", cvo);
    }
}
