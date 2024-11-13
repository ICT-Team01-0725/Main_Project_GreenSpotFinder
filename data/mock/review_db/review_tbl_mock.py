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
    'database': 'review_db'
}

# 3. MySQL 연결
connection = pymysql.connect(
    user=db_config['user'],
    password=db_config['password'],
    host=db_config['host'],
    database=db_config['database']
)

# 4. user_tbl에서 u_idx 가져오기
def get_admin_ids():
    try:
        with connection.cursor() as cursor:
            cursor.execute("SELECT a_idx FROM admin_db.admin_tbl")  # admin_db 명시
            result = cursor.fetchall()
            return [row[0] for row in result]  # a_idx 값들을 리스트 형태로 추출
    except Exception as e:
        print(f"admin_db.admin_tbl에서 a_idx 가져오는 중 에러 발생: {e}")
        return []

# 5. review_tbl 테이블 생성 쿼리
create_review_tbl_query = """
CREATE TABLE IF NOT EXISTS review_tbl (
    rev_idx INT AUTO_INCREMENT PRIMARY KEY,
    rev_tle VARCHAR(50),
    rev_con TEXT,
    rev_pic MEDIUMBLOB,
    rev_po INT,
    u_idx INT,  
    rev_dat DATETIME,
    rev_up BOOLEAN,
    rev_bor VARCHAR(50),
    rev_ref MEDIUMBLOB,
    FOREIGN KEY (a_idx) REFERENCES user_db.user_tbl(u_idx) ON DELETE CASCADE
);
"""

# 6. 목업 데이터 삽입 함수
def insert_review_mock_data(admin_ids, count=20):
    try:
        with connection.cursor() as cursor:
            for _ in range(count):
                a_idx = random.choice(admin_ids)  
                rev_tle = fake.sentence(nb_words=5)  
                rev_con = fake.paragraph(nb_sentences=3)
                rev_pic = None  # 또는 필요에 따라 이미지 데이터를 추가할 수 있습니다.
                rev_po = random.randint(1, 5)  # 평점 1에서 5 사이
                rev_dat = fake.date_time_between(start_date='-1y', end_date='now')
                rev_up = random.choice([True, False])  # 평점 수정 여부
                rev_bor = fake.word()  # 필요한 경우 해당 데이터를 추가
                rev_ref = None  # 참조 데이터 (필요시 추가)

                insert_query = """
                INSERT INTO review_tbl (a_idx, rev_tle, rev_con, rev_pic, rev_po, rev_dat, rev_up, rev_bor, rev_ref)
                VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s)
                """
                cursor.execute(insert_query, (a_idx, rev_tle, rev_con, rev_pic, rev_po, rev_dat, rev_up, rev_bor, rev_ref))
            
            connection.commit()
            print(f"{count}개의 데이터가 'review_tbl'에 삽입되었습니다.")
    
    except Exception as e:
        print(f"review_tbl 데이터 삽입 중 에러 발생: {e}")
        connection.rollback()

# 7. 테이블 생성 및 목업 데이터 삽입 실행
try:
    with connection.cursor() as cursor:
        cursor.execute(create_review_tbl_query)
    
    # admin_ids 가져오기
    admin_ids = get_admin_ids()
    
    if admin_ids:
        insert_review_mock_data(admin_ids, 10)
    else:
        print("admin_db.admin_tbl에 데이터가 없습니다. 목업 데이터를 삽입할 수 없습니다.")

finally:
    connection.close()
    print("MySQL 연결이 종료되었습니다.")
