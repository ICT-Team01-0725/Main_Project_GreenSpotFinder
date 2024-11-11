package com.ict.project.notice.vo;

import org.springframework.web.multipart.MultipartFile;

public class NoticeVO {

	private String n_idx, a_idx, n_tle, n_chk, n_con, n_dat, n_out, n_hit, n_pic, old_f_name, n_opt; 
	
	
	private MultipartFile n_file;


	public String getN_idx() {
		return n_idx;
	}


	public void setN_idx(String n_idx) {
		this.n_idx = n_idx;
	}


	public String getA_idx() {
		return a_idx;
	}


	public void setA_idx(String a_idx) {
		this.a_idx = a_idx;
	}


	public String getN_tle() {
		return n_tle;
	}


	public void setN_tle(String n_tle) {
		this.n_tle = n_tle;
	}


	public String getN_chk() {
		return n_chk;
	}


	public void setN_chk(String n_chk) {
		this.n_chk = n_chk;
	}


	public String getN_con() {
		return n_con;
	}


	public void setN_con(String n_con) {
		this.n_con = n_con;
	}


	public String getN_dat() {
		return n_dat;
	}


	public void setN_dat(String n_dat) {
		this.n_dat = n_dat;
	}


	public String getN_out() {
		return n_out;
	}


	public void setN_out(String n_out) {
		this.n_out = n_out;
	}


	public String getN_hit() {
		return n_hit;
	}


	public void setN_hit(String n_hit) {
		this.n_hit = n_hit;
	}


	public String getF_name() {
		return n_pic;
	}


	public void setF_name(String f_name) {
		this.n_pic = f_name;
	}


	public String getOld_f_name() {
		return old_f_name;
	}


	public void setOld_f_name(String old_f_name) {
		this.old_f_name = old_f_name;
	}


	public String getN_opt() {
		return n_opt;
	}


	public void setN_opt(String n_opt) {
		this.n_opt = n_opt;
	}


	public MultipartFile getFile_name() {
		return n_file;
	}


	public void setFile_name(MultipartFile file_name) {
		this.n_file = file_name;
	}

}
