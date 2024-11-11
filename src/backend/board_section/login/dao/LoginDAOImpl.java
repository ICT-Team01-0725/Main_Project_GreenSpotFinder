package com.ict.project.login.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.project.login.vo.LoginVO;

@Repository
public class LoginDAOImpl implements LoginDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate; 
	
	
	@Override
	// 회원가입
	public int loginInsert(LoginVO lvo) {
		return sqlSessionTemplate.insert("login.login_insert",lvo);
	}
	
	@Override
	// id 중복체크
	public String idChk(String u_id) {
		return sqlSessionTemplate.selectOne("login.id_chk",u_id);
	}

	@Override
	public List<String> getLoginId(String u_em) {
		return sqlSessionTemplate.selectList("login.id_email", u_em);
	}

	@Override
	public String kakaoChk(String u_kakao) {
		return sqlSessionTemplate.selectOne("login.kakao_chk",u_kakao);
	}
	
	@Override
	public String naverChk(String u_naver) {
		return sqlSessionTemplate.selectOne("login.naver_chk",u_naver);
	}

	@Override
	public LoginVO loginDetail(String u_id) {
		return sqlSessionTemplate.selectOne("login.login_detail",u_id);
	}

	@Override
	public String idKakao(String u_kakao) {
		return sqlSessionTemplate.selectOne("login.id_kakao",u_kakao);
	}

	@Override
	public String idNaver(String u_naver) {
		return sqlSessionTemplate.selectOne("login.id_naver", u_naver);
	}

	@Override
	public int loginUpdate(LoginVO lvo) {
		return sqlSessionTemplate.update("login.login_update", lvo);
	}

	@Override
	public int loginUpdatePw(LoginVO lvo) {
		return sqlSessionTemplate.update("login.pw_update", lvo);
	}

	@Override
	public List<LoginVO> loginList(int offset, int limit) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("offset", offset);
		map.put("limit", limit);
		
		return sqlSessionTemplate.selectList("login.login_list", map);
	}

	@Override
	public int loginDelete(LoginVO lvo) {
		return sqlSessionTemplate.update("login.login_delete", lvo);
	}

	@Override
	public int userCount() {
		return sqlSessionTemplate.selectOne("login.login_count");
	}

	
}
