import pandas as pd
import re
from datetime import datetime

# Excel 파일에서 특정 시트 선택
excel_file_path = 'C:\\Users\\5\\Desktop\\DATA\\data\\seeders\\보호수\\산림청_2023년말 보호수 지정현황_(홈페이지 게시용).xlsx'
sheet_name = '세부내역'
# header는 tree_stat_sheet_check의 출력값으로 작성
df = pd.read_excel(excel_file_path, sheet_name=sheet_name, header=5)

# 특정 열 선택 
# --> 1.지정정보 중 지정유형,세부지정유형 (지정정보 : "-"로 연결되어 출력)
# --> 2.명칭정보 중 수종명(국명),수종명(학명) (수종명(학명) : "국명(학명)"으로 출력)
# --> 3.위치정보 중 세부주소 (위치)
# --> 4.관리정보 중 지정일 (지정일)
# --> 5.개체정보 중 2023년 기준 수령 (년) (수령 : '현재 연도(year)-수령' 값이 더해지도록 출력) 

# 1
df['지정정보'] = df['지정유형'].str.strip() + ' - ' + df['세부지정유형'].str.strip()

# 2
df['수종명(학명)'] = df['수종명(국명)'].str.strip() + ' (' + df['수종명(학명)'].str.strip() + ')'

# 3
df['위치'] = df['세부 주소'].str.strip()

# 4
def standardize_date(date_str):
    # 날짜에서 불필요한 공백 제거
    date_str = date_str.strip()
    
    # 정규식을 이용해 연, 월, 일 추출
    match = re.match(r"(\d{4})[.](\d{1,2})[.](\d{1,2})(?:[.]?)", date_str)
    if match:
        year, month, day = match.groups()
        # 월, 일이 한 자리수인 경우 앞에 0을 추가하여 두 자리로 만듦
        month = month.zfill(2)
        day = day.zfill(2)
        return f"{year}-{month}-{day}"
    else:
        return None  # 형식이 맞지 않으면 None 반환

# 지정일 컬럼에 함수 적용하여 표준화
df['지정일'] = df['지정일'].astype(str).apply(standardize_date)

# 표준화된 날짜를 datetime 형식으로 변환
df['지정일'] = pd.to_datetime(df['지정일'], errors='coerce')

# 날짜에서 시간 부분 제거 (문자열로 변환)
df['지정일'] = df['지정일'].dt.strftime('%Y-%m-%d')

# 5
current_year = datetime.now().year  # 현재연도 자동 설정
data_year = 2023                    # seeder 자료 기준 연도
year_gap = current_year - data_year

# 수령 값 계산
if '2023년기준수령(년)' in df.columns:
    df['2023년기준수령(년)'] = pd.to_numeric(df['2023년기준수령(년)'], errors='coerce')
    df['수령'] = df['2023년기준수령(년)'].fillna(0) + year_gap  # NaN인 경우 0으로 대체
    df['수령'] = df['수령'].replace(0, '수령불명').astype(str)  # 0을 '수령불명'으로 변경 후 문자열로 변환
else:
    # '2023년기준수령(년)' 열이 없을 경우 기본값 설정
    df['수령'] = '수령불명'  

# 빈값 처리 함수 (수치형)
def fill_na_with_nan(column):
    return column.fillna(pd.NA)  # NaN으로 대체

# 빈값 처리 함수 (문자형)
def fill_na_with_none(column):
    return column.replace('', pd.NA)  # 빈 문자열을 NaN으로 대체

# 필요한 열만 선택
final_columns = ['지정정보', '수종명(학명)', '위치', '지정일', '수령']
df = df[final_columns]

# 각 칼럼의 null 값 처리
for col in final_columns:
    if col in ['수령', '2023년기준수령(년)']:  # 수치형 칼럼에 대해서는 NaN 처리
        df[col] = fill_na_with_nan(df[col])
    else:  # 문자열 칼럼에 대해서는 None 처리
        df[col] = fill_na_with_none(df[col])

# 칼럼명 변경
df.rename(columns={
    '지정정보': 't_sta_info',
    '수종명(학명)': 't_sta_spec',
    '위치': 't_sta_ad',
    '지정일': 't_sta_dat',
    '수령': 't_sta_age'
}, inplace=True)

# CSV 파일로 저장
csv_file_path = 'C:\\Users\\5\\Desktop\\DATA\\data\\migration\\보호수\\보호수_산림청\\전국보호수현황.csv'
df.to_csv(csv_file_path, index=False, encoding='utf-8-sig')

# 저장여부 확인 출력
print(f"{csv_file_path}로 저장되었습니다.")
