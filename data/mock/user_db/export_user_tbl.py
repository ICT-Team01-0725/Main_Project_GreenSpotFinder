import pymysql

# MySQL 연결 설정
db_config = {
    'user': 'kkyungseo',
    'password': '1111',
    'host': 'localhost',
    'database': 'user_db'
}

# MySQL 연결
connection = pymysql.connect(
    user=db_config['user'],
    password=db_config['password'],
    host=db_config['host'],
    database=db_config['database']
)

# 데이터를 가져오기 위한 쿼리
select_query = "SELECT * FROM user_tbl"

try:
    with connection.cursor() as cursor:
        cursor.execute(select_query)
        rows = cursor.fetchall()

        # INSERT INTO 문 생성
        insert_statements = []
        for row in rows:
            insert_query = f"INSERT INTO user_tbl (u_id, u_pw, u_na, u_pho, u_gen, u_reg, u_out, a_idx, u_outr) VALUES ({', '.join(['%s' for _ in row[1:]])});"
            insert_statements.append(cursor.mogrify(insert_query, row[1:]))  # 첫 번째 컬럼 (u_idx)은 제외하고 나머지 값들을 삽입
        
        # 저장할 경로를 지정 (raw string)
        file_path = r"C:\Users\5\Desktop\mock\user_db\insert_user_data.sql"
        
        # 파일로 저장
        with open(file_path, "w", encoding="utf-8") as f:
            f.write("\n".join(insert_statements))  # 바이트 데이터를 디코딩하지 않고 바로 저장
            print(f"{file_path} 파일이 생성되었습니다.")

finally:
    connection.close()  # 연결 종료
