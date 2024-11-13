import pymysql

# MySQL 연결 설정
db_config = {
    'user': 'kkyungseo',
    'password': '1111',
    'host': 'localhost',
    'database': 'notice_db'
}

# 내보낼 파일 경로 설정
file_path = r"C:\Users\5\Desktop\mock\notice_db\insert_notice_data.sql"

# MySQL 연결
try:
    connection = pymysql.connect(
        user=db_config['user'],
        password=db_config['password'],
        host=db_config['host'],
        database=db_config['database']
    )

    # 데이터를 가져오기 위한 쿼리
    select_query = "SELECT * FROM notice_tbl"
    
    with connection.cursor() as cursor:
        cursor.execute(select_query)
        rows = cursor.fetchall()

        # 테이블의 컬럼명을 가져오기
        cursor.execute("SHOW COLUMNS FROM notice_tbl")
        columns = [column[0] for column in cursor.fetchall()]

        # INSERT INTO 문 생성
        insert_statements = []
        for row in rows:
            # 'notice_tbl'에서 n_idx는 AUTO_INCREMENT이므로 제외하고 나머지 컬럼에 대해서만 INSERT INTO 생성
            row_data = row[1:]  # 첫 번째 컬럼 (u_idx) 제외
            insert_query = f"INSERT INTO user_tbl ({', '.join(columns[1:])}) VALUES ({', '.join(['%s' for _ in row_data])});"
            
            # mogrify를 사용할 수 없어서 아래 방식으로 쿼리 생성
            formatted_query = insert_query % tuple(map(lambda x: f"'{x}'" if isinstance(x, str) else x, row_data))
            
            # SQL 파일에 저장할 쿼리문
            insert_statements.append(formatted_query)
        
        # SQL 파일로 저장
        with open(file_path, "w", encoding="utf-8") as f:
            f.write("\n".join(insert_statements))
            print(f"{file_path} 파일이 생성되었습니다.")

except pymysql.MySQLError as e:
    print(f"데이터베이스 오류 발생: {e}")

finally:
    if connection:
        connection.close()
        print("MySQL 연결이 종료되었습니다.")
