-- Pandas의 DataFrame에서 읽어들인 csv 타입이 object로 처리되었을 경우,
-- 전체 자료형이 TEXT로 설정되므로 자료형 변경 작업을 거쳐야 함

-- 변경 작업시,
-- 데이터 손실 방지를 위해 VARCHAR는 큰 수로 우선 지정 (실제 데이터보다 큰 단위)

ALTER TABLE road_db.road_tbl
MODIFY COLUMN r_na VARCHAR(500),	-- 가로수길명
MODIFY COLUMN r_s_lat DOUBLE,		-- 가로수길시작위도
MODIFY COLUMN r_s_lon DOUBLE,		-- 가로수길시작경도
MODIFY COLUMN r_e_lat DOUBLE,		-- 가로수길종료위도
MODIFY COLUMN r_e_lon DOUBLE,  		-- 가로수길종료경도
MODIFY COLUMN r_ty VARCHAR(500),  	-- 가로수종류
MODIFY COLUMN r_vol INT NULL,   	-- 가로수수량
MODIFY COLUMN r_len DOUBLE,			-- 가로수길길이
MODIFY COLUMN r_sto VARCHAR(1000),  -- 가로수길소개
MODIFY COLUMN r_rna VARCHAR(500),	-- 도로명
MODIFY COLUMN r_rty VARCHAR(500),	-- 도로종류
MODIFY COLUMN r_rsec VARCHAR(500),	-- 도로구간
MODIFY COLUMN r_pho VARCHAR(500),	-- 관리기관전화번호
MODIFY COLUMN r_ce_na VARCHAR(500), -- 관리기관명
MODIFY COLUMN r_dat VARCHAR(500), 	-- 데이터기준일자 
MODIFY COLUMN r_ce_co INT,			-- 제공기관코드
MODIFY COLUMN r_ce_ad VARCHAR(500); -- 제공기관명


-- VARCHAR의 재설정을 통한 DB 공간 효율 조절 작업

SELECT
    MAX(LENGTH(r_na)) AS max_r_na_length,		-- 140
    MAX(LENGTH(r_ty)) AS max_r_ty_length,		-- 165
    MAX(LENGTH(r_sto)) AS max_r_sto_length,     -- 887
    MAX(LENGTH(r_rna)) AS max_r_rna_length,		-- 145
    MAX(LENGTH(r_rty)) AS max_r_rty_length,		-- 29
    MAX(LENGTH(r_rsec)) AS max_r_rsec_length,   -- 305
    MAX(LENGTH(r_pho)) AS max_r_pho_length,		-- 13
    MAX(LENGTH(r_ce_na)) AS max_r_ce_na_length, -- 104
    MAX(LENGTH(r_dat)) AS max_r_dat_length,		-- 10
    MAX(LENGTH(r_ce_ad)) AS max_r_ce_ad_length	-- 34
FROM road_db.road_tbl;

ALTER TABLE road_db.road_tbl
MODIFY COLUMN r_na VARCHAR(200),     -- 가로수길명
MODIFY COLUMN r_ty VARCHAR(200),     -- 가로수종류
MODIFY COLUMN r_sto VARCHAR(1000),   -- 가로수길소개
MODIFY COLUMN r_rna VARCHAR(200),    -- 도로명
MODIFY COLUMN r_rty VARCHAR(50),     -- 도로종류
MODIFY COLUMN r_rsec VARCHAR(500),   -- 도로구간
MODIFY COLUMN r_pho VARCHAR(50),     -- 관리기관전화번호
MODIFY COLUMN r_ce_na VARCHAR(200),  -- 관리기관명
MODIFY COLUMN r_dat VARCHAR(50),     -- 데이터기준일자
MODIFY COLUMN r_ce_ad VARCHAR(34);   -- 제공기관명


