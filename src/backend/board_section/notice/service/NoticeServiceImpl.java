package com.ict.project.notice.service;

import java.util.List;
	
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.project.comment.vo.CommentVO;
import com.ict.project.notice.dao.NoticeDAO;
import com.ict.project.notice.vo.NoticeVO;


@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeDAO noticeDAO;

	@Override
	public int getTotalCount() {
		return noticeDAO.getTotalCount();
	}

	@Override
	public List<NoticeVO> getBoardList(int offset, int limit) {
		return noticeDAO.getBoardList(offset, limit);
	}

	@Override
	public int getBoardInsert(NoticeVO gvo) {
		return noticeDAO.getBoardInsert(gvo);
	}

	@Override
	public int getBoardHit(String idxn_idx) {
		return noticeDAO.getBoardHit(idxn_idx);
	}

	@Override
	public NoticeVO getBoardDetail(String idxn_idx) {
		return noticeDAO.getBoardDetail(idxn_idx);
	}

	@Override
	public int getBoardDelete(String idxn_idx) {
		return noticeDAO.getBoardDelete(idxn_idx);
	}

	@Override
	public int getBoardUpdate(NoticeVO gvo) {
		return noticeDAO.getBoardUpdate(gvo);
	}

	
}
