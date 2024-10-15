SHOW VARIABLES LIKE 'character_set_database';
-- characeter_set_database가 UTF-8로 나오지 않으면, 아래를 실행합니다.
CREATE DATABASE green_db CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
-- 새로운 db를 만들면 이제 한글이 포함된 json이 정상적으로 import 될 수 있습니다. road_db

-- 혹시 미리 만들어둔 다른 db가 있어 table 복사까지 필요한 경우라면,
-- ( 아래의 경우는 green_db가 복사받을 곳, greenspot_db가 원본테이블이 있는 곳 )
CREATE TABLE green_db.road_db LIKE greenspot_db.road_db;
INSERT INTO green_db.road_db SELECT * FROM greenspot_db.road_db;

-- SCHEMAS를 새로고침한 뒤에 보면, table이 원하는 db 위치에 만들어져 있음을 볼 수 있습니다.