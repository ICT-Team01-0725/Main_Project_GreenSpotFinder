package com.ict.project.popup.service;

import javax.servlet.http.HttpServletRequest;

import com.ict.project.popup.vo.PopupVO;

public interface PopFileService {
	public PopupVO popFileUpload(HttpServletRequest request, PopupVO pvo);
	
	public PopupVO popFileUpdate(HttpServletRequest request, PopupVO pvo);
	
	public void popFileDelete(HttpServletRequest request, PopupVO pvo);
}
