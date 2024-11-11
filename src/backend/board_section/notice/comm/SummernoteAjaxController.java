package com.ict.project.notice.comm;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ict.project.notice.vo.ImgVO;




@Controller
public class SummernoteAjaxController {

	@RequestMapping(value = "/saveImg", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> saveImg(ImgVO imgVO, HttpServletRequest request) {
		try {
			Map<String, String> map = new HashMap<String, String>();
			MultipartFile file = imgVO.getS_file();
			String fname = null;
			if (file.getSize()>0) {
				String path = request.getSession().getServletContext().getRealPath("/resources/upload");
				// 현재 날짜와 시간 가져오기
			    LocalDateTime now = LocalDateTime.now();

		        // 원하는 형식으로 포맷하기
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		        String nowstr = now.format(formatter);
			    
		        // pic 파일이름 file 실제 파일
		        // 업로드시간_파일명 의 형태로 저장
		        fname = nowstr+"_"+file.getOriginalFilename();
				// 업로드
				file.transferTo(new File(path, fname));
			}
			
			map.put("path", "resources/upload");
			map.put("fname", fname);
			return map;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
