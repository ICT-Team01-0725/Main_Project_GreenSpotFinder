package com.ict.project.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public void sendemail(String r_num, String tomail) {
		try {
			
			// emailhandler 객체 생성(생성자 실행)
			EmailHandler sendMail = new EmailHandler(javaMailSender);
			
			// 메일 제목
			sendMail.setSubject("email 제목");
			
			// 내용
			sendMail.setText("<table><tbody>"
					+"<tr><td><h2>메일 인증 </h2></td></tr>"
					+"<tr><td><h3>Green Spot Finder</h3></td></tr>"
					+"<tr><td><font size='8px'>인증 번호 안내</font></td></tr>"
					+"<tr><td><font size='10px'>확인번호 : "+r_num+"</font></td></tr>"
					+"</tbody></table>");
			
			// 보내는 사람의 이메일 제목
			sendMail.setForm("ictedu@gmail.com", "ict 관리자");
			
			// 받는 이메일
			sendMail.setTo(tomail);
			
			// 보내기
			sendMail.send();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	
	
}
