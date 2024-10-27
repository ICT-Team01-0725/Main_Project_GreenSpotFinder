-- 실습시, 이용했던 사용자와 프로젝트 사용자를 구분하기 위해 새로운 사용자를 설정하는 단계를 거칩니다

-- MYSQL의 새로운 사용자 설정 (권한부여목적)
CREATE USER 'kkyungseo'@'localhost' IDENTIFIED BY '1111';

-- 새로운 사용자에게 권한부여
-- 프로젝트 DB 별로 전체 권한 부여
GRANT ALL PRIVILEGES ON road_db.* TO 'kkyungseo'@'localhost';
FLUSH PRIVILEGES;

-- 권한 확인
SHOW GRANTS FOR 'kkyungseo'@'localhost';

-- 권한에 대한 출력값으로
-- result grid에
-- GRANT USAGE ON "*" TO 'kkyungseo'@'localhost'
-- GRANT ALL PREIVILEGES ON 'road_db'.* TO'kkyungseo'@'localhost'
--로 출력이 나와야 권한 설정이 정상적으로 처리된 것입니다
