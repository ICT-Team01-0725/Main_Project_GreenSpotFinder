package com.ict.project.qna.service;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ict.project.qna.vo.QnaVO;

@Service
public class QnaFileServiceImpl implements QnaFileService{

	@Override
	public QnaVO qnaFileUpload(HttpServletRequest request, QnaVO qvo) {
		try {
			String path = request.getSession().getServletContext().getRealPath("/resources/images");
			MultipartFile file = qvo.getQ_file();
			
			// 현재 날짜와 시간 가져오기
		    LocalDateTime now = LocalDateTime.now();

	        // 원하는 형식으로 포맷하기
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
	        String nowstr = now.format(formatter);
		    
	        // pic 파일이름 file 실제 파일
	        // 업로드시간_파일명 의 형태로 저장
	        String fname = nowstr+"_"+file.getOriginalFilename();
	        
	        // qvo에 파일이름 저장
	        qvo.setQ_filename(fname);
	        
	        // 실질적인 파일 업로드
	        file.transferTo(new File(path, fname));
	        
	        return qvo;
		}catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public QnaVO qnaFileUpdate(HttpServletRequest request, QnaVO qvo) {
		try {
			// 기존 파일 경로 가져오기
	        String oldFileName = qvo.getQ_oldname();
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
	        qvo = qnaFileUpload(request, qvo); // fileUpload 메서드 호출
			
	        return qvo;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public void qnaFileDelete(HttpServletRequest request, QnaVO qvo) {
		try {
			
			String path = request.getSession().getServletContext().getRealPath("/resources/images");
			String filename = qvo.getQ_filename();
			File file = new File(path, filename);
			if(file.exists()) {
				boolean deleted = file.delete();
            	if (!deleted) {
                	System.out.println("기존 파일 삭제 실패: " + filename);
            	}
        	} else {
        		System.out.println("기존 파일이 존재하지 않습니다: " + filename);
        	}
	        
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
}
