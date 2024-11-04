package com.ict.project.login.service;

import java.util.List;

import com.ict.project.login.vo.LoginVO;

public interface LoginService {
	
	public LoginVO loginOK(String u_id);
	
	public int joinOK();
	
	public int joinOK(LoginVO lvo);
	
	public String idChk(String u_id);
	
	public int getList();
	
	public int getDetail();
	
	public List<String> getId(String u_em);
	
	public LoginVO pwFind(LoginVO lvo);
}
