package com.ict.project.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ict.project.login.service.LoginService;


@RestController
public class LoginAjaxController {
	
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "/idchk" , produces = "application/json; charset=utf-8")
	@ResponseBody
	public String idChk(String u_id) {
		String result = "false";
		String idchk = loginService.idChk(u_id);		
		if (idchk == null) {
			result = "true";
		}
		return result;
	}
}
