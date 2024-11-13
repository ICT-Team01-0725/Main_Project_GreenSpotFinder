-- notice_db.notice_tbl 생성 쿼리
CREATE TABLE IF NOT EXISTS notice_tbl (
    n_idx INT AUTO_INCREMENT PRIMARY KEY,
    n_chk VARCHAR(50),
    n_opt VARCHAR(50),  
    a_idx INT,           -- 관리자 외래키
    n_tle VARCHAR(50),
    n_con TEXT,
    n_dat DATETIME,
    n_out VARCHAR(50),
    n_hit INT,
    n_pic VARCHAR(50),
    FOREIGN KEY (a_idx) REFERENCES admin_db.admin_tbl(a_idx)  
);
