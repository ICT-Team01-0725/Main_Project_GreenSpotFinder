-- comment_db.comment_tbl 생성 쿼리
CREATE TABLE comment_tbl (
    c_idx INT AUTO_INCREMENT PRIMARY KEY,
    u_idx INT,
    c_con TEXT,
    c_dat DATETIME,
    c_up BOOLEAN,
    c_out BOOLEAN,
    c_bor VARCHAR(20),
    c_ref VARCHAR(20),
    CONSTRAINT fk_user_idx FOREIGN KEY (u_idx) REFERENCES user_db.user_tbl(u_idx)
        ON DELETE SET NULL ON UPDATE CASCADE
);
