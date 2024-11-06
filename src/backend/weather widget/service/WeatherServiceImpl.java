package com.ict.project.weather.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

@Service
public class WeatherServiceImpl implements WeatherService{

	private final String apiKeyEnc = "MEu5qTa09k15JyPiNrxnqOzzoCih%2BiRu879QR4jSBC1TwB9WRRpKAfwmK7Nt%2BjLBXkiTLppP8FBzzMlXaKWOWg%3D%3D"; // 여기에 API 키를 입력하세요
	
	private final RestTemplate restTemplate = new RestTemplate(); // RestTemplate 인스턴스 생성
        
	@Override
	public String getWeatherData(String stnId, String tmFc) {
		
		String apiUrl = "http://apis.data.go.kr/1360000/MidFcstInfoService/getMidFcst";  //중기
		
		StringBuilder sb = new StringBuilder();
		String line;
		
		try {
			// 중기 보내는 형식		     
				
			StringBuilder urlBuilder = new StringBuilder(apiUrl); /*URL*/
			urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + apiKeyEnc); /*Service Key*/
			urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); 		/*페이지번호*/
			urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1000", "UTF-8")); /*한 페이지 결과 수*/
			urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*요청자료형식(XML/JSON) Default: XML*/
			urlBuilder.append("&" + URLEncoder.encode("stnId","UTF-8") + "=" + URLEncoder.encode(stnId, "UTF-8")); 		
			urlBuilder.append("&" + URLEncoder.encode("tmFc","UTF-8") + "=" + URLEncoder.encode(tmFc, "UTF-8")); 	
		
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			
			System.out.println("Response code: " + conn.getResponseCode());
			
			BufferedReader rd;
			
			if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			    rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
			    rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
						
			while ((line = rd.readLine()) != null) {
			    sb.append(line);
			}
			
			rd.close();
			conn.disconnect();
			
		} catch (Exception e) {
          // 예외 발생 시 더미 JSON 문자열 반환
			 e.printStackTrace();
			 return sb.toString();
        }	
			
		return sb.toString();
		
	}
	

	@Override
	public String getWeatherData2(String baseDate, String baseTime, String nx, String ny) {
		
		String apiUrl = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtFcst";  //초단기예보 조회
        
		StringBuilder sb = new StringBuilder();
		String line;
		
		try {
			// 초단기 예보 형식	     
			
			StringBuilder urlBuilder = new StringBuilder(apiUrl); /*URL*/
			urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + apiKeyEnc); /*Service Key*/
			urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); 		/*페이지번호*/
			urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1000", "UTF-8")); /*한 페이지 결과 수*/
			urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*요청자료형식(XML/JSON) Default: XML*/
			urlBuilder.append("&" + URLEncoder.encode("base_date","UTF-8") + "=" + URLEncoder.encode(baseDate, "UTF-8")); 
			urlBuilder.append("&" + URLEncoder.encode("base_time","UTF-8") + "=" + URLEncoder.encode(baseTime, "UTF-8")); 
			urlBuilder.append("&" + URLEncoder.encode("nx","UTF-8") + "=" + URLEncoder.encode(nx, "UTF-8")); /*예보지점의 X 좌표값*/
			urlBuilder.append("&" + URLEncoder.encode("ny","UTF-8") + "=" + URLEncoder.encode(ny, "UTF-8")); /*예보지점의 Y 좌표값*/
			
			System.out.println(urlBuilder.toString());
			
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			
			System.out.println("Response code: " + conn.getResponseCode());
			
			BufferedReader rd;
			
			if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			    rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
			    rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
						
			while ((line = rd.readLine()) != null) {
			    sb.append(line);
			}
			
			rd.close();
			conn.disconnect();
			
			System.out.println(sb.toString());
		
		} catch (Exception e) {
            // 예외 발생 시 더미 JSON 문자열 반환
            e.printStackTrace();
            return sb.toString();
        }
		
		return sb.toString();
	}
	
	// 초단기예보
	@Override
	public String getRegionName(String nx, String ny) {
		
		return "";
		
		
	}

}
