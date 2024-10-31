import pandas as pd
from sqlalchemy import create_engine

# 데이터베이스 연결
engine = create_engine('mysql+pymysql://kkyungseo:1111@localhost/park_db')

# 테이블 데이터를 DataFrame으로 읽어오기
df = pd.read_sql_table('park_tbl', con=engine)

# DataFrame 내용을 SQL 파일로 저장 (UTF-8 인코딩)
with open('C:\\Users\\5\\Desktop\\DATA\\data\\migration\\공원\\전국도시공원정보표준데이터.sql', 'w', encoding='utf-8') as f:
    for index, row in df.iterrows():
        safe_values = []
        for col, value in zip(df.columns, row.values):
            # p_lat, p_lon은 float으로 처리, 나머지는 문자열로 변환 후 오류 발생 시 필터링
            if col in ['p_lat', 'p_lon']:
                safe_values.append(str(value) if pd.notnull(value) else 'NULL')  # 소수점 값 유지
            else:
                safe_values.append(repr(str(value).encode('utf-8', errors='replace').decode('utf-8')))  # 문자열 안전 변환
        
        sql = f"INSERT INTO park_tbl ({', '.join(df.columns)}) VALUES ({', '.join(safe_values)});\n"
        f.write(sql)

print("SQL 파일로 저장되었습니다.")
