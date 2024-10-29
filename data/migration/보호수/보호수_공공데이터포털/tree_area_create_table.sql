CREATE TABLE tree_db.tree_area_tbl (
    t_area_idx INT AUTO_INCREMENT PRIMARY KEY,      -- 고유번호 (자동 증가)
    t_ce_na VARCHAR(255),                            -- 관리기관명
    t_num INT,                                       -- 지정번호
    t_sdate VARCHAR(20),                             -- 보호수 지정일자
    t_ty VARCHAR(100),                               -- 보호수 유형명
    t_fna VARCHAR(100) DEFAULT '',                              -- 과명
    t_bna VARCHAR(255) DEFAULT '',                              -- 학명
    t_tty VARCHAR(100),                              -- 나무종류
    t_age INT,                                       -- 나무 나이
    t_fr VARCHAR(50),                                -- 품격명
    t_gr VARCHAR(50),                                -- 지목명
    t_gr_num VARCHAR(100) DEFAULT '',               -- 지적 (빈 문자열로 기본값 설정)
    t_rad VARCHAR(255) DEFAULT '',                   -- 소재지 도로명 주소 (빈 문자열로 기본값 설정)
    t_ad VARCHAR(255) DEFAULT ''                                 -- 소재지 지번 주소

    -- NaN이 존재하는 칼럼에 DEFAULT ''를 추가하여 NULL 값을 방지하고 빈 문자열로 기본값을 설정
    -- ( NaN 값을 빈 문자열로 대체 가능 )
);
