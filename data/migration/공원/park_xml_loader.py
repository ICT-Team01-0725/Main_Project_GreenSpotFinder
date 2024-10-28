import pandas as pd
from xml.etree.ElementTree import iterparse

# 필요한 데이터를 담을 빈 리스트 생성
data = []

# 필요한 태그와 컬럼 이름 매칭 (메모리 낭비 방지 & 처리속도 향상)
tag_to_column = {
    '관리번호': 'p_num',
    '공원명': 'p_na',
    '공원구분': 'p_ty',
    '소재지도로명주소': 'p_rad',
    '소재지지번주소': 'p_ad',
    '위도': 'p_lat',
    '경도': 'p_lon',
    '관리기관명': 'p_ce_na',
    '전화번호': 'p_pho',
    '제공기관명': 'p_ce_ad'
}

# iterparse를 이용해 XML 파일 파싱
for event, elem in iterparse('C:\\Users\\5\\Desktop\\DATA\\data\\seeders\\공원\\전국도시공원정보표준데이터.xml', events=('end',)):
    # 필요한 태그를 확인하고 원하는 정보를 추출
    if elem.tag == 'record':
        row = {tag_to_column[tag]: elem.find(tag).text if elem.find(tag) is not None else None for tag in tag_to_column.keys()}
        data.append(row)
        
        # 메모리 절약을 위해 파싱이 끝난 요소 초기화
        elem.clear()  

# 리스트를 DataFrame으로 변환
df = pd.DataFrame(data)

# DataFrame을 CSV로 저장
# utf-8-sig : Excel에서 한글이 깨지지 않게 저장하기 위한 용도
csv_file_path = 'C:\\Users\\5\\Desktop\\DATA\\data\\seeders\\공원\\전국도시공원정보표준데이터.csv'
df.to_csv(csv_file_path, index=False, encoding="utf-8-sig")

# 데이터 저장 완료 메시지 출력
print('데이터 저장에 성공했습니다.', csv_file_path)