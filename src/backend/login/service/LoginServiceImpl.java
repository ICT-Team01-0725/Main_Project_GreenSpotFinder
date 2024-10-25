package com.ict.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.ict.project.dao.LoginDAO;
import com.ict.project.vo.LoginVO;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private LoginDAO loginDAO;
	
	@Override
	public int loginOK() {
		return 0;
	}

	@Override
	public int joinOK() {
		return 0;
	}

	@Override
	public int joinOK(LoginVO lvo) {
		
		return loginDAO.joinOK(lvo);
	}

}
