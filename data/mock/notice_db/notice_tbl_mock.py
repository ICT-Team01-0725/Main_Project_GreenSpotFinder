import pymysql
import random
from faker import Faker
from datetime import datetime

# 1. Faker 초기화
fake = Faker()

# 2. MySQL 연결 설정
db_config = {
    'user': 'kkyungseo',
    'password': '1111',
    'host': 'localhost',
    'database': 'notice_db'  
}

# 3. MySQL 연결
try:
    connection = pymysql.connect(
        user=db_config['user'],
        password=db_config['password'],
        host=db_config['host'],
        database=db_config['database'],
        autocommit=False  # 자동 커밋 비활성화
    )

    # 4. 테이블 생성 함수
    def create_notice_table():
        try:
            with connection.cursor() as cursor:
                create_table_query = """
                CREATE TABLE IF NOT EXISTS notice_tbl (
                    n_idx INT AUTO_INCREMENT PRIMARY KEY,
                    n_chk VARCHAR(1),
                    n_opt VARCHAR(20),
                    a_idx INT,
                    n_tle VARCHAR(255),
                    n_con TEXT,
                    n_dat DATETIME,
                    n_out DATETIME,
                    n_hit INT,
                    n_pic VARCHAR(255),
                    CONSTRAINT fk_admin_idx FOREIGN KEY (a_idx) REFERENCES admin_db.admin_tbl(a_idx)
                    ON DELETE SET NULL ON UPDATE CASCADE
                );
                """
                cursor.execute(create_table_query)
                print("notice_tbl 테이블이 생성되었습니다.")
        
        except Exception as e:
            print(f"테이블 생성 중 에러 발생: {e}")
            connection.rollback()

    # 5. 데이터 삽입 함수 (공지사항)
    def insert_mock_notice_data(count=25):
        try:
            with connection.cursor() as cursor:
                for _ in range(count):
                    n_chk = random.choice(['Y', 'N'])  # 공지사항 여부
                    n_opt = random.choice(['공원', '가로수길', '보호수'])  # 공지사항 옵션 (예시)
                    a_idx = random.randint(1, 10)  # 관리자 테이블에서 참조할 a_idx (현재 DB에 10명 존재)
                    n_tle = fake.sentence(nb_words=5)[:255]  # 공지사항 제목 (길이를 255자로 제한)
                    n_con = fake.text(max_nb_chars=500)  # 공지사항 내용
                    n_dat = fake.date_this_year(before_today=True, after_today=False)  # 공지사항 날짜
                    n_out = fake.date_this_year(before_today=True, after_today=False) if random.choice([True, False]) else None  # 공지사항 만료일
                    n_hit = random.randint(0, 1000)  # 조회수
                    n_pic = fake.image_url(width=640, height=480)  # 임의 이미지 URL
                    
                    # 데이터 삽입 쿼리
                    insert_query = """
                    INSERT INTO notice_tbl (n_chk, n_opt, a_idx, n_tle, n_con, n_dat, n_out, n_hit, n_pic)
                    VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s)
                    """
                    cursor.execute(insert_query, (n_chk, n_opt, a_idx, n_tle, n_con, n_dat, n_out, n_hit, n_pic))
                    
                    # 삽입된 행의 수 출력
                    print(f"삽입된 행 수: {cursor.rowcount}")

                # 명시적으로 커밋
                connection.commit()
                print(f"{count}개의 데이터가 'notice_tbl'로 삽입되었습니다.")
        
        except Exception as e:
            print(f"에러가 발생했습니다! : {e}")
            connection.rollback()

    # 6. 테이블 생성 및 데이터 삽입 실행
    create_notice_table()
    insert_mock_notice_data(25)

except pymysql.MySQLError as e:
    print(f"데이터베이스 연결 오류: {e}")

finally:
    if connection:
        connection.close()
        print("MySQL 연결이 종료되었습니다.")
