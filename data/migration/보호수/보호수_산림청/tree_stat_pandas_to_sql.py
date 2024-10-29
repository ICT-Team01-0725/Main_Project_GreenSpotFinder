import pandas as pd
import mysql.connector

# CSV 파일 경로
csv_file_path = 'C:\\Users\\5\\Desktop\\DATA\\data\\migration\\보호수\\보호수_산림청\\전국보호수현황.csv'

# CSV 파일을 DataFrame으로 읽기
df = pd.read_csv(csv_file_path, encoding='utf-8-sig')

# 데이터베이스 연결 정보
db_user = 'kkyungseo'        # MySQL 사용자 이름
db_password = '1111'         # MySQL 비밀번호
db_host = 'localhost'         # MySQL 호스트 (예: localhost)
db_name = 'tree_db'           # 사용할 데이터베이스 이름

# MySQL 데이터베이스에 연결
connection = mysql.connector.connect(
    user=db_user,
    password=db_password,
    host=db_host,
    database=db_name
)

cursor = connection.cursor()

# 데이터 삽입 쿼리 준비
insert_query = """
    INSERT INTO tree_stat_tbl (t_sta_info, t_sta_spec, t_sta_ad, t_sta_dat, t_sta_age)
    VALUES (%s, %s, %s, %s, %s)
"""

# DataFrame의 각 행을 반복하여 데이터베이스에 삽입
for _, row in df.iterrows():
    cursor.execute(insert_query, (
        row['t_sta_info'],
        row['t_sta_spec'],
        row['t_sta_ad'],
        row['t_sta_dat'],
        row['t_sta_age']
    ))

# 변경 사항 커밋
connection.commit()

# 연결 종료
cursor.close()
connection.close()

print("데이터가 SQL 테이블에 성공적으로 저장되었습니다.")
