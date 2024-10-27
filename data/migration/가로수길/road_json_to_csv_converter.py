"""
Pandas를 이용한 JSON ~ CSV 변환
: Pandas를 이용하여 MySQL에 연동하여 사용하기 위한 데이터 전처리
"""
import pandas as pd
import json

# JSON 파일의 로컬 경로
json_file_path = r"C:\Users\5\Desktop\DATA\data\seeders\가로수길\전국가로수길정보표준데이터.json"
# JSON이 변환되는 CSV 파일 경로
csv_file_path = r"C:\Users\5\Desktop\DATA\data\seeders\가로수길\전국가로수길정보표준데이터.csv"

# JSON 파일 로드
with open(json_file_path, "r", encoding="utf-8") as file:
    data = json.load(file)
    
# 해당 데이터는 리스트형으로 구성된 JSON의 경우로
# 리스트 각각의 요소가 DataFrame의 행이 되는 구조로 보이도록 함
df = pd.json_normalize(data)
    
# CSV로 저장
# utf-8-sig : Excel에서 한글이 깨지지 않게 저장하기 위한 용도
df.to_csv(csv_file_path, index=False, encoding="utf-8-sig")  

"""
Python Terminal에서 실행후, CSV를 저장하려고 했던 경로에 파일이 저장되어 있다면 변환이 완료된 것입니다.
만약, MS Excel에서 열리지 않는다면, VS code에서 열어서 확인해보세요.
"""