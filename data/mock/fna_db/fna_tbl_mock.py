import pymysql
import random
from faker import Faker
from datetime import datetime, timedelta

# 1. Faker 초기화
fake = Faker()

# 2. MySQL 연결 설정
db_config = {
    'user': 'kkyungseo',
    'password': '1111',
    'host': 'localhost',
    'database': 'fna_db'
}

# 3. MySQL 연결
connection = pymysql.connect(
    user=db_config['user'],
    password=db_config['password'],
    host=db_config['host'],
    database=db_config['database']
)

# 4. admin_tbl에서 a_idx 가져오기
def get_admin_ids():
    try:
        with connection.cursor() as cursor:
            cursor.execute("SELECT a_idx FROM admin_db.admin_tbl")  # admin_db 명시
            result = cursor.fetchall()
            return [row[0] for row in result]  # a_idx 값들을 리스트 형태로 추출
    except Exception as e:
        print(f"admin_db.admin_tbl에서 a_idx 가져오는 중 에러 발생: {e}")
        return []

# 5. fna_tbl 테이블 생성 쿼리
create_fna_tbl_query = """
CREATE TABLE IF NOT EXISTS fna_tbl (
    f_idx INT AUTO_INCREMENT PRIMARY KEY,
    a_idx INT, 
    f_tle VARCHAR(50),
    f_fcon TEXT,
    f_acon TEXT,
    f_dat DATETIME,
    f_up DATETIME,
    FOREIGN KEY (a_idx) REFERENCES admin_db.admin_tbl(a_idx) ON DELETE CASCADE
);
"""

# 6. 목업 데이터 삽입 함수
def insert_fna_mock_data(admin_ids, count=20):
    try:
        with connection.cursor() as cursor:
            for _ in range(count):
                a_idx = random.choice(admin_ids)  
                f_tle = fake.sentence(nb_words=5)  
                f_fcon = fake.paragraph(nb_sentences=3)
                f_acon = fake.paragraph(nb_sentences=2)
                f_dat = fake.date_time_between(start_date='-1y', end_date='now')
                f_up = f_dat + timedelta(days=random.randint(1, 30))

                insert_query = """
                INSERT INTO fna_tbl (a_idx, f_tle, f_fcon, f_acon, f_dat, f_up)
                VALUES (%s, %s, %s, %s, %s, %s)
                """
                cursor.execute(insert_query, (a_idx, f_tle, f_fcon, f_acon, f_dat, f_up))
            
            connection.commit()
            print(f"{count}개의 데이터가 'fna_tbl'에 삽입되었습니다.")
    
    except Exception as e:
        print(f"fna_tbl 데이터 삽입 중 에러 발생: {e}")
        connection.rollback()

# 7. 테이블 생성 및 목업 데이터 삽입 실행
try:
    with connection.cursor() as cursor:
        cursor.execute(create_fna_tbl_query)
    
    # admin_ids 가져오기
    admin_ids = get_admin_ids()
    
    if admin_ids:
        insert_fna_mock_data(admin_ids, 10)
    else:
        print("admin_db.admin_tbl에 데이터가 없습니다. 목업 데이터를 삽입할 수 없습니다.")

finally:
    connection.close()
    print("MySQL 연결이 종료되었습니다.")
