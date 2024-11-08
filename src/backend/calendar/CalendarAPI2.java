package com.ict.edu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.ict.edu.service.CalendarService;
import com.ict.edu.vo.CalendarVO1;

@RestController
public class CalendarAPI2 {
    
    @Autowired
    private CalendarService calendarService;

    @RequestMapping(value = "/CalendarAPI", produces = "application/json; charset=utf-8")
    @ResponseBody
    public List<Map<String, Object>> CalendarAPI() {
        List<Map<String, Object>> events = new ArrayList<>();

        try {
            StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B090041/openapi/service/SolcWeekInfoService_v2/getWeekInfo_v2");
            urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=52ymXNytxhFwMhRKfjsiRSEJ41UCNkUOwaeWPZa%2BAn%2B5UmkIr%2FNhK5pkuaUvleEhYJ118D4TesKA3epOVs9iPw%3D%3D");
            urlBuilder.append("&" + URLEncoder.encode("solYear", "UTF-8") + "=" + URLEncoder.encode("2024", "UTF-8"));
            urlBuilder.append("&" + URLEncoder.encode("solMonth", "UTF-8") + "=" + URLEncoder.encode("02", "UTF-8"));
            URL url = new URL(urlBuilder.toString());

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/xml");
            System.out.println("Response code: " + conn.getResponseCode());

            BufferedReader rd;
            if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }
            rd.close();
            conn.disconnect();

            // XML 데이터를 파싱
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(sb.toString())));

            NodeList itemList = doc.getElementsByTagName("item");

            for (int i = 0; i < itemList.getLength(); i++) {
                Node node = itemList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element item = (Element) node;

                    // 'locdate' 값이 존재하는지 확인
                    Node locdateNode = item.getElementsByTagName("locdate").item(0);
                    if (locdateNode != null) {
                        String locdate = locdateNode.getTextContent();

                        // 날짜 형식 변환
                        String yyyy = locdate.substring(0, 4);
                        String mm = locdate.substring(4, 6);
                        String dd = locdate.substring(6, 8);

                        // CalendarVO 객체에 데이터 설정
                        CalendarVO1 cvo = new CalendarVO1();
                        cvo.setYyyy(yyyy);
                        cvo.setMm(mm);
                        cvo.setDd(dd);

                        // DB에 데이터 삽입
                        try {
                            calendarService.getCalendarInsert(cvo);
                        } catch (Exception e) {
                            System.out.println("DB 삽입 중 오류 발생: " + e.getMessage());
                        }

                        // JSON으로 반환할 이벤트 데이터 준비
                        Map<String, Object> event = new HashMap<>();
                        event.put("title", "Holiday");  // 이벤트 제목 설정
                        event.put("start", yyyy + "-" + mm + "-" + dd);  // 날짜 형식 변환
                        event.put("allDay", true);
                        events.add(event);
                    } else {
                        System.out.println("locdate 값이 존재하지 않습니다.");
                    }
                }
            }
            
        } catch (Exception e) {
            System.out.println("오류 발생: " + e.getMessage());
        }
        
        // JSON 형태로 이벤트 리스트 반환
        return events;
    }
}
