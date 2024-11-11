package com.ict.project.popup.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.project.popup.vo.PopupVO;

@Repository
public class PopupDAOImpl implements PopupDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<PopupVO> getPopList() {
		return sqlSessionTemplate.selectList("popup.poplist");
	}

	@Override
	public PopupVO getPopDetail(String pop_idx) {
		return sqlSessionTemplate.selectOne("popup.popdetail",pop_idx);
	}

	@Override
	public int getPopInsert(PopupVO pvo) {
		return sqlSessionTemplate.insert("popup.popinsert",pvo);
	}

	@Override
	public int getPopUpdate(PopupVO pvo) {
		return sqlSessionTemplate.update("popup.popupdate",pvo);
	}

	@Override
	public int getPopDelete(PopupVO pvo) {
		return sqlSessionTemplate.update("popup.popdelete",pvo);
	}

}
