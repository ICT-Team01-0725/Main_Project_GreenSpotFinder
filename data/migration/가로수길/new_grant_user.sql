-- MYSQL의 새로운 사용자 설정 (권한부여목적)
CREATE USER 'kkyungseo'@'localhost' IDENTIFIED BY '1111';

-- 새로운 사용자에게 권한부여
GRANT ALL PRIVILEGES ON road_db.* TO 'kkyungseo'@'localhost';
FLUSH PRIVILEGES;

-- 권한 확인
SHOW GRANTS FOR 'kkyungseo'@'localhost';
