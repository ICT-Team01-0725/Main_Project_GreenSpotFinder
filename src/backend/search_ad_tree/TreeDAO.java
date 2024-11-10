package com.ict.edu.treedao;

import java.util.List;
import com.ict.edu.treevo.TreeVO;

public interface TreeDAO {

    /**
     * 보호수를 주소(t_ad)와 도로명 주소(t_rad)로 검색합니다.
     * 두 파라미터가 모두 주어지면 필터로 사용됩니다.
     * 
     * @param t_ad  보호수 주소 (null 가능)
     * @param t_rad 도로명 주소 (null 가능)
     * @return 검색된 TreeVO 객체의 리스트
     */
    List<TreeVO> searchTrees(String t_ad, String t_rad);

    /**
     * 보호수 목록을 가나다순으로 4개 조회합니다.
     * 
     * @return 보호수 목록 (TreeVO 객체 리스트)
     */
    List<TreeVO> getTop4Trees();
}
