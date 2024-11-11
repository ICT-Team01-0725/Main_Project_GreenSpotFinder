package com.ict.project.popup.vo;

import org.springframework.web.multipart.MultipartFile;

public class PopupVO {
	private String pop_idx, a_idx, pop_tle, pop_con, pop_pic, pop_rdat, pop_odat, pop_link, pop_act, pop_etc, old_pic;
	public String getOld_pic() {
		return old_pic;
	}

	public void setOld_pic(String old_pic) {
		this.old_pic = old_pic;
	}

	private MultipartFile pop_file;
	
	public MultipartFile getPop_file() {
		return pop_file;
	}

	public void setPop_file(MultipartFile pop_file) {
		this.pop_file = pop_file;
	}

	public String getPop_idx() {
		return pop_idx;
	}

	public void setPop_idx(String pop_idx) {
		this.pop_idx = pop_idx;
	}

	public String getA_idx() {
		return a_idx;
	}

	public void setA_idx(String a_idx) {
		this.a_idx = a_idx;
	}

	public String getPop_tle() {
		return pop_tle;
	}

	public void setPop_tle(String pop_tle) {
		this.pop_tle = pop_tle;
	}

	public String getPop_con() {
		return pop_con;
	}

	public void setPop_con(String pop_con) {
		this.pop_con = pop_con;
	}

	public String getPop_pic() {
		return pop_pic;
	}

	public void setPop_pic(String pop_pic) {
		this.pop_pic = pop_pic;
	}

	public String getPop_rdat() {
		return pop_rdat;
	}

	public void setPop_rdat(String pop_rdat) {
		this.pop_rdat = pop_rdat;
	}

	public String getPop_odat() {
		return pop_odat;
	}

	public void setPop_odat(String pop_odat) {
		this.pop_odat = pop_odat;
	}

	public String getPop_link() {
		return pop_link;
	}

	public void setPop_link(String pop_link) {
		this.pop_link = pop_link;
	}

	public String getPop_act() {
		return pop_act;
	}

	public void setPop_act(String pop_act) {
		this.pop_act = pop_act;
	}

	public String getPop_etc() {
		return pop_etc;
	}

	public void setPop_etc(String pop_etc) {
		this.pop_etc = pop_etc;
	}
}
