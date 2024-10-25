package com.ict.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ict.project.service.LoginService;
import com.ict.project.vo.LoginVO;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	@GetMapping("/loginGo")
	public ModelAndView loginGo() {
		ModelAndView mv = new ModelAndView("login/login");
		return mv;
	}
	
	@GetMapping("/idFindGo")
	public ModelAndView idFindGo() {
		ModelAndView mv = new ModelAndView("login/idfind");
		return mv;
	}
	
	@GetMapping("/pwFindGo")
	public ModelAndView pwFindGo() {
		ModelAndView mv = new ModelAndView("login/pwfind");
		return mv;
	}
	
	@GetMapping("/joinGo")
	public ModelAndView joinGo() {
		ModelAndView mv = new ModelAndView("login/join");
		return mv;
	}
	
	@GetMapping("/mainGo")
	public ModelAndView mainGo() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	@GetMapping("/pwFind")
	public ModelAndView pwFind(HttpServletRequest request, LoginVO lvo) {
		ModelAndView mv = new ModelAndView("login/tmp");
		
		return mv;
	}
	@RequestMapping("/joinOK")
	public ModelAndView joinTry(LoginVO lvo) {
		ModelAndView mv = new ModelAndView();
		try {
			lvo.setU_pw(passwordEncoder.encode(lvo.getU_pw()));
			
			int result = loginService.joinOK(lvo);
			if(result > 0) {
				mv.setViewName("login/success");
			}
			else {
				mv.setViewName("login/tmp");
			}
			return mv;
			
		} catch (Exception e) {
			mv.setViewName("login/tmp");
			return mv;
			
		}
		
	}
}
