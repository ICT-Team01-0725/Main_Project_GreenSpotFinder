import pandas as pd
import re
from datetime import datetime

# Excel 파일에서 특정 시트 선택
excel_file_path = 'C:\\Users\\5\\Desktop\\DATA\\data\\seeders\\보호수\\산림청_2023년말 보호수 지정현황_(홈페이지 게시용).xlsx'
sheet_name = '세부내역'
# header는 tree_stat_sheet_check의 출력값으로 작성
df = pd.read_excel(excel_file_path, sheet_name=sheet_name, header=5)

# 모든 데이터를 문자열로 변환하고 빈값을 " - "로 처리
df = df.astype(str).replace({'nan': ' - ', '': ' - '})

# 특정 열 선택 
# --> 1.지정정보 중 지정유형,세부지정유형 (지정정보 : "-"로 연결되어 출력)
# --> 2.명칭정보 중 수종명(국명),수종명(학명) (수종명(학명) : "국명(학명)"으로 출력)
# --> 3.위치정보 중 세부주소 (위치)
# --> 4.관리정보 중 지정일 (지정일)
# --> 5.개체정보 중 2023년 기준 수령 (년) (수령 : '현재 연도(year)-수령' 값이 더해지도록 출력) 

# 1. 지정정보 생성
df['지정정보'] = df['지정유형'].str.strip() + ' - ' + df['세부지정유형'].str.strip()

# 2. 수종명(학명) 생성
df['수종명(학명)'] = df['수종명(국명)'].str.strip() + ' (' + df['수종명(학명)'].str.strip() + ')'

# 3. 위치
df['위치'] = df['세부 주소'].str.strip()

# 4. 지정일 표준화
def standardize_date(date_str):
    date_str = date_str.strip()
    match = re.match(r"(\d{4})[.](\d{1,2})[.](\d{1,2})(?:[.]?)", date_str)
    if match:
        year, month, day = match.groups()
        return f"{year}-{month.zfill(2)}-{day.zfill(2)}"
    return " - "  # 형식이 맞지 않으면 " - " 반환

df['지정일'] = df['지정일'].apply(standardize_date)

# 5. 수령 계산
current_year = datetime.now().year
year_gap = current_year - 2023
if '2023년기준수령(년)' in df.columns:
    df['2023년기준수령(년)'] = pd.to_numeric(df['2023년기준수령(년)'], errors='coerce').fillna(0)
    df['수령'] = (df['2023년기준수령(년)'] + year_gap).astype(str).replace('0.0', '수령불명')
else:
    df['수령'] = '수령불명'

# 6. 필요한 열 선택
final_columns = ['지정정보', '수종명(학명)', '위치', '지정일', '수령']
df = df[final_columns]

# 7. 칼럼명 변경
df.rename(columns={
    '지정정보': 't_sta_info',
    '수종명(학명)': 't_sta_spec',
    '위치': 't_sta_ad',
    '지정일': 't_sta_dat',
    '수령': 't_sta_age'
}, inplace=True)

# 8. CSV 파일로 저장
csv_file_path = 'C:\\Users\\5\\Desktop\\DATA\\data\\migration\\보호수\\보호수_산림청\\전국보호수현황.csv'
df.to_csv(csv_file_path, index=False, encoding='utf-8-sig')
print(f"{csv_file_path}로 저장되었습니다.")
