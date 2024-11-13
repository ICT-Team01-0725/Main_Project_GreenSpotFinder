package com.ict.edu.searchtreeadcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ict.edu.searchtreeadservice.SearchTreeAdService;
import com.ict.edu.searchtreeadvo.SearchTreeAdVO;

@Controller
@RequestMapping("/searchtreead")
public class SearchTreeAdController {

    @Autowired
    private SearchTreeAdService searchTreeAdService;

    @GetMapping("/")
    public String redirectToMain() {
    	System.out.println("ssss");
        return "redirect:/searchtreead/main";
    }

    @GetMapping("/main")
    public ModelAndView showSearchTreeList() {
        ModelAndView mv = new ModelAndView("sub3-2");
        List<SearchTreeAdVO> treeList = searchTreeAdService.getTop4Trees();
        mv.addObject("treeList", treeList);
        return mv;
    }

    @GetMapping("/searchTreesByAddress")
    public ModelAndView searchByAddress(@RequestParam(value = "address", required = false) String address) {
        ModelAndView mv = new ModelAndView("sub3-2");

        // 주소로 검색
        if (address != null && !address.isEmpty()) {
            // 검색 결과를 서비스에서 처리
            List<SearchTreeAdVO> searchResult = searchTreeAdService.searchTreesByAddress(address);
            mv.addObject("treeList", searchResult);
        } else {
            // 주소가 입력되지 않으면 빈 리스트 반환
            mv.addObject("treeList", new ArrayList<>());
        }

        return mv;
    }

    @GetMapping("/findTree")
    public ModelAndView find(@RequestParam("region") String region) {
        List<SearchTreeAdVO> treesInRegion = searchTreeAdService.searchTreesByRegion(region);
        ModelAndView mv = new ModelAndView("sub3-2");
        mv.addObject("treeList", treesInRegion);
        return mv;
    }
    

    @GetMapping("/visual")
    public String showTreeVisual() {
        return "tree_visual_D3_leaflet.html";
    }

    @GetMapping("/visualTreeData")
    @ResponseBody
    public List<SearchTreeAdVO> getTreeDataForMap() {
        return searchTreeAdService.getAllTrees();
    }
}