package com.ict.project.service;

import org.springframework.web.servlet.ModelAndView;

import com.ict.project.vo.LoginVO;

public interface LoginService {
	
	public int loginOK();
	
	public int joinOK();
	
	public int joinOK(LoginVO lvo);
}
