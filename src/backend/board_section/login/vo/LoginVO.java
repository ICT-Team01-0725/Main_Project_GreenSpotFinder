package com.ict.project.login.vo;

import org.springframework.web.multipart.MultipartFile;

public class LoginVO {
	private String u_id, u_pw, u_na, u_phone, u_gen, u_bir, u_em, u_out, a_idx, u_outr, u_kakao, u_naver, u_pic;
	// u_pic은 사진 경로로 저장
	
	private MultipartFile u_file;
	// u_file은 사진
	
	
	public String getU_pic() {
		return u_pic;
	}

	public MultipartFile getU_file() {
		return u_file;
	}

	public void setU_file(MultipartFile u_file) {
		this.u_file = u_file;
	}

	public void setU_pic(String u_pic) {
		this.u_pic = u_pic;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getU_pw() {
		return u_pw;
	}

	public void setU_pw(String u_pw) {
		this.u_pw = u_pw;
	}

	public String getU_na() {
		return u_na;
	}

	public void setU_na(String u_na) {
		this.u_na = u_na;
	}

	public String getU_phone() {
		return u_phone;
	}

	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}

	public String getU_gen() {
		return u_gen;
	}

	public void setU_gen(String u_gen) {
		this.u_gen = u_gen;
	}

	public String getU_bir() {
		return u_bir;
	}

	public void setU_bir(String u_bir) {
		this.u_bir = u_bir;
	}

	public String getU_em() {
		return u_em;
	}

	public void setU_em(String u_em) {
		this.u_em = u_em;
	}

	public String getU_out() {
		return u_out;
	}

	public void setU_out(String u_out) {
		this.u_out = u_out;
	}

	public String getA_idx() {
		return a_idx;
	}

	public void setA_idx(String a_idx) {
		this.a_idx = a_idx;
	}

	public String getU_outr() {
		return u_outr;
	}

	public void setU_outr(String u_outr) {
		this.u_outr = u_outr;
	}

	public String getU_kakao() {
		return u_kakao;
	}

	public void setU_kakao(String u_kakao) {
		this.u_kakao = u_kakao;
	}

	public String getU_naver() {
		return u_naver;
	}

	public void setU_naver(String u_naver) {
		this.u_naver = u_naver;
	}
	
	
}
