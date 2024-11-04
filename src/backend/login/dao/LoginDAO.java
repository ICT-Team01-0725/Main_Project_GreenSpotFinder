package com.ict.project.login.dao;


import java.util.List;

import com.ict.project.login.vo.LoginVO;

public interface LoginDAO {
	
	public int kakaologinOK(String u_kakao);
	
	public int naverloginOK(String u_naver);
	
	public int joinOK(LoginVO lvo);
	
	public String idChk(String u_id);
	
	public LoginVO loginOK(String u_id);
	
	public List<String> getId(String u_em);
	
	public LoginVO pwFind(LoginVO lvo);
}
