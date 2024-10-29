CREATE TABLE tree_db.tree_stat_tbl (
    t_stat_idx INT AUTO_INCREMENT PRIMARY KEY,
     t_sta_info VARCHAR(255) NOT NULL,       -- 지정정보
    t_sta_spec VARCHAR(255) NOT NULL,       -- 수종명(학명)
    t_sta_ad VARCHAR(255) NOT NULL,         -- 위치
    t_sta_dat DATE NOT NULL,                 -- 지정일
    t_sta_age VARCHAR(50) NOT NULL         -- 수령
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
