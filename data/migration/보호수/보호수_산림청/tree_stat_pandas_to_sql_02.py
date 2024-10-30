import pandas as pd
from sqlalchemy import create_engine

# CSV 파일 경로
csv_file_path = 'C:\\Users\\5\\Desktop\\DATA\\data\\migration\\보호수\\보호수_산림청\\전국보호수현황.csv'

# CSV 파일을 DataFrame으로 읽기
df = pd.read_csv(csv_file_path, encoding='utf-8-sig')

# MySQL 연결 정보 설정
db_user = 'kkyungseo'        # MySQL 사용자 이름
db_password = '1111'          # MySQL 비밀번호
db_host = 'localhost'         # MySQL 호스트 (예: localhost)
db_name = 'tree_db'           # 사용할 데이터베이스 이름
table_name = 'tree_stat_tbl'  # 데이터가 저장될 테이블 이름

# SQLAlchemy 엔진 생성
engine = create_engine(
    'mysql+pymysql://kkyungseo:1111@localhost/tree_db',  # 연결 문자열을 확인
    connect_args={'connect_timeout': 10}
)

# NaN 값을 None으로 변환 (MySQL의 NULL로 매핑)
df = df.where(pd.notnull(df), None)

# DataFrame을 MySQL 테이블에 삽입
try:
    df.to_sql(name=table_name, con=engine, if_exists='append', index=False, method='multi')
    print("데이터가 SQL 테이블에 성공적으로 저장되었습니다.")
except Exception as e:
    print(f"데이터 삽입 중 오류 발생: {e}")
finally:
    # 연결 종료
    engine.dispose()
