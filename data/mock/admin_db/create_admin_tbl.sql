-- admin_db.admin_tbl 생성 쿼리
CREATE TABLE admin_tbl (
    a_idx INT AUTO_INCREMENT PRIMARY KEY, -- 자동 증가하는 기본키
    a_id VARCHAR(40),                    -- 사용자 ID
    a_pw VARCHAR(40),                    -- 사용자 비밀번호
    a_na VARCHAR(20),                    -- 사용자 이름
    a_pho VARCHAR(20),                   -- 사용자 전화번호
    a_em VARCHAR(50),                    -- 사용자 이메일
    a_stat TINYINT,                      -- 활동 여부 (0 또는 1)
    a_log TINYINT                        -- 로그인 여부 (0 또는 1)
);
