package com.ict.project.popup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.project.popup.dao.PopupDAO;
import com.ict.project.popup.vo.PopupVO;

@Service
public class PopupServiceImpl implements PopupService{
	
	@Autowired
	private PopupDAO popupDAO;
	
	
	@Override
	public List<PopupVO> getPopList() {
		return popupDAO.getPopList();
	}

	@Override
	public PopupVO getPopDetail(String pop_idx) {
		return popupDAO.getPopDetail(pop_idx);
	}

	@Override
	public int getPopInsert(PopupVO pvo) {
		return popupDAO.getPopInsert(pvo);
	}

	@Override
	public int getPopUpdate(PopupVO pvo) {
		return popupDAO.getPopUpdate(pvo);
	}

	@Override
	public int getPopDelete(PopupVO pvo) {
		return popupDAO.getPopDelete(pvo);
	}

}
