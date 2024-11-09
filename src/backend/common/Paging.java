package com.ict.project.comm;

import org.springframework.stereotype.Component;

@Component
public class Paging {
	
	// 현재 페이지
	private int nowPage = 1 ;
	
	// 현재 블럭
	private int nowBlock = 1 ;
	
	// 한 페이지당 10줄
	private int numPerPage = 10;
	
	// 한 블록당 5개
	private int pagePerBlock = 5;
	
	// DB의 게시물의 수	
	private int totalRecord = 0 ;
	
	// 게시물의 수를 이용해서 전체 페이지의 수
	private int totalPage = 0 ;
	
	private int totalBlock = 0 ;
	
	
	// 한번에 가져올 게시물의 시작번호와 끝번호 
	private int begin = 0 ;
	private int end = 0 ;
	
	private int beginBlock = 0 ;
	private int endBlock = 0 ;
	
	private int offset = 0 ;

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getNowBlock() {
		return nowBlock;
	}

	public void setNowBlock(int nowBlock) {
		this.nowBlock = nowBlock;
	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}

	public int getPagePerBlock() {
		return pagePerBlock;
	}

	public void setPagePerBlock(int pagePerBlock) {
		this.pagePerBlock = pagePerBlock;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalBlock() {
		return totalBlock;
	}

	public void setTotalBlock(int totalBlock) {
		this.totalBlock = totalBlock;
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getBeginBlock() {
		return beginBlock;
	}

	public void setBeginBlock(int beginBlock) {
		this.beginBlock = beginBlock;
	}

	public int getEndBlock() {
		return endBlock;
	}

	public void setEndBlock(int endBlock) {
		this.endBlock = endBlock;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}
	
	
	
}