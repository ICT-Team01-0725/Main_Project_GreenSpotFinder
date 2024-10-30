import csv
import json

# CSV 파일 경로
csv_file_path = 'C:/Users/5/Desktop/map_visualization/보호수/전국보호수정보.csv'
json_file_path = 'C:/Users/5/Desktop/map_visualization/보호수/시각화_전국보호수정보.json'

# 결과를 저장할 리스트
data = []

# CSV 파일 읽기
with open(csv_file_path, 'r', encoding='utf-8') as file:
    reader = csv.DictReader(file)  # CSV 파일을 딕셔너리 형태로 읽기
    for row in reader:
        # 빈 값 처리 및 필요한 컬럼 추출
        t_tty = row.get('t_tty', '').strip()  # 나무 종류
        t_age = row.get('t_age', '').strip()  # 나무 나이
        t_ad = row.get('t_ad', '').strip()    # 나무 주소
        
        # 빈 값이 아닌 경우에만 데이터 추가
        if t_tty and t_age.isdigit() and t_ad:  # t_age가 숫자인지 확인
            data.append({
                "t_tty": t_tty,  # 나무 종류
                "t_age": int(t_age),  # 나무 나이 (정수로 변환)
                "t_ad": t_ad  # 나무 주소
            })
        else:
            print(f"빈 값 또는 잘못된 값이 있는 행: {row}")

# JSON 파일로 저장
with open(json_file_path, 'w', encoding='utf-8') as json_file:
    json.dump(data, json_file, ensure_ascii=False, indent=2)

print(f"{json_file_path}에 JSON 파일이 저장되었습니다.")
