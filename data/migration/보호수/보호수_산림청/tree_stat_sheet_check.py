import pandas as pd

# Excel 파일에서 특정 시트 읽기
excel_file_path = 'C:\\Users\\5\\Desktop\\DATA\\data\\seeders\\보호수\\산림청_2023년말 보호수 지정현황_(홈페이지 게시용).xlsx'
sheet_name = '세부내역'

# 시트를 읽어오는 범위 선택

# MS Excel 기준에서는 6행으로 보이지만
# 실질적인 데이터에서는 5행이 header로 읽히므로 아래 코드로 확인이 필요함
df = pd.read_excel(excel_file_path, sheet_name=sheet_name, header=5)

# 열 이름 확인 (header 적합여부 판정하기)
print(df.columns)
