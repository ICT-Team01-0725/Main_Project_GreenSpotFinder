package com.ict.edu.treecontroller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.ict.edu.treeservice.TreeService;
import com.ict.edu.treevo.TreeVO;

@Controller
@RequestMapping("/tree")
public class TreeController {

    @Autowired
    private TreeService treeService;

    // 첫 화면에 보호수 4개의 리스트를 가져오기
    @GetMapping("/main")
    public String showTreeList(HttpServletRequest request) {
        // 가나다순으로 보호수 4개 가져오기
        List<TreeVO> top4Trees = treeService.getTop4Trees();

        // request 객체에 treeList를 담아 JSP로 전달
        request.setAttribute("treeList", top4Trees);

        return "sub3-2"; // JSP 파일 이름
    }

    // 첫 화면인 "/" 경로를 "/tree/main"으로 리디렉션
    @GetMapping("/")
    public String redirectToMain() {
        return "redirect:/tree/main";
    }

    // 보호수 검색 기능
    @GetMapping("/searchTree")
    public String searchTrees(
            @RequestParam(value = "t_ad", required = false, defaultValue = "") String t_ad,
            @RequestParam(value = "t_rad", required = false, defaultValue = "") String t_rad,
            HttpServletRequest request) {

        // 보호수 검색 - t_ad, t_rad가 빈 문자열인 경우 모든 보호수 검색
        List<TreeVO> searchResult;
        if (t_ad.isEmpty() && t_rad.isEmpty()) {
            // 검색 조건이 없으면 모든 보호수 목록 가져오기
            searchResult = treeService.getAllTrees();
        } else {
            // 검색 조건이 있으면 해당 조건에 맞는 보호수 검색
            searchResult = treeService.searchTrees(t_ad, t_rad);
        }

        // 검색 결과를 request 객체에 담아 JSP로 전달
        request.setAttribute("treeList", searchResult);

        return "sub3-2"; // 검색 결과 페이지로 이동
    }
}
