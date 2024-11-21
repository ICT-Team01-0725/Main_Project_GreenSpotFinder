-- inquiry_db.inquiry_tbl 생성 쿼리
CREATE TABLE inquiry_tbl (
    i_idx INT AUTO_INCREMENT PRIMARY KEY,
    u_idx INT,
    i_tle VARCHAR(50),
    i_con VARCHAR(500),
    i_dat DATETIME,
    i_ans BOOLEAN,
    a_idx INT,
    i_acon TEXT,
        CONSTRAINT fk_user_idx FOREIGN KEY (u_idx) REFERENCES user_db.user_tbl(u_idx)
        ON DELETE SET NULL ON UPDATE CASCADE,
        CONSTRAINT fk_admin_idx FOREIGN KEY (a_idx) REFERENCES admin_db.admin_tbl(a_idx)
        ON DELETE SET NULL ON UPDATE CASCADE
); 