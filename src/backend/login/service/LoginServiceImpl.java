package com.ict.project.login.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.project.login.dao.LoginDAO;
import com.ict.project.login.vo.LoginVO;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private LoginDAO loginDAO;
	
	@Override
	public LoginVO loginOK(String u_id) {
		return loginDAO.loginOK(u_id);
	}

	
	@Override
	public int joinOK() {
		return 0;
	}

	@Override
	public int joinOK(LoginVO lvo) {
		return loginDAO.joinOK(lvo);
	}

	@Override
	public String idChk(String u_id) {
		return loginDAO.idChk(u_id);
	}

	@Override
	public int getList() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDetail() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public List<String> getId(String u_em) {
		return loginDAO.getId(u_em);
	}


	@Override
	public LoginVO pwFind(LoginVO lvo) {
		return loginDAO.pwFind(lvo);
	}

}
