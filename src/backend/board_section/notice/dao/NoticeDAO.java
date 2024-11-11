package com.ict.project.notice.dao;

import java.util.List;

import com.ict.project.comment.vo.CommentVO;
import com.ict.project.notice.vo.NoticeVO;



public interface NoticeDAO {
    public int getTotalCount();
    public List<NoticeVO> getBoardList(int offset, int limit);
    public int getBoardInsert(NoticeVO gvo);
    public int getBoardHit(String idxn_idx);
    public NoticeVO getBoardDetail(String idxn_idx);
    public int getBoardDelete(String idxn_idx);
    public int getBoardUpdate(NoticeVO gvo);


}
