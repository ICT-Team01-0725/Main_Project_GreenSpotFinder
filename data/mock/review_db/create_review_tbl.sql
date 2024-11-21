-- review_db.review_tbl 생성 쿼리
CREATE TABLE review_tbl (
    rev_idx INT AUTO_INCREMENT PRIMARY KEY,
    rev_tle VARCHAR(50),
    rev_con VARCHAR(500),
    rev_hit INT,
    u_idx INT,
    rev_dat DATETIME,
    rev_up BOOLEAN,
    rev_pic TEXT,
        CONSTRAINT fk_user_idx FOREIGN KEY (u_idx) REFERENCES user_db.user_tbl(u_idx)
        ON DELETE SET NULL ON UPDATE CASCADE
);