package com.ict.project.comm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PagingService {
	
	@Autowired
	private Paging paging; 
	
	// count는 총 데이터 갯수, cPage는 현재 페이지, perPage는 페이지당 보여주는 갯수
	public Paging pagingservice(int count, String cPage, int perPage){
		
		// 총 데이터 갯수
		paging.setTotalRecord(count);
		
		// 페이지당 보여주는 게시물 갯수
		paging.setNumPerPage(perPage);
		
		// 총 페이지 설정
		// 총 데이터 수가 페이지당 데이터 수보다 작으면
		if(paging.getTotalRecord() <= paging.getNumPerPage()) {
			// 최대 페이지를 1로 만듬
			paging.setTotalPage(1);
		}else {
			// 총합 페이지 구하기
			paging.setTotalPage(paging.getTotalRecord() / paging.getNumPerPage());
			// 마지막 페이지에 페이지당 게시물보다 적은 게시물이 있으면
			if(paging.getTotalRecord() % paging.getNumPerPage() != 0) {
				// 총합 페이지수를 하나 더 늘린다.
				paging.setTotalPage(paging.getTotalPage() + 1 );
			}
		}
		
		// 총 페이지 설정
		if(paging.getTotalPage() <= paging.getPagePerBlock()) {
			paging.setTotalBlock(1);
		}else {
			paging.setTotalBlock(paging.getTotalPage() / paging.getPagePerBlock());
			if(paging.getTotalPage() % paging.getPagePerBlock() != 0)
				paging.setTotalBlock(paging.getTotalBlock()+1);
		}
		
		
		// 현재 페이지 설정
		// cpage값이 없으면
		if(cPage == null) {
			// 현재 페이지를 1로 설정
			paging.setNowPage(1);
		}else {
			// 현재 페이지를 cpage 설정
			paging.setNowPage(Integer.parseInt(cPage));
		}
		
		// 현재 블럭 설정
		paging.setNowBlock((paging.getNowPage()-1)/paging.getPagePerBlock()+1);
		
		// offset(DB에서 값을 가져올때 지나간 데이터(현재 2페이지일때 1페이지데이터)를 넘기는 갯수)
		// 페이지당 데이터 수와 현재 페이지 -1 만큼 offset을 설정 
		paging.setOffset(paging.getNumPerPage() * (paging.getNowPage()-1));
		
		// 시작 블럭 세팅
		paging.setBeginBlock(
				// 현재 블럭의 index값에 블럭당 페이지값을 곱해주고 그다음에 1을 더한다.
				(int)((paging.getNowBlock()-1) * paging.getPagePerBlock()+1));
		// 마지막 블럭은 시작블럭에 블럭당 페이지수를 더하고 1을 빼준다.
		paging.setEndBlock(paging.getNowBlock()*paging.getPagePerBlock());
		
		// 만약 마지막 블럭이 총 페이지보다 크면
		if(paging.getEndBlock() >  paging.getTotalPage()) {
			// 마지막 블럭을 총 페이지값으로 한다.
			paging.setEndBlock(paging.getTotalPage());
		}
		
		return paging;
	}
	
}
