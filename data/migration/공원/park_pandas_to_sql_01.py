import pandas as pd
import mysql.connector
from mysql.connector import Error

# MySQL 연결 정보 설정
connection_config = {
    'host': 'localhost',        
    'database': 'park_db', 
    'user': 'root',    
    'password': '1111'  
}

# CSV 파일에서 정제된 데이터 읽기
cleaned_csv_path = 'C:\\Users\\5\\Desktop\\DATA\\data\\seeders\\공원\\정제_전국도시공원정보표준데이터.csv'
df = pd.read_csv(cleaned_csv_path)

# 연결 변수를 초기화
connection = None  

try:
    # MySQL 데이터베이스에 연결
    connection = mysql.connector.connect(**connection_config)

    if connection.is_connected():
        cursor = connection.cursor()

        # 데이터프레임을 MySQL에 저장
        for _, row in df.iterrows():
            insert_query = """
            INSERT INTO park_tbl (p_num, p_na, p_ty, p_rad, p_ad, p_lat, p_lon, p_ce_na, p_pho, p_ce_ad)
            VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
            """
            print(insert_query, tuple(row))  # 실행할 쿼리 출력
            cursor.execute(insert_query, tuple(row))

        # 변경 사항을 커밋
        connection.commit()  
        print('데이터 저장에 성공했습니다.')

except Error as e:
    print('MySQL 오류 발생 !', e)

finally:
    # 연결이 초기화되었는지 확인
    if connection and connection.is_connected():  
        cursor.close()
        connection.close()
        print('MySQL 연결이 종료되었습니다.')
