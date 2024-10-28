import pandas as pd

# CSV 파일 읽기
csv_file_path = 'C:\\Users\\5\\Desktop\\DATA\\data\\seeders\\공원\\전국도시공원정보표준데이터.csv'
df = pd.read_csv(csv_file_path)

# 데이터 타입 변경
# 문자열의 경우, 길이를 지정하여 데이터 효율성 향상
df['p_num'] = df['p_num'].astype(str)[:50]        # 관리번호 (int)
df['p_na'] = df['p_na'].astype(str)[:500]         # 공원명 (varchar)
df['p_ty'] = df['p_ty'].astype(str)[:500]         # 공원구분 (varchar)
df['p_rad'] = df['p_rad'].astype(str)[:500]       # 소재지도로명주소 (varchar)
df['p_ad'] = df['p_ad'].astype(str)[:500]         # 소재지지번주소 (varchar)
df['p_lat'] = df['p_lat'].astype(float)           # 위도 (double)
df['p_lon'] = df['p_lon'].astype(float)           # 경도 (double)
df['p_ce_na'] = df['p_ce_na'].astype(str)[:50]    # 관리기관명 (varchar)
df['p_pho'] = df['p_pho'].astype(str)[:50]        # 전화번호 (varchar)
df['p_ce_ad'] = df['p_ce_ad'].astype(str)[:50]    # 제공기관명 (varchar)

# 정제된 데이터를 새로운 CSV로 저장
cleaned_csv_path = 'C:\\Users\\5\\Desktop\\DATA\\data\\seeders\\공원\\정제_전국도시공원정보표준데이터.csv'
df.to_csv(cleaned_csv_path, index=False, encoding='utf-8-sig')

print('데이터 정제가 완료되었습니다:', cleaned_csv_path)
