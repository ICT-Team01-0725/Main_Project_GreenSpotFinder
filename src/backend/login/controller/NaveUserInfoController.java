package com.ict.project.login.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.ict.project.login.service.LoginService;
import com.ict.project.login.vo.LoginVO;
import com.ict.project.login.vo.NaverUserResponse;
import com.ict.project.login.vo.NaverVO;



@Controller
public class NaveUserInfoController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "/naverUserInfo", produces = "application/json; charset=utf-8")
	@ResponseBody
	public ModelAndView NaverUserInfo(HttpServletRequest request) {
		NaverVO navo = (NaverVO)request.getSession().getAttribute("navo");
		String access_token = navo.getAccess_token();
		// System.out.println("access_token : " + access_token);
		
		String apiURL = "https://openapi.naver.com/v1/nid/me";
		
		HttpURLConnection conn = null;
		BufferedReader br = null;
		try {
			URL url = new URL(apiURL);
			conn = (HttpURLConnection)url.openConnection();
			
			// POST
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			
			// 헤더 요청
			// conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			conn.setRequestProperty("Authorization", "Bearer " + access_token);
			
			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode);
			
			if(responseCode == HttpURLConnection.HTTP_OK) {
				br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				
				String line = "";
				StringBuffer sb = new StringBuffer();
				while((line = br.readLine()) !=null) {
					sb.append(line);
				}
				// System.out.println(sb.toString());
				Gson gson = new Gson();
				NaverUserResponse  naverUser = gson.fromJson(sb.toString(), NaverUserResponse.class);
				LoginVO lvo = new LoginVO();
				
				lvo.setU_na(naverUser.getResponse().getName()); 
				System.out.println(lvo.getU_na());
				lvo.setU_em(naverUser.getResponse().getEmail()); 
				System.out.println(lvo.getU_em());
				lvo.setU_phone(naverUser.getResponse().getMobile()); 
				System.out.println(lvo.getU_phone());
				lvo.setU_naver(naverUser.getResponse().getId()); 
				System.out.println(lvo.getU_naver());
				lvo.setU_pic(naverUser.getResponse().getProfile_image()); 
				System.out.println(lvo.getU_pic());
				
				if(loginService.naverChk(lvo.getU_naver())==null) {
					// System.out.println("회원가입 진행");
					// 기존 아이디에 naverid가 존재하지 않으면 아이디를 naverid로 설정
					if(loginService.idChk(lvo.getU_naver())== null) {
						// System.out.println("아이디가 네이버아이디");
						lvo.setU_id(lvo.getU_naver());
					}else {
						// 만약 naverid가 기존 아이디에 있으면 
						// uuid를 유저 아이디로 생성
						// System.out.println("아이디가 uuid");
						String uuid;
						do {
							uuid= UUID.randomUUID().toString();
						} while(loginService.idChk(uuid)!=null);
						
						lvo.setU_id(uuid);
					}
					int result = loginService.joinOK(lvo);
					// 값을 못넣었을때
					if(result == 0) {
						System.out.println("에러 발생");
					}
				}else {
					// 네이버 아이디로 아이디 가져오기
					String id = loginService.idNaver(lvo.getU_naver());
					lvo.setU_id(id);
				}
					
				// String fullName = kakaoUser.getProperties().getFullName();
				
				// id 가지고 사용자 DB에 검색해서 id가 있으면 사용자 정보를 더 가져올 수 있다.
				// id 가지고 사용자 DB에 검색해서 id가 없으면 처음 kakao로 로그인 한 사람이므로 등록한다.
				
				System.out.println("id : "+lvo.getU_id());

				request.getSession().setAttribute("u_id",lvo.getU_id());
				
				
				
				// 네이버는 특별한 로그아웃 없다. 그래서 로그아웃시 세션을 초기화 한다.
				// 세션만 초기화 하면 id는 고정값이 된다.
				
				// System.out.println("id : " + naverUser.getResponse().getId());
				// System.out.println("email : " + naverUser.getResponse().getEmail());
				
				// naverUser 정보를 세션에 넣으면 다른 컨트롤러나 jsp에서 호출해서 사용할 수 있다.
				// id 가지고 사용자 DB에 검색해서 id가 있으면 사용자 정보를 더 가져올 수 있다.
				// id 가지고 사용자 DB에 검색해서 id가 없으면 DB에 등록한다.
				
				return new ModelAndView("redirect:/mainGo");
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				br.close();
				conn.disconnect();
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
		return null;
	}
	
}
