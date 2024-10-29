import pandas as pd
import os
import chardet
import numpy as np

# CSV 파일들이 저장된 디렉토리 경로
csv_directory = 'C:\\Users\\5\\Desktop\\DATA\\data\\migration\\보호수\\xlsx_to_csv' 

# 변경할 칼럼명 매핑
column_mapping = {
    '관리기관명': 't_ce_na',
    '지정번호': 't_num',
    '보호수지정일자': 't_sdate',
    '보호수유형명': 't_ty',
    '과명': 't_fna',
    '학명': 't_bna',
    '나무종류': 't_tty',
    '나무나이': 't_age',
    '품격명': 't_fr',
    '지목명': 't_gr',
    '지적': 't_gr_num',
    '소재지도로명주소': 't_rad',
    '소재지지번주소': 't_ad',
}

# 변경할 칼럼명에 해당하는 값들을 리스트로 지정
selected_columns = list(column_mapping.keys())

# 변경된 데이터프레임을 저장할 리스트
dataframes = []

# CSV 파일 읽기 및 칼럼명 변경
for file in os.listdir(csv_directory):
    if file.endswith('.csv'):
        file_path = os.path.join(csv_directory, file)
        
        try:
            # 파일의 인코딩 감지
            with open(file_path, 'rb') as f:
                result = chardet.detect(f.read())
                encoding = result['encoding']
                print(f"Detected encoding for {file}: {encoding}")
            
            # 감지된 인코딩으로 CSV 파일 읽기
            df = pd.read_csv(file_path, encoding=encoding)  
            
            # 선택된 칼럼만 가져오기 ( + 칼럼이 존재하는지 확인 )
            if set(selected_columns).issubset(df.columns): 
                selected_df = df[selected_columns]
                # 칼럼명 변경
                selected_df.rename(columns=column_mapping, inplace=True)
                
                # 데이터 형식 변환 (MySQL 테이블 형식에 맞추기)
                selected_df['t_ce_na'] = selected_df['t_ce_na'].astype(str)       # 관리기관명 - VARCHAR
                selected_df['t_num'] = pd.to_numeric(selected_df['t_num'], errors='coerce').fillna(0).astype(int)  # 지정번호 - INT
                selected_df['t_sdate'] = selected_df['t_sdate'].astype(str)       # 보호수 지정일자 - VARCHAR
                selected_df['t_ty'] = selected_df['t_ty'].astype(str)             # 보호수 유형명 - VARCHAR
                selected_df['t_fna'] = selected_df['t_fna'].astype(str)           # 과명 - VARCHAR
                selected_df['t_bna'] = selected_df['t_bna'].astype(str)           # 학명 - VARCHAR
                selected_df['t_tty'] = selected_df['t_tty'].astype(str)           # 나무종류 - VARCHAR
                selected_df['t_age'] = pd.to_numeric(selected_df['t_age'], errors='coerce').fillna(0).astype(int)   # 나무 나이 - INT
                selected_df['t_fr'] = selected_df['t_fr'].astype(str)             # 품격명 - VARCHAR
                selected_df['t_gr'] = selected_df['t_gr'].astype(str)             # 지목명 - VARCHAR
                selected_df['t_gr_num'] = selected_df['t_gr_num'].astype(str)     # 지적 - VARCHAR
                selected_df['t_rad'] = selected_df['t_rad'].astype(str)           # 소재지 도로명 주소 - VARCHAR
                selected_df['t_ad'] = selected_df['t_ad'].astype(str)             # 소재지 지번 주소 - VARCHAR
                
                # NaN을 빈 문자열로 대체
                selected_df['t_fna'].replace({pd.NA: '', np.nan: ''}, inplace=True)
                selected_df['t_bna'].replace({pd.NA: '', np.nan: ''}, inplace=True)
                selected_df['t_gr_num'].replace({pd.NA: '', np.nan: ''}, inplace=True)
                selected_df['t_rad'].replace({pd.NA: '', np.nan: ''}, inplace=True)
                selected_df['t_ad'].replace({pd.NA: '', np.nan: ''}, inplace=True)

                # 변경된 데이터프레임 리스트에 추가
                dataframes.append(selected_df)
            else:
                missing_columns = set(selected_columns) - set(df.columns)
                print(f"Warning: Missing columns in {file}: {missing_columns}")
        except Exception as e:
            print(f"Error reading {file}: {e}")

# 데이터프레임이 비어있는지 확인
if dataframes:
    # 모든 데이터프레임을 하나로 합치기
    combined_df = pd.concat(dataframes, ignore_index=True)
    # 통합된 데이터프레임 저장
    combined_df.to_csv('C:\\Users\\5\\Desktop\\DATA\\data\\migration\\보호수\\보호수_공공데이터포털\\전국보호수정보.csv', index=False, encoding='utf-8-sig')
    # 성공 메시지 출력
    print("파일 병합을 성공했습니다.")  
else:
    # 에러 메시지 출력
    print("병합할 유효한 데이터프레임이 없습니다.")
