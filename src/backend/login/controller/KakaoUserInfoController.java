package com.ict.project.login.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.ict.project.login.service.LoginService;
import com.ict.project.login.vo.KakaoUserResponse;
import com.ict.project.login.vo.KakaoVO;
import com.ict.project.login.vo.LoginVO;


@RestController
public class KakaoUserInfoController {
	
	@Autowired
	private LoginService loginService;
	
	// 사용자 정보 가져오기
	@RequestMapping(value = "/kakaoUserInfo", produces="application/json; charset=utf-8")
	@ResponseBody
	public ModelAndView kakaoUserInfo(HttpServletRequest request){
		// 세션에 저장된 access_token을 이용해서 사용자 정보 가져오기
		KakaoVO kavo = (KakaoVO) request.getSession().getAttribute("kavo");
		String access_token = kavo.getAccess_token();
		System.out.println(access_token);
		String apiURL = "https://kapi.kakao.com/v2/user/me";
		String header = "Bearer " + access_token;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Authorization", header);
		
		return kakaoRequest(apiURL, headers, request);
	}
	
	
	
	public ModelAndView kakaoRequest(String apiURL, Map<String, String> headers, HttpServletRequest request) {
		HttpURLConnection conn = null;
		BufferedReader br = null;
		try {
			URL url = new URL(apiURL);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			
			// 헤더설정
			for (Entry<String, String> k : headers.entrySet()) {
				conn.setRequestProperty(k.getKey(), k.getValue());
			}
			
			// 응답코드 확인
			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : "+ responseCode);
			
			if(responseCode == HttpURLConnection.HTTP_OK) {
				// 토큰 요청 성공 후 결과 받기 (JSON 타입)
				br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String line = "";
				StringBuffer sb2 = new StringBuffer();
				System.out.println(br.toString());
				while((line= br.readLine())!=null) {
					sb2.append(line);
				}
				
				// DB에 저장하기 위한 정보 추출
				
				Gson gson = new Gson();
				KakaoUserResponse kakaoUser = gson.fromJson(sb2.toString(), KakaoUserResponse.class);
				
				LoginVO lvo = new LoginVO();
				
				lvo.setU_na(kakaoUser.getProperties().getNickname()); 
				lvo.setU_pic(kakaoUser.getProperties().getProfile_image()); 
				lvo.setU_kakao(String.valueOf(kakaoUser.getId())); 
				lvo.setU_em(kakaoUser.getKakao_account().getEmail());  // 이메일은 동의한 경우에만 제공
				
				System.out.println("u_em : "+lvo.getU_em());
				System.out.println("u_na : "+lvo.getU_na());
				System.out.println("u_pic : "+lvo.getU_pic());
				System.out.println("u_kakao : "+lvo.getU_kakao());
				// 카카오 아이디가 없을경우 회원가입
				if(loginService.kakaoChk(lvo.getU_kakao())==null) {
					// System.out.println("회원가입 진행");
					// 기존 아이디에 kakaoid가 존재하지 않으면 아이디를 kakaoid로 설정
					if(loginService.idChk(String.valueOf(kakaoUser.getId()))== null) {
						// System.out.println("아이디가 카카오아이디");
						lvo.setU_id(String.valueOf(kakaoUser.getId()));
					}else {
						// 만약 kakaoid가 기존 아이디에 있으면 
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
					// 카카오 아이디로 아이디 가져오기
					String id = loginService.idKakao(lvo.getU_kakao());
					lvo.setU_id(id);
				}
					
				// String fullName = kakaoUser.getProperties().getFullName();
				
				// id 가지고 사용자 DB에 검색해서 id가 있으면 사용자 정보를 더 가져올 수 있다.
				// id 가지고 사용자 DB에 검색해서 id가 없으면 처음 kakao로 로그인 한 사람이므로 등록한다.
				
				System.out.println("id"+lvo.getU_id());

				request.getSession().setAttribute("u_id",lvo.getU_id());
				
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
