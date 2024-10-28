import pandas as pd
from sqlalchemy import create_engine

# CSV 파일 읽기
cleaned_csv_path = 'C:\\Users\\5\\Desktop\\DATA\\data\\seeders\\공원\\정제_전국도시공원정보표준데이터.csv'
df = pd.read_csv(cleaned_csv_path)

# SQLAlchemy를 통해 MySQL 데이터베이스 연결
user = 'kkyungseo'
password = '1111'
host = 'localhost'
database = 'park_db'

# PyMySQL 드라이버를 사용하여 연결 문자열 생성
connection_string = f'mysql+pymysql://{user}:{password}@{host}/{database}'
engine = create_engine(connection_string)

# 데이터프레임을 MySQL에 저장
try:
    df.to_sql('park_tbl', con=engine, if_exists='append', index=False)
    print('데이터 저장에 성공했습니다.')
except Exception as e:
    print('데이터 저장 중 오류 발생!', e)
