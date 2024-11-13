-- fna_db.fna_tbl 생성 쿼리

CREATE TABLE IF NOT EXISTS fna_tbl (
    f_idx INT AUTO_INCREMENT PRIMARY KEY,          -- 자동 증가 기본 키
    a_idx INT,                                     -- 외래 키 참조 필드
    f_tle VARCHAR(50),                             -- 질문 제목
    f_fcon TEXT,                                   -- 질문 내용
    f_acon TEXT,                                   -- 답변 내용
    f_dat DATETIME,                                -- 생성 날짜
    f_up DATETIME,                                 -- 업데이트 날짜
    CONSTRAINT fk_admin_a_idx                      -- 외래 키 제약 조건 이름 (옵션)
    FOREIGN KEY (a_idx) 
        REFERENCES admin_db.admin_tbl(a_idx)       -- 다른 데이터베이스의 테이블 참조
        ON DELETE CASCADE                          -- 연결된 레코드 삭제 시 동작
) ENGINE=InnoDB;                                   -- InnoDB 스토리지 엔진 사용
