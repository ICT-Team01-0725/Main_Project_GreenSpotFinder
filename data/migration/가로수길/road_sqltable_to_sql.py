import pandas as pd
from sqlalchemy import create_engine

# 데이터베이스 연결
engine = create_engine('mysql+pymysql://kkyungseo:1111@localhost/road_db')

# 테이블 데이터를 DataFrame으로 읽어오기
df = pd.read_sql_table('road_tbl', con=engine)

# DataFrame 내용을 SQL 파일로 저장 (UTF-8 인코딩)
with open('C:\\Users\\5\\Desktop\\DATA\\data\\seeders\\가로수길\\전국가로수길정보표준데이터.sql', 'w', encoding='utf-8') as f:
    for index, row in df.iterrows():
        # 값을 문자열로 변환하고, 오류 발생 시 필터링
        safe_values = [str(value).encode('utf-8', errors='replace').decode('utf-8') for value in row.values]
        sql = f"INSERT INTO road_tbl ({', '.join(df.columns)}) VALUES ({', '.join([repr(value) for value in safe_values])});\n"
        f.write(sql)

print("SQL 파일로 저장되었습니다.")
