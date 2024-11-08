package com.ict.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ict.edu.dao.CalendarDAO;
import com.ict.edu.vo.CalendarVO1;

@Service
public class CalendarServiceImpl implements CalendarService {

    @Autowired
    private CalendarDAO calendarDAO;

    @Transactional
    @Override
    public int getCalendarInsert(CalendarVO1 cvo) {
        return calendarDAO.getCalendarInsert(cvo);
    }
}
