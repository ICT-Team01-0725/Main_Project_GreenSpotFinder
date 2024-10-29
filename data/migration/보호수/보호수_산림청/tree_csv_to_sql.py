import pandas as pd
from sqlalchemy import create_engine, Column, String, Integer
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import sessionmaker

# 데이터베이스에 저장
Base = declarative_base()

class TreeStatTbl(Base):
    __tablename__ = 'tree_stat_tbl'
    
    t_stat_idx = Column(Integer, primary_key=True, autoincrement=True)
    t_sta_info = Column(String(255), nullable=False)       # 지정 정보
    t_sta_spec = Column(String(255), nullable=False)       # 수종명(학명)
    t_sta_ad = Column(String(255), nullable=False)         # 위치
    t_sta_dat = Column(String(10), nullable=False)         # 지정일, String 타입으로 변경
    t_sta_age = Column(String(50), nullable=False)         # 수령, 문자 타입으로 설정 ('수령불명' 포함 가능)

# 데이터베이스 연결 설정
engine = create_engine('mysql+pymysql://kkyungseo:1111@localhost/tree_db')
Base.metadata.create_all(engine)

# 세션 생성
Session = sessionmaker(bind=engine)
session = Session()

# CSV 파일을 DataFrame으로 읽기
csv_file_path = 'C:\\Users\\5\\Desktop\\DATA\\data\\migration\\보호수\\보호수_산림청\\전국보호수현황.csv'
df = pd.read_csv(csv_file_path)

# CSV의 열 이름이 클래스 속성과 일치한다고 가정
for index, row in df.iterrows():
    tree_stat = TreeStatTbl(
        t_sta_info=row['t_sta_info'],  
        t_sta_spec=row['t_sta_spec'], 
        t_sta_ad=row['t_sta_ad'],  
        t_sta_dat=row['t_sta_dat'] if pd.notnull(row['t_sta_dat']) else " - ",  
        t_sta_age=row['t_sta_age']  
    )
    session.add(tree_stat)

session.commit()
session.close()

# 저장 여부 확인 출력
print(f"{csv_file_path}의 데이터가 데이터베이스에 저장되었습니다.")
