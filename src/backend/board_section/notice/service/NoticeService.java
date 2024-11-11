package com.ict.project.notice.service;

import java.util.List;

import com.ict.project.comment.vo.CommentVO;
import com.ict.project.notice.vo.NoticeVO;



public interface NoticeService {
    public int getTotalCount();
    public List<NoticeVO> getBoardList(int offset, int limit);
    public int getBoardInsert(NoticeVO gvo);
    public int getBoardHit(String c_idx);
    public NoticeVO getBoardDetail(String c_idx);
    public int getBoardDelete(String c_idx);
    public int getBoardUpdate(NoticeVO gvo);
    
}
