import json
import re

# SQL 파일 경로
sql_file_path = 'C:/Users/5/Desktop/map_visualization/가로수길/전국가로수길정보표준데이터.sql'
json_file_path = 'C:/Users/5/Desktop/map_visualization/가로수길/시각화_전국가로수길정보표준데이터.json'

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
        match = re.search(r'VALUES \((.*?)\)', line)
        if match:
            values = match.group(1).split(', ')
            # 필요한 열 추출 (위도 및 경도)
            if len(values) >= 6:  # 필요한 값이 있는지 확인
                r_s_lat = values[2].strip("'")  # 시작 위도
                r_s_lon = values[3].strip("'")  # 시작 경도
                r_e_lat = values[4].strip("'")  # 종료 위도
                r_e_lon = values[5].strip("'")  # 종료 경도

                # 데이터 추가
                data.append({
                    "r_s_lat": r_s_lat,
                    "r_s_lon": r_s_lon,
                    "r_e_lat": r_e_lat,
                    "r_e_lon": r_e_lon
                })
            else:
                print(f"값이 부족한 행: {line.strip()}")

# JSON 파일로 저장
with open(json_file_path, 'w', encoding='utf-8') as json_file:
    json.dump(data, json_file, ensure_ascii=False, indent=2)

print(f"{json_file_path}에 JSON 파일이 저장되었습니다.")
