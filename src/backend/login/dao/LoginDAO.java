package com.ict.project.dao;

import org.springframework.web.servlet.ModelAndView;

import com.ict.project.vo.LoginVO;

public interface LoginDAO {
	public int loginOK();
	
	public int joinOK();
	
	public int joinOK(LoginVO lvo);
	
}
