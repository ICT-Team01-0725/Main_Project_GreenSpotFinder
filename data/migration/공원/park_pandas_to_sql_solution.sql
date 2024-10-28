-- VARCHAR의 재설정을 통한 DB 공간 효율 조절 작업

SELECT
    MAX(CHAR_LENGTH(p_num)) AS max_p_num_length,        -- 11
    MAX(CHAR_LENGTH(p_na)) AS max_p_na_length,          -- 28
    MAX(CHAR_LENGTH(p_ty)) AS max_p_ty_length,          -- 5
    MAX(CHAR_LENGTH(p_rad)) AS max_p_rad_length,        -- 28
    MAX(CHAR_LENGTH(p_ad)) AS max_p_ad_length,          -- 27
    MAX(CHAR_LENGTH(p_ce_na)) AS max_p_ce_na_length,    -- 10
    MAX(CHAR_LENGTH(p_pho)) AS max_p_pho_length,        -- 13
    MAX(CHAR_LENGTH(p_ce_ad)) AS max_p_ce_ad_length     -- 9
FROM park_db.park_tbl;

ALTER TABLE park_db.park_tbl
MODIFY COLUMN p_num VARCHAR(15),         -- 관리번호
MODIFY COLUMN p_na VARCHAR(40),          -- 공원명
MODIFY COLUMN p_ty VARCHAR(10),          -- 공원구분
MODIFY COLUMN p_rad VARCHAR(40),         -- 소재지도로명주소
MODIFY COLUMN p_ad VARCHAR(40),          -- 소재지지번주소
MODIFY COLUMN p_ce_na VARCHAR(20),       -- 관리기관명
MODIFY COLUMN p_pho VARCHAR(20),         -- 전화번호
MODIFY COLUMN p_ce_ad VARCHAR(20);       -- 제공기관명


