import pandas as pd
from sqlalchemy import create_engine

# 병합된 CSV 파일 경로
combined_csv_path = 'C:\\Users\\5\\Desktop\\DATA\\data\\migration\\보호수\\보호수_공공데이터포털\\전국보호수정보.csv'

# CSV 파일 읽기
try:
    df = pd.read_csv(combined_csv_path, encoding='utf-8-sig')
except Exception as e:
    print("CSV 파일을 읽는 중 오류가 발생했습니다.", e)
else:
    # SQLAlchemy를 통해 MySQL 데이터베이스 연결 설정
    user = 'kkyungseo'
    password = '1111'
    host = 'localhost'
    database = 'tree_db'
    
    # PyMySQL 드라이버를 사용하여 연결 문자열 생성
    connection_string = f'mysql+pymysql://{user}:{password}@{host}/{database}'
    engine = create_engine(connection_string)
    
    # 데이터프레임을 MySQL에 저장
    try:
        df.to_sql('tree_area_tbl', con=engine, if_exists='append', index=False)
        print('데이터 저장에 성공했습니다.')
    except Exception as e:
        print('데이터 저장 중 오류 발생!', e)
