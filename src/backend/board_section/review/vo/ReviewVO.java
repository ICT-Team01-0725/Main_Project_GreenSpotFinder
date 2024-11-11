package com.ict.project.review.vo;

import org.springframework.web.multipart.MultipartFile;

public class ReviewVO {
	
	// 게시판마다 변수명 확인해서 작성하기
	private String rev_idx, rev_tle, rev_con, u_idx, rev_dat, rev_up, rev_bor, rev_ref, rev_filename, rev_oldname;
	private int rev_hit;
	private MultipartFile rev_file;
	
	
	public int getRev_hit() {
		return rev_hit;
	}
	public void setRev_hit(int rev_hit) {
		this.rev_hit = rev_hit;
	}
	public String getRev_idx() {
		return rev_idx;
	}
	public void setRev_idx(String rev_idx) {
		this.rev_idx = rev_idx;
	}
	public String getRev_tle() {
		return rev_tle;
	}
	public void setRev_tle(String rev_tle) {
		this.rev_tle = rev_tle;
	}
	public String getRev_con() {
		return rev_con;
	}
	public void setRev_con(String rev_con) {
		this.rev_con = rev_con;
	}
	public String getU_idx() {
		return u_idx;
	}
	public void setU_idx(String u_idx) {
		this.u_idx = u_idx;
	}
	public String getRev_dat() {
		return rev_dat;
	}
	public void setRev_dat(String rev_dat) {
		this.rev_dat = rev_dat;
	}
	public String getRev_up() {
		return rev_up;
	}
	public void setRev_up(String rev_up) {
		this.rev_up = rev_up;
	}
	public String getRev_bor() {
		return rev_bor;
	}
	public void setRev_bor(String rev_bor) {
		this.rev_bor = rev_bor;
	}
	public String getRev_ref() {
		return rev_ref;
	}
	public void setRev_ref(String rev_ref) {
		this.rev_ref = rev_ref;
	}
	public String getRev_filename() {
		return rev_filename;
	}
	public void setRev_filename(String rev_filename) {
		this.rev_filename = rev_filename;
	}
	public String getRev_oldname() {
		return rev_oldname;
	}
	public void setRev_oldname(String rev_oldname) {
		this.rev_oldname = rev_oldname;
	}
	public MultipartFile getRev_file() {
		return rev_file;
	}
	public void setRev_file(MultipartFile rev_file) {
		this.rev_file = rev_file;
	}
	
	
	
	// 변수 다 작성후엔 getter/setter 생성 
}
	