package com.ict.project.popup.service;

import java.util.List;

import com.ict.project.popup.vo.PopupVO;

public interface PopupService {
	
	public List<PopupVO> getPopList();
	
	public PopupVO getPopDetail(String pop_idx);
	
	public int getPopInsert(PopupVO pvo);
	
	public int getPopUpdate(PopupVO pvo);
	
	public int getPopDelete(PopupVO pvo);
}
