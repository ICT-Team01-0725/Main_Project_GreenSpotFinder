import json
import requests

def get_lat_lng(address):
    # 카카오맵 REST API 키
    api_key = 'aafe926ca5fa262974b5d0db47695a82'        
    url = f'https://dapi.kakao.com/v2/local/search/address.json?query={address}'
    
    headers = {
        'Authorization': f'KakaoAK {api_key}'
    }
    
    response = requests.get(url, headers=headers)
    # HTTP 상태 확인
    if response.status_code == 200:
        result = response.json()
        if result['documents']:
            latitude = result['documents'][0]['y']
            longitude = result['documents'][0]['x']
            return latitude, longitude
    return None, None

# 기존 JSON 파일 읽기
with open('C:/Users/5/Desktop/map_visualization/보호수/시각화_전국보호수정보.json', 'r', encoding='utf-8') as file:
    tree_data = json.load(file)

# 모든 주소에 대해 위도, 경도 정보 추가
for tree in tree_data:
    address = tree['t_ad']
    latitude, longitude = get_lat_lng(address)
    if latitude and longitude:
        tree['t_lat'] = latitude
        tree['t_lon'] = longitude

# 새로운 JSON 파일로 저장
# ensure_ascii = False : 한글 저장
# indent = 4 : 가독성을 위한 들여쓰기
try:
    with open('C:/Users/5/Desktop/map_visualization/보호수/시각화_전국보호수정보_lat&lon.json', 'w', encoding='utf-8') as file:
        json.dump(tree_data, file, ensure_ascii=False, indent=4)
    print("파일저장을 성공했습니다") 
except Exception as e:
    print(f"파일 저장을 실패했습니다: {e}")  
