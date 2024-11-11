package com.ict.project.event.service;

import java.util.List;

import com.ict.project.event.vo.EventVO;

public interface EventService {

	public int getTotalCount(); 
	
	public List<EventVO> getEventList(int offset, int limit);
	
	public List<EventVO> getEventSearch(String[] str, int offset, int limit);
	
	public List<EventVO> getEventCalender();
	
	public List<EventVO> loadEvents();
}
