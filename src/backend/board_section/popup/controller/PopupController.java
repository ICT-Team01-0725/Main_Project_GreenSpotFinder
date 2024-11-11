package com.ict.project.popup.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ict.project.popup.service.PopFileService;
import com.ict.project.popup.service.PopupService;
import com.ict.project.popup.vo.PopupVO;

@Controller
public class PopupController {
	
	@Autowired PopFileService fileService;
	
	@Autowired
	private PopupService popupService;
	
	// 삽입
	@PostMapping("/pop/insert")
	public ModelAndView popupInsert(HttpServletRequest request ,PopupVO pvo) {
		ModelAndView mv = new ModelAndView();
		// 파일 업로드
		pvo = fileService.popFileUpload(request, pvo);
	    // DB에 저장
		popupService.getPopInsert(pvo);
		
		mv.setViewName("redirect:/poplist");
		return mv;
		
	}
	
	// 리스트 출력
	@RequestMapping("/pop/list")
	public ModelAndView popupList() {
		ModelAndView mv = new ModelAndView();
		List<PopupVO> list = popupService.getPopList();
		mv.addObject("list", list);
		mv.setViewName("pop/list");
		return mv;
	}
	
	// 상세보기
	@RequestMapping("/pop/detail")
	public ModelAndView popupDetail(String pop_idx) {
		ModelAndView mv = new ModelAndView();
		PopupVO pvo = popupService.getPopDetail(pop_idx);
		mv.addObject("pvo", pvo);
		mv.setViewName("pop/detail");
		
		return mv;
	}
	
	// 업데이트
	@PostMapping("/pop/update")
	public ModelAndView popupUpdate(HttpServletRequest request ,PopupVO pvo) {
		ModelAndView mv = new ModelAndView();
		PopupVO pvodb = popupService.getPopDetail(pvo.getPop_idx());
		pvo.setOld_pic(pvodb.getPop_pic());
		
		if(pvo.getPop_file()!=null) {
			pvo = fileService.popFileUpdate(request, pvo);
		}else {
			pvo.setPop_pic(pvo.getOld_pic());
		}
		int result = popupService.getPopUpdate(pvo);
		if(result>0) {
			request.getSession().setAttribute("updateok", "ok");
		}else {
			request.getSession().setAttribute("updateok", "fail");
		}
		mv.setViewName("redirect:/popdetail?pop_idx="+pvo.getPop_idx());
		return mv;
	}
	
	// 삭제
	@PostMapping("/pop/delete")
	public ModelAndView popDelete(HttpServletRequest request, PopupVO pvo) {
		ModelAndView mv = new ModelAndView();
		fileService.popFileDelete(request, pvo);
		popupService.getPopDelete(pvo);
		
		mv.setViewName("redirect:/poplist");
		return mv;
	}
}
