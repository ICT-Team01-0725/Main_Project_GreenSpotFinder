-- 지정한 안의 테이블 생성
CREATE TABLE road_db.road_tbl (
    r_idx INT AUTO_INCREMENT PRIMARY KEY,   -- 고유번호 (자동 증가)
    r_na VARCHAR(255),                      -- 가로수길명
    r_s_lat DOUBLE,                         -- 가로수길시작위도
    r_s_lon DOUBLE,                         -- 가로수길시작경도
    r_e_lat DOUBLE,                         -- 가로수길종료위도
    r_e_lon DOUBLE,                         -- 가로수길종료경도
    r_ty VARCHAR(100),                      -- 가로수종류
    r_vol INT,                              -- 가로수수량
    r_len DOUBLE,                           -- 가로수길길이
    r_ye INT,								-- 식재연도
    r_sto VARCHAR(255),                     -- 가로수길소개
    r_rna VARCHAR(255),                     -- 도로명
    r_rty VARCHAR(100),                     -- 도로종류
    r_rsec VARCHAR(255),                    -- 도로구간
    r_pho VARCHAR(20),                      -- 관리기관전화번호
    r_ce_na VARCHAR(100),                   -- 관리기관명
    r_dat VARCHAR(20),                      -- 데이터기준일자
    r_ce_co INT,                            -- 제공기관코드
    r_ce_ad VARCHAR(255)                    -- 제공기관명
);
