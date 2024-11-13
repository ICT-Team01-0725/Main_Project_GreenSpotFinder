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

# 3. 비밀번호 정규식 (정해진 조건에 맞는 비밀번호 생성)
password_pattern = r'^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*])(?=.*[0-9])[A-Za-z\d!@#$%^&*]{8,15}$'

def generate_valid_password():
    while True:
        password = fake.password(length=10)
        if re.match(password_pattern, password):
            return password

# 4. 대한민국 전화번호 형식 생성 함수
def generate_korean_phone_number():
    area_code = "010"  # 대한민국 모바일 전화번호 앞자리 고정
    middle = random.randint(1000, 9999)     # 두 번째 부분
    last = random.randint(1000, 9999)       # 세 번째 부분
    return f"{area_code}-{middle:04d}-{last:04d}"

# 5. MySQL 연결
connection = pymysql.connect(
    user=db_config['user'],
    password=db_config['password'],
    host=db_config['host'],
    database=db_config['database']
)

# 6. 테이블 생성 쿼리
create_table_query = """
CREATE TABLE IF NOT EXISTS admin_tbl (
    a_idx INT AUTO_INCREMENT PRIMARY KEY,
    a_id VARCHAR(40),
    a_pw VARCHAR(40),
    a_na VARCHAR(20),
    a_pho VARCHAR(20),
    a_em VARCHAR(50),
    a_stat TINYINT,
    a_log TINYINT
);
"""

# 7. 데이터 삽입 함수 (관리자)
def insert_mock_data(count=10):
    try:
        with connection.cursor() as cursor:
            for _ in range(count):
                a_id = fake.user_name()                 # 관리자 아이디
                a_pw = generate_valid_password()        # 정규식에 맞는 비밀번호 생성
                a_na = fake.name()                      # 관리자 이름
                a_pho = generate_korean_phone_number()  # 대한민국 전화번호 형식 생성
                a_em = fake.email()                     # 관리자 이메일
                a_stat = random.choice([0, 1])          # 활동 여부 (0 또는 1)
                a_log = random.choice([0, 1])           # 로그인 여부 (0 또는 1)

                # 데이터 삽입
                insert_query = """
                INSERT INTO admin_tbl (a_id, a_pw, a_na, a_pho, a_em, a_stat, a_log)
                VALUES (%s, %s, %s, %s, %s, %s, %s)
                """
                cursor.execute(insert_query, (a_id, a_pw, a_na, a_pho, a_em, a_stat, a_log))
            
            # 커밋하여 변경사항 반영
            connection.commit()
            print(f"{count}개의 데이터가 'admin_tbl'로 삽입되었습니다.")
    
    except Exception as e:
        print(f"에러가 발생했습니다! : {e}")
        connection.rollback()

# 8. 테이블 생성 및 데이터 삽입
try:
    with connection.cursor() as cursor:
        cursor.execute(create_table_query)
    insert_mock_data(10)  # 10개의 목업 데이터 삽입
finally:
    connection.close()  # 연결 종료
