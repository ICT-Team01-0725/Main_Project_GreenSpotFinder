package com.ict.edu.roadvo;

public class RoadVO {
    private int r_idx;    			// 고유번호 (자동 증가)
    private String r_na;            // 가로수길명
    private double r_s_lat;         // 가로수길시작위도
    private double r_s_lon;         // 가로수길시작경도
    private double r_e_lat;         // 가로수길종료위도
    private double r_e_lon;         // 가로수길종료경도
    private String r_ty;            // 가로수종류
    private  int r_vol;             // 가로수수량
    private double r_len;           // 가로수길길이
    private int r_ye; 				// 식재연도
    private String r_sto;           // 가로수길소개
    private String r_rna;           // 도로명
    private String r_rty;           // 도로종류
    private String r_rsec;          // 도로구간
    private String r_pho;           // 관리기관전화번호
    private String r_ce_na;         // 관리기관명
    private String r_dat;           // 데이터기준일자
    private int r_ce_co;            // 제공기관코드
    private String r_ce_ad;         // 제공기관명
    

    // getter setter
    
	public int getR_idx() {
		return r_idx;
	}
	
	public void setR_idx(int r_idx) {
		this.r_idx = r_idx;
	}
	
	public String getR_na() {
		return r_na;
	}
	
	public void setR_na(String r_na) {
		this.r_na = r_na;
	}
	
	public double getR_s_lat() {
		return r_s_lat;
	}
	
	public void setR_s_lat(double r_s_lat) {
		this.r_s_lat = r_s_lat;
	}
	
	public double getR_s_lon() {
		return r_s_lon;
	}
	
	public void setR_s_lon(double r_s_lon) {
		this.r_s_lon = r_s_lon;
	}
	
	public double getR_e_lat() {
		return r_e_lat;
	}
	
	public void setR_e_lat(double r_e_lat) {
		this.r_e_lat = r_e_lat;
	}
	
	public double getR_e_lon() {
		return r_e_lon;
	}
	
	public void setR_e_lon(double r_e_lon) {
		this.r_e_lon = r_e_lon;
	}
	
	public String getR_ty() {
		return r_ty;
	}
	
	public void setR_ty(String r_ty) {
		this.r_ty = r_ty;
	}
	
	public int getR_vol() {
		return r_vol;
	}
	
	public void setR_vol(int r_vol) {
		this.r_vol = r_vol;
	}
	
	public double getR_len() {
		return r_len;
	}
	
	public void setR_len(double r_len) {
		this.r_len = r_len;
	}
	
	public int getR_ye() {
		return r_ye;
	}
	
	public void setR_ye(int r_ye) {
		this.r_ye = r_ye;
	}
	
	public String getR_sto() {
		return r_sto;
	}
	
	public void setR_sto(String r_sto) {
		this.r_sto = r_sto;
	}
	
	public String getR_rna() {
		return r_rna;
	}
	
	public void setR_rna(String r_rna) {
		this.r_rna = r_rna;
	}
	
	public String getR_rty() {
		return r_rty;
	}
	
	public void setR_rty(String r_rty) {
		this.r_rty = r_rty;
	}
	
	public String getR_rsec() {
		return r_rsec;
	}
	
	public void setR_rsec(String r_rsec) {
		this.r_rsec = r_rsec;
	}
	
	public String getR_pho() {
		return r_pho;
	}
	
	public void setR_pho(String r_pho) {
		this.r_pho = r_pho;
	}
	
	public String getR_ce_na() {
		return r_ce_na;
	}
	
	public void setR_ce_na(String r_ce_na) {
		this.r_ce_na = r_ce_na;
	}
	
	public String getR_dat() {
		return r_dat;
	}
	
	public void setR_dat(String r_dat) {
		this.r_dat = r_dat;
	}
	
	public int getR_ce_co() {
		return r_ce_co;
	}
	
	public void setR_ce_co(int r_ce_co) {
		this.r_ce_co = r_ce_co;
	}
	
	public String getR_ce_ad() {
		return r_ce_ad;
	}
	
	public void setR_ce_ad(String r_ce_ad) {
		this.r_ce_ad = r_ce_ad;
	}
    
}
