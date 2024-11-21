import pymysql
import random
from faker import Faker
from datetime import timedelta

# 1. Faker 초기화
fake = Faker()

# 2. MySQL 연결 설정
db_config = {
    'user': 'kkyungseo',
    'password': '1111',
    'host': 'localhost',
    'database': 'inquiry_db'
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

# 4. 데이터 삽입 함수 (문의)
def insert_mock_data(count=10):
    try:
        # 트랜잭션 시작
        with connection.cursor() as cursor:
            connection.begin()  # 트랜잭션 시작
            
            # u_idx와 u_reg 값을 가져옴
            cursor.execute("SELECT u_idx, u_reg FROM user_db.user_tbl;")
            user_data = cursor.fetchall()  # u_idx와 u_reg 값을 가져옴
            print(f"유효한 u_idx 및 u_reg 목록: {user_data}")  # 디버깅 메시지

            # 관리자의 실제 a_idx 값 조회
            cursor.execute("SELECT a_idx FROM admin_db.admin_tbl;")
            admin_data = cursor.fetchall()  # a_idx 값을 가져옴
            print(f"유효한 a_idx 목록: {admin_data}")  # 디버깅 메시지

            # 목업 데이터 삽입
            print(f"{count}개의 목업 데이터를 삽입 중입니다...")  # 디버깅 메시지
            for _ in range(count):
                u_idx, u_reg = random.choice(user_data)  # 유효한 u_idx와 u_reg 값을 랜덤 선택
                i_tle = fake.sentence(nb_words=6)[:50]  # 문의 제목
                i_con = fake.text(max_nb_chars=500)  # 문의 내용
                
                # i_dat는 u_reg 이후의 날짜로 설정
                i_dat = fake.date_between(start_date=u_reg)  # u_reg 이후의 날짜
                
                i_ans = random.choice([True, False])  # 답변 여부
                a_idx = random.choice(admin_data)[0] if i_ans else None  # 답변이 있으면 관리자 인덱스 선택, 없으면 None
                i_acon = fake.text(max_nb_chars=300) if i_ans else None  # 답변 내용 (답변이 있을 경우만)

                # 데이터 삽입 전 값 출력
                print(f"Inserting: u_idx={u_idx}, i_tle={i_tle}, i_con={i_con}, i_dat={i_dat}, i_ans={i_ans}, a_idx={a_idx}, i_acon={i_acon}")
                
                # 데이터 삽입
                insert_query = """
                INSERT INTO inquiry_tbl (u_idx, i_tle, i_con, i_dat, i_ans, a_idx, i_acon)
                VALUES (%s, %s, %s, %s, %s, %s, %s)
                """
                cursor.execute(insert_query, (u_idx, i_tle, i_con, i_dat, i_ans, a_idx, i_acon))

            # 커밋하여 변경사항 반영
            connection.commit()
            print(f"{count}개의 데이터가 'inquiry_tbl'로 성공적으로 삽입되었습니다.")  # 디버깅 메시지
    
    except Exception as e:
        print(f"에러가 발생했습니다! : {e}")
        connection.rollback()  # 오류 발생 시 롤백

# 5. 데이터 삽입 실행
try:
    insert_mock_data(10)  # 10개의 문의 데이터 삽입
finally:
    print("MySQL 연결을 종료합니다.")  # 디버깅 메시지
    connection.close()
