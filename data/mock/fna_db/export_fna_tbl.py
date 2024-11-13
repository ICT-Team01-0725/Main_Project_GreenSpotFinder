import pymysql

# MySQL 연결 설정
db_config = {
    'user': 'kkyungseo',
    'password': '1111',
    'host': 'localhost',
    'database': 'fna_db'  
}

# MySQL 연결
connection = pymysql.connect(
    user=db_config['user'],
    password=db_config['password'],
    host=db_config['host'],
    database=db_config['database']
)

# 데이터를 가져오기 위한 SELECT 쿼리
select_query = "SELECT * FROM fna_tbl"

try:
    with connection.cursor() as cursor:
        # fna_tbl의 모든 데이터를 조회
        cursor.execute(select_query)
        rows = cursor.fetchall()

        # INSERT INTO 문을 생성하는 리스트
        insert_statements = []
        for row in rows:
            insert_query = "INSERT INTO admin_tbl (a_id, a_pw, a_na, a_pho, a_em, a_stat, a_log) VALUES (%s, %s, %s, %s, %s, %s, %s);"
            # mogrify에서 반환된 값을 바로 리스트에 추가 (decode() 제거)
            insert_statements.append(cursor.mogrify(insert_query, row))

        # SQL 파일을 저장할 경로 설정
        file_path = r"C:\Users\5\Desktop\mock\fna_db\insert_data.sql"
        
        # 파일로 쿼리 저장
        with open(file_path, "w", encoding="utf-8") as file:
            file.write("\n".join(insert_statements))
            print(f"{file_path} 파일로 저장되었습니다.")

finally:
    connection.close()  # 연결 종료
