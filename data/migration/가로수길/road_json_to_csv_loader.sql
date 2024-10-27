-- 동일한 폴더 경로에 존재하는 road_json_to_csv의 Python, SQL 파일 중 하나를 실행하면 됩니다

-- Pandas로  CSV로 변환한 JSON 파일을 SQL 테이블로 로드하기 

-- local_infile 옵션 활성화하기 (프롬포트 혹은 터미널 추가 설정 필요)
SET GLOBAL local_infile = 1;

-- 데이터 로드 명령어 실행
LOAD DATA LOCAL INFILE 'C:\\Users\\5\\Desktop\\DATA\\data\\seeders\\가로수길\\전국가로수길정보표준데이터.csv'
INTO TABLE road_db.road_tbl
FIELDS TERMINATED BY ',' 
ENCLOSED BY '"' 
LINES TERMINATED BY '\r\n' 
IGNORE 1 ROWS;

-- 칼럼명 변경
ALTER TABLE road_db.road_tbl 
CHANGE COLUMN `가로수길명` r_na VARCHAR(255),
CHANGE COLUMN `가로수길시작위도` r_s_lat DOUBLE,
CHANGE COLUMN `가로수길시작경도` r_s_lon DOUBLE,
CHANGE COLUMN `가로수길종료위도` r_e_lat DOUBLE,
CHANGE COLUMN `가로수길종료경도` r_e_lon DOUBLE,
CHANGE COLUMN `가로수종류` r_ty VARCHAR(100),
CHANGE COLUMN `가로수수량` r_vol INT,
CHANGE COLUMN `가로수길길이` r_len DOUBLE,
CHANGE COLUMN `식재연도` r_ye INT,
CHANGE COLUMN `가로수길소개` r_sto VARCHAR(255),
CHANGE COLUMN `도로명` r_rna VARCHAR(255),
CHANGE COLUMN `도로종류` r_rty VARCHAR(100),
CHANGE COLUMN `도로구간` r_rsec VARCHAR(255),
CHANGE COLUMN `관리기관전화번호` r_pho VARCHAR(20),
CHANGE COLUMN `관리기관명` r_ce_na VARCHAR(100),
CHANGE COLUMN `데이터기준일자` r_dat VARCHAR(20),
CHANGE COLUMN `제공기관코드` r_ce_co INT,
CHANGE COLUMN `제공기관명` r_ce_ad VARCHAR(255);
