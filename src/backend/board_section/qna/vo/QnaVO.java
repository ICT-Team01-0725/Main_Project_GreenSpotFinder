package com.ict.project.qna.vo;

import org.springframework.web.multipart.MultipartFile;

public class QnaVO {
	
	// 게시판마다 변수명 확인해서 작성하기
	private String q_idx, u_idx, q_tle, q_con, q_dat, q_ans, a_idx, q_acon, q_filename, q_oldname;
	private MultipartFile q_file;
	
	
	public String getQ_oldname() {
		return q_oldname;
	}

	public void setQ_oldname(String q_oldname) {
		this.q_oldname = q_oldname;
	}

	public String getQ_filename() {
		return q_filename;
	}

	public void setQ_filename(String q_filename) {
		this.q_filename = q_filename;
	}

	public MultipartFile getQ_file() {
		return q_file;
	}

	public void setQ_file(MultipartFile q_file) {
		this.q_file = q_file;
	}

	public String getQ_idx() {
		return q_idx;
	}

	public void setQ_idx(String q_idx) {
		this.q_idx = q_idx;
	}

	public String getU_idx() {
		return u_idx;
	}

	public void setU_idx(String u_idx) {
		this.u_idx = u_idx;
	}

	public String getQ_tle() {
		return q_tle;
	}

	public void setQ_tle(String q_tle) {
		this.q_tle = q_tle;
	}

	public String getQ_con() {
		return q_con;
	}

	public void setQ_con(String q_con) {
		this.q_con = q_con;
	}

	public String getQ_dat() {
		return q_dat;
	}

	public void setQ_dat(String q_dat) {
		this.q_dat = q_dat;
	}

	public String getQ_ans() {
		return q_ans;
	}

	public void setQ_ans(String q_ans) {
		this.q_ans = q_ans;
	}

	public String getA_idx() {
		return a_idx;
	}

	public void setA_idx(String a_idx) {
		this.a_idx = a_idx;
	}

	public String getQ_acon() {
		return q_acon;
	}

	public void setQ_acon(String q_acon) {
		this.q_acon = q_acon;
	}
	
	
	// 변수 다 작성후엔 getter/setter 생성 
}
	