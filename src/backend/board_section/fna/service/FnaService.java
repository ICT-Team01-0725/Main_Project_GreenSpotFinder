package com.ict.project.fna.service;

import java.util.List;

import com.ict.project.fna.vo.FnaVO;


public interface FnaService {
	
	public int getFnaCount();
	
	public List<FnaVO> getFnaList(int offset, int limit);
	
	public FnaVO getFnaDetail(String idx);
	
	public int getFnaInsert(FnaVO fvo);
	
	public int getFnaUpdate(FnaVO fvo);
	
	public int getFnaDelete(String idx);
}
