import pymysql
import random
import re
from faker import Faker

# 1. Faker 초기화
fake = Faker()

# 2. MySQL 연결 설정
db_config = {
    'user': 'kkyungseo',
    'password': '1111',
    'host': 'localhost',
    'database': 'admin_db'
}

# 3. MySQL 연결
connection = pymysql.connect(
    user=db_config['user'],
    password=db_config['password'],
    host=db_config['host'],
    database=db_config['database']
)

# 4. 테이블 생성 쿼리
create_table_query = """
CREATE TABLE IF NOT EXISTS comment_tbl (
    c_idx INT AUTO_INCREMENT PRIMARY KEY
    
"""






