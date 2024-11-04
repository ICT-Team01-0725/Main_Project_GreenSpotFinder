package com.ict.project.login.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ict.project.login.service.EmailService;

@Controller
public class Common {
	
	@Autowired
	private EmailService emailService;
	
	
	@RequestMapping("/emailsend")
	public ModelAndView emailSend(HttpServletRequest request, ModelAndView mv) {
		try {
			// 임시번호 6자리 만들기
				Random random = new Random();
				// 0 ~ 1000000 미만의 정수를 무작위로 생성 (6자리 숫자 중 하나를 랜덤으로 만듬
				String randomNumber = String.valueOf(random.nextInt(1000000));
				// 길이가 6자리가 안되면 0으로 채움
				if(randomNumber.length() < 6) {
					int substract = 6-randomNumber.length();
					StringBuffer sb = new StringBuffer();
					for(int i=0; i<substract; i++) {
						sb.append("0");
					}
					sb.append(randomNumber);
					randomNumber = sb.toString();
				}
				// 임시번호 서버에 출력
				System.out.println("임시번호 : "+randomNumber);
				
				HttpSession session = request.getSession();
				
				// 해당 임시번호를 DB에 저장하기 또는 세션에 저장하기
				session.setAttribute("sessionNumber", randomNumber);
				
				System.out.println(session.getAttribute("u_em"));
				//.get("u_em").toString()
				// EmailService 호출해서 사용하기
				emailService.sendemail(randomNumber, session.getAttribute("u_em").toString());
				
				// cmd값 session에서 꺼내서 viewName에 저장
				mv.setViewName("redirect:/"+session.getAttribute("cmd").toString());
				session.removeAttribute("cmd");
				session.removeAttribute("u_em");
				
				System.out.println(request.getSession().getAttribute("cmd"));
				
				return mv;
				
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
