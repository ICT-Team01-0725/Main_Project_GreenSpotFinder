CREATE TABLE park_db.park_tbl (
	p_idx INT AUTO_INCREMENT PRIMARY KEY,   -- 고유번호 (자동 증가)
    p_num VARCHAR(50),            			-- 관리번호
    p_na VARCHAR(500),            			-- 공원명
    p_ty VARCHAR(500),            			-- 공원구분
    p_rad VARCHAR(500),           			-- 소재지도로명주소
    p_ad VARCHAR(500),            			-- 소재지지번주소
    p_lat DOUBLE,                 			-- 위도
    p_lon DOUBLE,                 			-- 경도
    p_ce_na VARCHAR(50),          			-- 관리기관명
    p_pho VARCHAR(50),            			-- 전화번호
    p_ce_ad VARCHAR(50)           			-- 제공기관명
);