import json
import re

# SQL 파일 경로
sql_file_path = 'C:/Users/5/Desktop/map_visualization/공원/전국도시공원정보표준데이터.sql'
json_file_path = 'C:/Users/5/Desktop/map_visualization/공원/시각화_전국도시공원정보표준데이터.json'

# 결과를 저장할 리스트
data = []

# SQL 파일 읽기
with open(sql_file_path, 'r', encoding='utf-8') as file:
    lines = file.readlines()
    for line in lines:
        # 빈 줄 또는 주석 무시
        if not line.strip() or line.strip().startswith('--'):
            continue
        
        # INSERT 문에서 값 부분만 추출
        match = re.search(r'VALUES\s*\((.*?)\);', line)
        if match:
            values = match.group(1).split(", ")
            
            # 필요한 열 추출 (위도 및 경도와 공원 이름, 공원주소)
            try:
                p_na = values[2].strip("'")  # 공원 이름
                p_lat = float(values[6]) if values[6] != 'None' else None  # 위도, float으로 변환
                p_lon = float(values[7]) if values[7] != 'None' else None  # 경도, float으로 변환
                p_ad = values[5].strip("'")  # 공원주소

                # 데이터 추가
                data.append({
                    "p_na": p_na,        
                    "p_lat": p_lat,
                    "p_lon": p_lon,
                    "p_ad": p_ad
                })
            except (ValueError, IndexError) as e:
                print(f"값이 부족하거나 변환에 실패한 행: {line.strip()} - {e}")

# JSON 파일로 저장
with open(json_file_path, 'w', encoding='utf-8') as json_file:
    json.dump(data, json_file, ensure_ascii=False, indent=2)

print(f"{json_file_path}에 JSON 파일이 저장되었습니다.")
