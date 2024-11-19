package com.ict.edu.parkparkvo;

public class ParkParkVO {
	
	    private int p_idx;        // 공원 고유 번호
	    private String p_num;     // 관리 번호
	    private String p_na;      // 공원명
	    private String p_ty;      // 공원 구분
	    private String p_rad;     // 소재지 도로명 주소
	    private String p_ad;      // 소재지 지번 주소
	    private double p_lat;     // 위도
	    private double p_lon;     // 경도
	    private String p_ceNa;    // 관리 기관명
	    private String p_pho;     // 전화번호
	    private String p_ce_ad;    // 제공 기관명
	    
	    
		public int getP_idx() {
			return p_idx;
		}
		public void setP_idx(int p_idx) {
			this.p_idx = p_idx;
		}
		public String getP_num() {
			return p_num;
		}
		public void setP_num(String p_num) {
			this.p_num = p_num;
		}
		public String getP_na() {
			return p_na;
		}
		public void setP_na(String p_na) {
			this.p_na = p_na;
		}
		public String getP_ty() {
			return p_ty;
		}
		public void setP_ty(String p_ty) {
			this.p_ty = p_ty;
		}
		public String getP_rad() {
			return p_rad;
		}
		public void setP_rad(String p_rad) {
			this.p_rad = p_rad;
		}
		public String getP_ad() {
			return p_ad;
		}
		public void setP_ad(String p_ad) {
			this.p_ad = p_ad;
		}
		public double getP_lat() {
			return p_lat;
		}
		public void setP_lat(double p_lat) {
			this.p_lat = p_lat;
		}
		public double getP_lon() {
			return p_lon;
		}
		public void setP_lon(double p_lon) {
			this.p_lon = p_lon;
		}
		public String getP_ceNa() {
			return p_ceNa;
		}
		public void setP_ceNa(String p_ceNa) {
			this.p_ceNa = p_ceNa;
		}
		public String getP_pho() {
			return p_pho;
		}
		public void setP_pho(String p_pho) {
			this.p_pho = p_pho;
		}
		public String getP_ce_ad() {
			return p_ce_ad;
		}
		public void setP_ce_ad(String p_ce_ad) {
			this.p_ce_ad = p_ce_ad;
		}
	


	    // p_ad에서 앞 2글자만 따오자
		public String getShortPAd() {
	        if (p_ad != null && p_ad.length() >= 2) {
	            return p_ad.substring(0, 2); // p_ad의 앞 2글자 반환
	        }
	        return "";  // null이거나 길이가 2보다 작은 경우 빈 문자열 반환
	    }
	    
	    
	}