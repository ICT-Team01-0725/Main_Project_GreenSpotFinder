import pandas as pd
import json

# CSV 파일에서 데이터 읽어오기 (모든 칼럼을 로드)
df = pd.read_csv('C:/Users/5/Desktop/map_visualization/가로수길/전국가로수길정보표준데이터.csv')

# 칼럼 이름 확인
print("CSV 파일의 칼럼 이름:", df.columns.tolist())