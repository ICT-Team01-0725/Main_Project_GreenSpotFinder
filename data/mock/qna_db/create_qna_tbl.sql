-- qna_db.qna_tbl 생성 쿼리
CREATE TABLE qna_tbl (
    q_idx INT AUTO_INCREMENT PRIMARY KEY,
    u_idx INT,
    q_tle VARCHAR(50),
    q_con VARCHAR(500),
    q_dat DATETIME,
    a_idx INT,
    q_ans BOOLEAN,
    q_acon TEXT,
        CONSTRAINT fk_user_idx FOREIGN KEY (u_idx) REFERENCES user_db.user_tbl(u_idx)
        ON DELETE SET NULL ON UPDATE CASCADE,
        CONSTRAINT fk_admin_idx FOREIGN KEY (a_idx) REFERENCES admin_db.admin_tbl(a_idx)
        ON DELETE SET NULL ON UPDATE CASCADE
); 