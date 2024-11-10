package com.ict.edu.treeservice;

import java.util.List;
import com.ict.edu.treevo.TreeVO;

public interface TreeService {
	
    /**
     * 첫 화면에 보호수 리스트를 4개 가져옵니다 (가나다 순).
     * @return 보호수 4개 목록
     */
    List<TreeVO> getTop4Trees();

    /**
     * 주소와 반경을 기준으로 보호수를 검색합니다.
     * t_ad와 t_rad 둘 중 하나라도 입력되면 해당 조건에 맞는 결과를 반환합니다.
     * @param t_ad 보호수 주소 
     * @param t_rad 도로명 주소 
     * @return 검색된 보호수 목록
     */
    List<TreeVO> searchTrees(String t_ad, String t_rad);
}
