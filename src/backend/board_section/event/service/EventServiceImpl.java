package com.ict.project.event.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.ict.project.event.dao.EventDAO;
import com.ict.project.event.vo.EventVO;

@Service
public class EventServiceImpl implements EventService{
	
	@Autowired
	private EventDAO eventDAO;

	@Override
	public int getTotalCount() {
		return eventDAO.getTotalCount();
	}

	@Override
	public List<EventVO> getEventList(int offset, int limit) {
		return eventDAO.getEventList(offset, limit);
	}

	@Override
	public List<EventVO> getEventSearch(String[] str, int offset, int limit) {
		return eventDAO.getEventSearch(str, offset, limit);
	}

	@Override
	public List<EventVO> getEventCalender() {
		return eventDAO.getEventCalender();
	}
	
	
	// json을 EventVO에 넣는다
	@Override
	public List<EventVO> loadEvents() {
		Gson gson = new Gson();
        List<EventVO> events = null;

        try {
        	BufferedReader br = new BufferedReader(new FileReader("json경로")); 
        	Type eventListType = new TypeToken<List<EventVO>>() {}.getType();
            events = gson.fromJson(br, eventListType);
        } catch (Exception e) {
        	System.out.println(e);
        }

        return events;
	}
}
