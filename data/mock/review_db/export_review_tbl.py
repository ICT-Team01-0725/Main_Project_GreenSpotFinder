import pymysql

# MySQL 연결 설정
db_config = {
    'user': 'kkyungseo',
    'password': '1111',
    'host': 'localhost',
    'database': 'review_db'
}

# MySQL 연결
connection = pymysql.connect(
    user=db_config['user'],
    password=db_config['password'],
    host=db_config['host'],
    database=db_config['database']
)

# 데이터를 가져오기 위한 쿼리
select_query = "SELECT * FROM review_tbl"

try:
    with connection.cursor() as cursor:
        cursor.execute(select_query)
        rows = cursor.fetchall()

        # INSERT INTO 문 생성
        insert_statements = []
        for row in rows:
            insert_query = f"INSERT INTO review_tbl (rev_tle, rev_con,rev_hit, u_idx, rev_dat, rev_up, rev_pic) VALUES ({', '.join(['%s' for _ in row])});"  
            insert_statements.append(cursor.mogrify(insert_query, row))
            
        # SQL 파일을 저장할 경로 설정
        file_path = r"C:\Users\5\Desktop\FIRST\mock\review_db\insert_data_review.sql"
        
        # 파일로 저장
        with open(file_path, "w", encoding="utf-8") as f:
            f.write("\n".join(insert_statements))
            print(f"{file_path} 파일이 생성되었습니다.")

finally:
    connection.close()  # 연결 종료