import pymysql

# MySQL 연결 설정
db_config = {
    'user': 'kkyungseo',
    'password': '1111',
    'host': 'localhost',
    'database': 'comment_db'
}

# MySQL 연결
connection = pymysql.connect(
    user=db_config['user'],
    password=db_config['password'],
    host=db_config['host'],
    database=db_config['database']
)

# 데이터를 가져오기 위한 쿼리
select_query = "SELECT * FROM comment_tbl"

try:
    with connection.cursor() as cursor:
        cursor.execute(select_query)
        rows = cursor.fetchall()

        # INSERT INTO 문 생성
        insert_statements = []
        for row in rows:
            insert_query = f"INSERT INTO comment_tbl (u_idx, c_con, c_dat, c_up, c_out, c_bor, c_ref) VALUES ({', '.join(['%s' for _ in row])});"  
            insert_statements.append(cursor.mogrify(insert_query, row))
            
        # SQL 파일을 저장할 경로 설정
        file_path = r"C:\Users\5\Desktop\FIRST\mock\comment_db\insert_data_comment.sql"
        
        # 파일로 저장
        with open(file_path, "w", encoding="utf-8") as f:
            f.write("\n".join(insert_statements))
            print(f"{file_path} 파일이 생성되었습니다.")

finally:
    connection.close()  # 연결 종료
