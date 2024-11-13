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
    'database': 'user_db'
}

# 3. 비밀번호 정규식 (정해진 조건에 맞는 비밀번호 생성)
password_pattern = r'^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*])(?=.*[0-9])[A-Za-z\d!@#$%^&*]{8,15}$'

def generate_valid_password():
    while True:
        password = fake.password(length=12, special_chars=True, digits=True, upper_case=True, lower_case=True)
        if re.match(password_pattern, password):
            return password

# 4-1. 대한민국 전화번호 형식 생성 함수
def generate_korean_phone_number():
    area_code = "010"  # 대한민국 모바일 전화번호 앞자리 고정
    middle = random.randint(1000, 9999)     # 두 번째 부분
    last = random.randint(1000, 9999)       # 세 번째 부분
    return f"{area_code}-{middle:04d}-{last:04d}"

# 4-2. 이미지 바이너리 랜덤값 생성 함수 (추후 삽입 조절 가능)
# def generate_random_image():
# return b'\x89PNG\r\n\x1a\n\x00\x00\x00\rIHDR\x00\x00\x00\x10\x00\x00\x00\x10\x08\x06\x00\
# u_pic MEDIUMBLOB ~ MVC 조절 여부에 따라 삽입
# u_pic = generate_random_image()         
# ~ 이미지 파일 바이너리 데이터 생성

try:
    # 5. MySQL 연결
    connection = pymysql.connect(
        user=db_config['user'],
        password=db_config['password'],
        host=db_config['host'],
        database=db_config['database']
    )

    # 6. 테이블 생성 쿼리
    create_table_query = """
    CREATE TABLE IF NOT EXISTS user_tbl (
        u_idx INT AUTO_INCREMENT PRIMARY KEY,
        u_id VARCHAR(40),
        u_pw VARCHAR(225),
        u_na VARCHAR(20),
        u_pho VARCHAR(20),
        u_gen VARCHAR(5),
        u_reg DATETIME,
        u_out DATETIME,
        a_idx INT,             
        u_outr VARCHAR(225),
        CONSTRAINT fk_admin_idx FOREIGN KEY (a_idx) REFERENCES admin_db.admin_tbl(a_idx) 
        ON DELETE SET NULL ON UPDATE CASCADE
    );
    """

    # 테이블 생성
    with connection.cursor() as cursor:
        cursor.execute(create_table_query)
        connection.commit()

    # 7. 데이터 삽입 함수 (사용자)
    def insert_mock_user_data(count=20):
        try:
            with connection.cursor() as cursor:
                for _ in range(count):
                    u_id = fake.user_name()                 # 사용자 아이디
                    u_pw = generate_valid_password()        # 정규식에 맞는 비밀번호 생성
                    u_na = fake.name()                      # 사용자 이름
                    u_pho = generate_korean_phone_number()  # 대한민국 전화번호 형식 생성
                    u_gen = random.choice(['M', 'F'])       # 성별 (M 또는 F)
                    u_reg = fake.date_this_decade(before_today=True, after_today=False)  # 가입 날짜
                    # 탈퇴 날짜: 가입 날짜 이후 또는 None
                    u_out = fake.date_this_decade(after_today=False) if random.choice([True, False]) else None
                    if u_out and u_out < u_reg:
                        u_out = None  # 탈퇴 날짜가 가입 날짜보다 빠르면 None으로 설정
                    a_idx = random.randint(1, 10)           # 관리자 테이블에서 참조할 a_idx
                    u_outr = fake.text(max_nb_chars=225)    # 사용자 약관 동의 내용

                    # 데이터 삽입
                    insert_query = """
                    INSERT INTO user_tbl (u_id, u_pw, u_na, u_pho, u_gen, u_reg, u_out, a_idx, u_outr)
                    VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s)
                    """
                    cursor.execute(insert_query, (u_id, u_pw, u_na, u_pho, u_gen, u_reg, u_out, a_idx, u_outr))
                
                # 커밋하여 변경사항 반영
                connection.commit()
                print(f"{count}개의 데이터가 'user_tbl'로 삽입되었습니다.")
        
        except Exception as e:
            print(f"에러가 발생했습니다! : {e}")
            connection.rollback()

    # 사용자 데이터 삽입 실행
    insert_mock_user_data(20)

except pymysql.MySQLError as e:
    print(f"데이터베이스 연결 오류: {e}")

finally:
    if connection:
        connection.close()
        print("MySQL 연결이 종료되었습니다.")
