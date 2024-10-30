import pandas as pd
import pymysql

# CSV 파일 경로
csv_file_path = 'C:\\Users\\5\\Desktop\\DATA\\data\\migration\\보호수\\보호수_산림청\\전국보호수현황.csv'

# MySQL 데이터베이스 연결 설정
db_config = {
    'host': 'localhost',         # 데이터베이스 호스트
    'user': 'kkyungseo',        # 데이터베이스 사용자
    'password': '1111',         # 데이터베이스 비밀번호
    'database': 'tree_db'       # 사용할 데이터베이스 이름
}

# CSV 파일 읽기
df = pd.read_csv(csv_file_path, encoding='utf-8-sig')

# MySQL 데이터베이스에 연결
conn = pymysql.connect(**db_config)
cursor = conn.cursor()

# 데이터 삽입 쿼리 준비
insert_query = """
INSERT INTO tree_stat_tbl (t_sta_info, t_sta_spec, t_sta_ad, t_sta_dat, t_sta_age)
VALUES (%s, %s, %s, %s, %s)
"""

# 데이터 삽입
for index, row in df.iterrows():
    try:
        cursor.execute(insert_query, (
            row['t_sta_info'],
            row['t_sta_spec'],
            row['t_sta_ad'],
            row['t_sta_dat'],
            row['t_sta_age']
        ))

        # 1000개마다 커밋
        if index % 1000 == 0 and index != 0:  # 첫 번째 1000개가 아닌 경우에만 커밋
            conn.commit()

    except Exception as e:
        print(f"Error inserting row {index}: {e}")

# 마지막으로 남아 있는 데이터 커밋
conn.commit()

# 연결 종료
cursor.close()
conn.close()

print("데이터가 MySQL 테이블에 성공적으로 삽입되었습니다.")
