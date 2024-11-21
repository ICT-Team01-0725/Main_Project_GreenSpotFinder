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
    'database': 'comment_db'
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

# 4. 데이터 삽입 함수 (댓글)
def insert_mock_data(count=30):
    try:
        # 트랜잭션 시작
        with connection.cursor() as cursor:
            connection.begin()  # 트랜잭션 시작
            
            # u_idx의 실제 범위 확인
            cursor.execute("SELECT MIN(u_idx), MAX(u_idx) FROM user_db.user_tbl;")
            result = cursor.fetchone()
            min_uidx = result[0]  # 첫 번째 값 (MIN(u_idx))
            max_uidx = result[1]  # 두 번째 값 (MAX(u_idx))
            print(f"u_idx 범위: {min_uidx} ~ {max_uidx}")  # 디버깅 메시지

            # 실제로 존재하는 u_idx 값 조회
            cursor.execute("SELECT u_idx, u_reg FROM user_db.user_tbl;")
            user_data = cursor.fetchall()  # u_idx와 u_reg 값을 가져옴
            print(f"유효한 u_idx 및 u_reg 목록: {user_data}")  # 디버깅 메시지

            # 목업 데이터 삽입
            print(f"{count}개의 목업 데이터를 삽입 중입니다...")  # 디버깅 메시지
            for _ in range(count):
                u_idx, u_reg = random.choice(user_data)  # 유효한 u_idx와 u_reg 값을 랜덤 선택
                c_con = fake.text(max_nb_chars=200)  # 댓글 내용
                # u_reg 이후 한 달 간의 날짜 범위 내에서 c_dat 생성
                c_dat = fake.date_between(start_date=u_reg, end_date=u_reg + timedelta(days=30))  # 한 달 간의 날짜 범위
                c_up = random.choice([True, False])  # 수정 여부
                c_out = random.choice([True, False])  # 삭제 여부
                # c_bor는 'notice'와 'review' 중 하나로 설정
                c_bor = random.choice(['notice', 'review'])  
                c_ref = random.choice([str(i) for i in range(1, 26)])
            
                
                # 데이터 삽입 전 값 출력
                print(f"Inserting: u_idx={u_idx}, c_con={c_con}, c_dat={c_dat}, c_up={c_up}, c_out={c_out}, c_bor={c_bor}, c_ref={c_ref}")
                
                # 데이터 삽입
                insert_query = """
                INSERT INTO comment_tbl (u_idx, c_con, c_dat, c_up, c_out, c_bor, c_ref)
                VALUES (%s, %s, %s, %s, %s, %s, %s)
                """
                cursor.execute(insert_query, (u_idx, c_con, c_dat, c_up, c_out, c_bor, c_ref))

            # 커밋하여 변경사항 반영
            connection.commit()
            print(f"{count}개의 데이터가 'comment_tbl'로 성공적으로 삽입되었습니다.")  # 디버깅 메시지
    
    except Exception as e:
        print(f"에러가 발생했습니다! : {e}")
        connection.rollback()  # 오류 발생 시 롤백

# 5. 데이터 삽입 실행
try:
    insert_mock_data(30)  # 30개의 댓글 데이터 삽입
finally:
    print("MySQL 연결을 종료합니다.")  # 디버깅 메시지
    connection.close()
