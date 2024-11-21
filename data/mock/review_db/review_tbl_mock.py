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
try:
    connection = pymysql.connect(
        user=db_config['user'],
        password=db_config['password'],
        host=db_config['host'],
        database=db_config['database']
    )
    print("MySQL 연결이 성공적으로 생성되었습니다.")  # 디버깅 메시지
except Exception as e:
    print(f"MySQL 연결 실패: {e}")
    exit()

# 4. 데이터 삽입 함수 (리뷰)
def insert_mock_data(count=30):
    try:
        # 트랜잭션 시작
        with connection.cursor() as cursor:
            connection.begin()  # 트랜잭션 시작
            
            # 유효한 u_idx와 u_reg 값 가져오기
            cursor.execute("SELECT u_idx, u_reg FROM user_db.user_tbl;")
            user_data = cursor.fetchall()
            print(f"유효한 u_idx 및 u_reg 목록: {user_data}")  # 디버깅 메시지
            
            # 목업 데이터 삽입
            print(f"{count}개의 목업 데이터를 삽입 중입니다...")  # 디버깅 메시지
            for _ in range(count):
                # 랜덤한 유저 데이터 선택
                u_idx, u_reg = random.choice(user_data)  # u_idx, u_reg 가져오기

                # 데이터 생성
                rev_tle = fake.sentence(nb_words=5)[:50]  # 리뷰 제목
                rev_con = fake.text(max_nb_chars=500)  # 리뷰 내용
                rev_dat = fake.date_time_between(start_date=u_reg)  # 등록일 (u_reg 이후 날짜)
                rev_up = random.choice([True, False])  # 추천 여부
                rev_hit = fake.random_number(digits=2)
                rev_pic = fake.image_url()  # 랜덤 이미지 URL

                # 삽입 데이터 디버깅 메시지 출력
                print(f"Inserting: rev_tle={rev_tle}, rev_con={rev_con}, rev_dat={rev_dat}, "
                      f"rev_up={rev_up}, rev_hit={rev_hit},rev_pic={rev_pic}")

                # 데이터 삽입
                insert_query = """
                INSERT INTO review_tbl (rev_tle, rev_con, u_idx, rev_dat, rev_up, rev_hit, rev_pic)
                VALUES (%s, %s, %s, %s, %s, %s, %s)
                """
                cursor.execute(insert_query, (rev_tle, rev_con, u_idx, rev_dat, rev_up, rev_hit, rev_pic))

            # 변경사항 커밋
            connection.commit()
            print(f"{count}개의 데이터가 'review_tbl'에 성공적으로 삽입되었습니다.")
    
    except Exception as e:
        print(f"에러 발생: {e}")
        connection.rollback()  # 오류 발생 시 롤백

# 5. 데이터 삽입 실행
try:
    insert_mock_data(30)  # 30개의 리뷰 데이터 삽입
finally:
    print("MySQL 연결을 종료합니다.")  # 디버깅 메시지
    connection.close()
