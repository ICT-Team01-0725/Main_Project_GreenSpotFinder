package com.ict.project.review.service;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ict.project.review.vo.ReviewVO;

@Service
public class ReviewFileServiceImpl implements ReviewFileService{

	@Override
	public ReviewVO reviewFileUpload(HttpServletRequest request, ReviewVO rvo) {
		try {
			String path = request.getSession().getServletContext().getRealPath("/resources/images");
			MultipartFile file = rvo.getRev_file();
			
			// 현재 날짜와 시간 가져오기
		    LocalDateTime now = LocalDateTime.now();

	        // 원하는 형식으로 포맷하기
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
	        String nowstr = now.format(formatter);
		    
	        // pic 파일이름 file 실제 파일
	        // 업로드시간_파일명 의 형태로 저장
	        String fname = nowstr+"_"+file.getOriginalFilename();
	        
	        // rvo에 파일이름 저장
	        rvo.setRev_filename(fname);
	        
	        // 실질적인 파일 업로드
	        file.transferTo(new File(path, fname));
	        
	        return rvo;
		}catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public ReviewVO reviewFileUpdate(HttpServletRequest request, ReviewVO rvo) {
		try {
			// 기존 파일 경로 가져오기
	        String oldFileName = rvo.getRev_oldname();
	        String path = request.getSession().getServletContext().getRealPath("/resources/images");
			
	        // 기존 파일 삭제
	        File oldFile = new File(path, oldFileName);
	        if (oldFile.exists()) {
	            boolean deleted = oldFile.delete();
	            if (!deleted) {
	                System.out.println("기존 파일 삭제 실패: " + oldFileName);
	            }
	        } else {
	            System.out.println("기존 파일이 존재하지 않습니다: " + oldFileName);
	        }
	        
	        // 새 파일 업로드
	        rvo = reviewFileUpload(request, rvo); // fileUpload 메서드 호출
			
	        return rvo;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	
}
