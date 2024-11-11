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
	public int loginInsert(LoginVO lvo) {
		return loginDAO.loginInsert(lvo);
	}

	@Override
	public String idChk(String u_id) {
		return loginDAO.idChk(u_id);
	}

	@Override
	public List<String> getId(String u_em) {
		return loginDAO.getLoginId(u_em);
	}

	@Override
	public String kakaoChk(String u_kakao) {
		return loginDAO.kakaoChk(u_kakao);
	}
	
	@Override
	public String naverChk(String u_naver) {
		return loginDAO.naverChk(u_naver);
	}

	@Override
	public LoginVO getDetail(String u_id) {
		return loginDAO.loginDetail(u_id);
	}

	@Override
	public String idKakao(String u_kakao) {
		return loginDAO.idKakao(u_kakao);
	}

	@Override
	public String idNaver(String u_naver) {
		return loginDAO.idNaver(u_naver);
	}

	@Override
	public int update(LoginVO lvo) {
		return loginDAO.loginUpdate(lvo);
	}

	@Override
	public int updatePw(LoginVO lvo) {
		return loginDAO.loginUpdatePw(lvo);
	}

	@Override
	public List<LoginVO> getList(int offset, int limit) {
		return loginDAO.loginList(offset, limit);
	}

	@Override
	public int logindelete(LoginVO lvo) {
		return loginDAO.loginDelete(lvo);
	}

	@Override
	public int userCount() {
		return loginDAO.userCount();
	}


}
