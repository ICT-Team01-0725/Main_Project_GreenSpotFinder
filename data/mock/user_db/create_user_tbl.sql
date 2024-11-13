-- user_db.user_tbl 생성 쿼리 
CREATE TABLE IF NOT EXISTS user_tbl (
    u_idx INT AUTO_INCREMENT PRIMARY KEY,    
    u_id VARCHAR(40) NOT NULL,                
    u_pw VARCHAR(225) NOT NULL,               
    u_na VARCHAR(20) NOT NULL,               
    u_pho VARCHAR(20),                      
    u_gen VARCHAR(5),                       
    u_reg DATETIME NOT NULL,                
    u_out DATETIME,                         
    a_idx INT,                            
    u_outr VARCHAR(225),                    
    CONSTRAINT fk_admin_idx FOREIGN KEY (a_idx) REFERENCES admin_db.admin_tbl(a_idx)
    ON DELETE SET NULL ON UPDATE CASCADE     				-- 외래 키 제약 조건
);
