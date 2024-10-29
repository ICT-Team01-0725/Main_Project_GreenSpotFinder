SELECT
    MAX(CHAR_LENGTH(t_ce_na)) AS max_t_ce_na_length,     -- 14
    MAX(t_num) AS max_t_num_length,                      -- 43993 (INT이므로 MAX 사용)
    MAX(CHAR_LENGTH(t_sdate)) AS max_t_sdate_length,     -- 10
    MAX(CHAR_LENGTH(t_ty)) AS max_t_ty_length,           -- 9
    MAX(CHAR_LENGTH(t_fna)) AS max_t_fna_length,         -- 21
    MAX(CHAR_LENGTH(t_bna)) AS max_t_bna_length,         -- 78
    MAX(CHAR_LENGTH(t_tty)) AS max_t_tty_length,         -- 24
    MAX(t_age) AS max_t_age_length,                      -- 1345 (INT이므로 MAX 사용)
    MAX(CHAR_LENGTH(t_fr)) AS max_t_fr_length,           -- 5
    MAX(CHAR_LENGTH(t_gr)) AS max_t_gr_length,           -- 5
    MAX(CHAR_LENGTH(t_gr_num)) AS max_t_gr_num_length,   -- 10
    MAX(CHAR_LENGTH(t_rad)) AS max_t_rad_length,         -- 46
    MAX(CHAR_LENGTH(t_ad)) AS max_t_ad_length            -- 86
FROM tree_db.tree_area_tbl;


ALTER TABLE tree_db.tree_area_tbl
MODIFY COLUMN t_ce_na VARCHAR(15),               -- 관리기관명 
MODIFY COLUMN t_num INT,                         -- 지정번호 (INT)
MODIFY COLUMN t_sdate VARCHAR(10),               -- 보호수 지정일자 
MODIFY COLUMN t_ty VARCHAR(10),                  -- 보호수 유형명 
MODIFY COLUMN t_fna VARCHAR(22),                 -- 과명 
MODIFY COLUMN t_bna VARCHAR(80),                 -- 학명 
MODIFY COLUMN t_tty VARCHAR(25),                 -- 나무종류 
MODIFY COLUMN t_age INT,                         -- 나무 나이 (INT)
MODIFY COLUMN t_fr VARCHAR(6),                   -- 품격명 
MODIFY COLUMN t_gr VARCHAR(6),                   -- 지목명 
MODIFY COLUMN t_gr_num VARCHAR(11),              -- 지적 
MODIFY COLUMN t_rad VARCHAR(50),                 -- 소재지 도로명 주소 
MODIFY COLUMN t_ad VARCHAR(100);                 -- 소재지 지번 주소 
