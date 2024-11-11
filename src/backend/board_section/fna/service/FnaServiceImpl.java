package com.ict.project.fna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.project.fna.dao.FnaDAO;
import com.ict.project.fna.vo.FnaVO;


@Service
public class FnaServiceImpl implements FnaService{
	
	@Autowired
	private FnaDAO fnaDAO; 

	@Override
	public List<FnaVO> getFnaList(int offset, int limit) {
		return fnaDAO.getFnaList(offset, limit);
	}

	@Override
	public FnaVO getFnaDetail(String idx) {
		return fnaDAO.getFnaDetail(idx);
	}

	@Override
	public int getFnaInsert(FnaVO fvo) {
		return fnaDAO.getFnaInsert(fvo);
	}

	@Override
	public int getFnaUpdate(FnaVO fvo) {
		return fnaDAO.getFnaUpdate(fvo);
	}

	@Override
	public int getFnaDelete(String idx) {
		return fnaDAO.getFnaDelete(idx);
	}

	@Override
	public int getFnaCount() {
		return fnaDAO.getFnaCount();
	}

}
