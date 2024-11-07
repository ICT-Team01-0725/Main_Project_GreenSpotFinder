package com.ict.project.login.controller;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ict.project.login.service.LoginService;
import com.ict.project.login.vo.LoginVO;
import com.ict.project.login.controller.Common;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	// 로그인 화면 이동
	@GetMapping("/loginGo")
	public ModelAndView loginGo() {
		ModelAndView mv = new ModelAndView("login/login");
		return mv;
	}
	
	// 아이디 찾기 이동
	@GetMapping("/idFindGo")
	public ModelAndView idFindGo() {
		ModelAndView mv = new ModelAndView("login/idfind");
		return mv;
	}
	
	// 비밀번호 찾기 이동	
	@GetMapping("/pwFindGo")
	public ModelAndView pwFindGo() {
		ModelAndView mv = new ModelAndView("login/pwfind");
		return mv;
	}
	
	// 회원가입 이동	
	@GetMapping("/joinGo")
	public ModelAndView joinGo() {
		ModelAndView mv = new ModelAndView("login/join");
		return mv;
	}
	
	// 메인화면 이동	
	@GetMapping("/mainGo")
	public ModelAndView mainGo() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
	// 패스워드 찾기
	@PostMapping("/pwFind")
	public ModelAndView pwFind(HttpServletRequest request, LoginVO lvo) {
		System.out.println(lvo.getU_id());
		System.out.println(lvo.getU_em());
		ModelAndView mv = new ModelAndView();
		LoginVO dblvo;
		
		dblvo = loginService.getDetail(lvo.getU_id());
		if(dblvo != null) {
		if(lvo.getU_em().equals(dblvo.getU_em())) {
			mv.setViewName("redirect:/emailsend");
			request.getSession().setAttribute("cmd", "emailpw");
			request.getSession().setAttribute("u_em", lvo.getU_em());
			request.getSession().setAttribute("u_id", lvo.getU_id());
			
		} else {
			mv.setViewName("login/pwfind");
			System.out.println("아이디 이메일 틀림");
			mv.addObject("pwfind","fail");
		}} else {
			mv.setViewName("login/pwfind");
			System.out.println("아이디 이메일 틀림22");
			mv.addObject("pwfind","fail");
		}
		return mv;
	}
	
	@PostMapping("/pwfindok")
	public ModelAndView pwFindOK() {
		ModelAndView mv = new ModelAndView("login/pwfindok");
		
		return mv;
	}
	
	
	@RequestMapping("/emailpw")
	public ModelAndView emailPw(ModelAndView mv) {
		mv.setViewName("login/emailpw");
		
		return mv;
	}
	
	// 회원가입 이메일 확인화면 이동
	@RequestMapping("/emailjoin")
	public ModelAndView emailJoin(ModelAndView mv) {
		mv.setViewName("login/emailjoin");
		return mv;
	}
	
	// 아이디 찾기 화면
	@RequestMapping("/emailid")
	public ModelAndView emailId(ModelAndView mv) {
		mv.setViewName("login/emailid");
		return mv;
	}
	
	// 회원가입
	@RequestMapping("/joinOK")
	public ModelAndView joinTry(LoginVO lvo) {
		ModelAndView mv = new ModelAndView();
		try {
			// 비밀번호 암호화
			lvo.setU_pw(passwordEncoder.encode(lvo.getU_pw()));
			System.out.println(lvo.getU_pw());
			// 프로필사진 기본값
			lvo.setU_pic("기본사진값");
			
			// DB에 회원정보 입력
			int result = loginService.joinOK(lvo);
			
			System.out.println(result);
			// 정보 삽입 성공시
			if(result > 0) {
				// 회원가입 완료창으로 이동
				mv.setViewName("login/success");
			}
			else {
				// 임시파일로 이동
				mv.setViewName("login/tmp");
			}
			return mv;
			
		} catch (Exception e) {
			System.out.println(e);
			mv.setViewName("login/tmp");
			return mv;
			
		}
		
	}
	
	// 회원가입 이메일 체크
	@PostMapping("/emailchk")
	public ModelAndView emailChk(LoginVO lvo, @RequestParam("u_emailback") String back, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		// 이메일 뒷자리 + 앞자리 
		String u_em = lvo.getU_em()+"@"+back; 
		lvo.setU_em(u_em);
		request.getSession().setAttribute("u_em", u_em);
		request.getSession().setAttribute("lvo", lvo);
		System.out.println(lvo);
		request.getSession().setAttribute("cmd", "emailjoin");
		mv.setViewName("redirect:/emailsend");
		return mv;
	}
	
	// 아이디찾기 이메일 체크
	@PostMapping("/idFind")
	public ModelAndView idFind(HttpServletRequest request, String u_em) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/emailsend");
		request.getSession().setAttribute("cmd", "emailid");
		request.getSession().setAttribute("u_em", u_em);
		return mv;
	}
	
	// 아이디찾기 확인 후
	@PostMapping("/idfindok")
	public ModelAndView idFindOK(HttpSession session, String u_em) {
		ModelAndView mv = new ModelAndView();
		System.out.println("u_em : " +u_em);
		List<String> ids = loginService.getId(u_em);
		mv.addObject("ids",ids);
		mv.setViewName("login/idfindok");
		session.removeAttribute("u_em");
		return mv;
	}
	
	
	// 로그인 시도
	@PostMapping("/loginok")
	public ModelAndView loginOK(LoginVO lvo ,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		// DB에서 로그인 정보 가져옴
		LoginVO lvo2 = loginService.getDetail(lvo.getU_id());
		// 아이디가 DB에 없을때
		if(lvo2 == null) {
			// loginok 값 fail
			session.setAttribute("loginok", "fail");
			// 로그인창으로 이동
			mv.setViewName("redirect:/loginGo");
		}else {
			// 비밀번호가 맞을때
			if(passwordEncoder.matches(lvo.getU_pw(), lvo2.getU_pw())) {
				// loginok값 ok
				session.setAttribute("loginok", "ok");
				// 세션에 정보 담기
				session.setAttribute("u_id", lvo.getU_id());
				// 메인으로 이동
				mv.setViewName("redirect:/mainGo");
			}
			// 비밀번호가 틀렸을때
			else {
				// loginok값 fail
				session.setAttribute("loginok", "fail");
				// 로그인창으로 이동
				mv.setViewName("redirect:/loginGo");
			}
		}
		return mv;
	}
	
	
	
	@PostMapping("/u_update")
	public ModelAndView updateOK(LoginVO lvo, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		try {
			String path = request.getSession().getServletContext().getRealPath("/resources");
			MultipartFile file = lvo.getU_file();
			
			if(file.isEmpty()) {
				lvo.setU_pic("기본사진값");
			} else {
				 // 현재 날짜와 시간 가져오기
		        LocalDateTime now = LocalDateTime.now();

		        // 원하는 형식으로 포맷하기
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		        String nowstr = now.format(formatter);
		        
		        // pic 파일이름 file 실제 파일
		        // 업로드시간_파일명 의 형태로 저장
		        String fname = nowstr+"_"+file.getOriginalFilename();
		        lvo.setU_pic(fname);
		        
		        // 실질적인 파일 업로드
		        file.transferTo(new File(path, fname));
				
			}
			
			int result = loginService.update(lvo);
			if(result ==0) {
				mv.setViewName("login/tmp");
				return mv;
			}
			mv.setViewName("login");
			
			return mv;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	@PostMapping("/pwupdate")
	public ModelAndView pwUpdate(LoginVO lvo) {
		ModelAndView mv = new ModelAndView();
		lvo.setU_pw(passwordEncoder.encode(lvo.getU_pw()));
		int result = loginService.updatePw(lvo);
		if(result >0 ) {
			mv.setViewName("login/pwsuccess");
		} else {
			mv.setViewName("login/tmp");
		}
		
		return mv;
	}
	
	

}
