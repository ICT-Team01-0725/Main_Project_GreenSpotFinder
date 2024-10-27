import pandas as pd
from sqlalchemy import create_engine
import ast

# CSV 파일 읽기
df = pd.read_csv('C:\\Users\\5\\Desktop\\DATA\\data\\seeders\\가로수길\\전국가로수길정보표준데이터.csv')

"""
이용하고 있는 데이터는 
JSON을 CSV로 변환한 것으로
기존 JSON의 칼럼명은 두 개였기 때문에 (fields, records)
각각이 리스트와 프레임을 생성할 수 있도록 하는 작업이 필요합니다
"""

# 첫 번째 줄의 'fields' 칼럼에서 필드 정보를 가져와서 리스트로 변환
fields = ast.literal_eval(df['fields'][0])

# 필드 이름 리스트 생성
column_names = [field['id'] for field in fields]

# 두 번째 줄의 'records' 칼럼에서 데이터를 가져와서 DataFrame 생성
records = ast.literal_eval(df['records'][0])

# DataFrame 생성
data = pd.DataFrame(records)

# 칼럼 이름 변경 (한글에서 영어로)
new_columns = [
    'r_na',         # 가로수길명
    'r_s_lat',      # 가로수길시작위도
    'r_s_lon',      # 가로수길시작경도
    'r_e_lat',      # 가로수길종료위도
    'r_e_lon',      # 가로수길종류
    'r_ty',         # 가로수수량
    'r_vol',        # 가로수길길이
    'r_len',        # 가로수길소개
    'r_ye',         # 식재연도 (사용하지 않을 칼럼)
    'r_sto',        # 가로수길소개
    'r_rna',        # 도로명
    'r_rty',        # 도로종류
    'r_rsec',       # 도로구간
    'r_pho',        # 관리기관전화번호
    'r_ce_na',      # 관리기관명
    'r_dat',        # 데이터기준일자
    'r_ce_co',      # 제공기관코드
    'r_ce_ad'       # 제공기관명
]

# 칼럼 수가 맞는지 확인하고 변경
if len(data.columns) == len(new_columns):
    data.columns = new_columns
else:
    print(f"오류: CSV 파일 칼럼 수 {len(data.columns)}와 새 칼럼 수 {len(new_columns)}가 일치하지 않습니다.")

# 사용하지 않을 칼럼 삭제 (식재연도)
data.drop(columns=['r_ye'], inplace=True)  

# 데이터베이스 연결
engine = create_engine('mysql+pymysql://kkyungseo:1111@localhost/road_db')

# DataFrame을 SQL 테이블로 업로드
data.to_sql('road_tbl', con=engine, if_exists='replace', index=False, chunksize=1000)

# 결과 확인
print("데이터베이스에 성공적으로 업로드되었습니다.")
