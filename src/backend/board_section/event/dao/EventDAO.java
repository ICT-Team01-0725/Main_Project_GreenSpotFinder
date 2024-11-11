package com.ict.project.event.dao;

import java.util.List;

import com.ict.project.event.vo.EventVO;

public interface EventDAO {
	
	public int getTotalCount(); 
	
	public List<EventVO> getEventList(int offset, int limit);
	
	public List<EventVO> getEventSearch(String[] str, int offset, int limit);
	
	public List<EventVO> getEventCalender();
}
