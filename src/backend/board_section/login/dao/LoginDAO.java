package com.ict.project.login.dao;


import java.util.List;

import com.ict.project.login.vo.LoginVO;

public interface LoginDAO {
	
	public int loginInsert(LoginVO lvo);
	
	public String idChk(String u_id);
	
	public LoginVO loginDetail(String u_id);
	
	public List<String> getLoginId(String u_em);
	
	public String kakaoChk(String u_kakao);

	public String naverChk(String u_naver);
	
	public String idKakao(String u_kakao);
	
	public String idNaver(String u_naver);
	
	public int loginUpdate(LoginVO lvo);
	
	public int loginUpdatePw(LoginVO lvo);
	
	public List<LoginVO> loginList(int offset, int limit);
	
	public int loginDelete(LoginVO lvo);	
	
	public int userCount();
}
