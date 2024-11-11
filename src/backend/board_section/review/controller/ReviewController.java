package com.ict.project.review.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ict.project.comm.Paging;
import com.ict.project.comm.PagingService;
import com.ict.project.comm.PerPageConstant;
import com.ict.project.comment.service.CommentService;
import com.ict.project.comment.vo.CommentVO;
import com.ict.project.review.service.ReviewFileService;
import com.ict.project.review.service.ReviewService;
import com.ict.project.review.vo.ReviewVO;

@Controller
public class ReviewController {
	
	@Autowired
	private ReviewFileService reviewFileService;
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private PagingService pagingService;
	@Autowired
	private CommentService commentService;
	
	// 리뷰 리스트
	@GetMapping("/review/list")
	public ModelAndView getReviewList(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("review/list");
		
		int count = reviewService.getReviewCount();
		// pagingservice 메서드에 넣을 값
		String cPage = request.getParameter("cPage");
		PerPageConstant pageConstant = new PerPageConstant();
		int perpage = pageConstant.getReviewpage();
				
		// 페이징 기법 설정
		Paging paging = pagingService.pagingservice(count, cPage, perpage);
		// DB 갔다가 오기 
		List<ReviewVO> list = reviewService.getReviewList(paging.getOffset(), paging.getNumPerPage());
		
		mv.addObject("list", list);
		mv.addObject("paging", paging);
		
		return mv;
	}
	
	@RequestMapping("/review/detail")
	public ModelAndView getReviewDetail(CommentVO cvo, String cPage, String rev_idx) {
		ModelAndView mv = new ModelAndView("review/detail");
		ReviewVO rvo = reviewService.getReviewDetail(rev_idx);
		List<CommentVO> clist = commentService.getCommentList(cvo);
		mv.addObject("rvo", rvo);
		mv.addObject("clist", clist);
		return mv;
	}
	
	@PostMapping("/review/insert")
	public ModelAndView getReviewInsert(ReviewVO rvo, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		// 파일 업로드
		reviewFileService.reviewFileUpload(request, rvo);
		// DB에 저장
		reviewService.getReviewInsert(rvo);
		mv.setViewName("redirect:/review/list");
		return mv;
		
	}
	
	@PostMapping("/review/update")
	public ModelAndView getReviewUpdate(ReviewVO rvo, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		ReviewVO rvodb = reviewService.getReviewDetail(rvo.getRev_idx());
		rvo.setRev_oldname(rvodb.getRev_filename());
		
		if(rvo.getRev_file()!=null) {
			reviewFileService.reviewFileUpdate(request, rvo);
		}else {
			rvo.setRev_filename(rvo.getRev_oldname());
		}
		reviewService.getReviewUpdate(rvo);
		mv.setViewName("redirect:/review/detail?rev_idx="+rvo.getRev_idx());
		
		return mv;
	}
	
	@PostMapping("/review/delete")
	public ModelAndView getReviewDelete(String rev_idx) {
		ModelAndView mv = new ModelAndView("redirect:/review/list");
		reviewService.getReviewDelete(rev_idx);
		return mv;
	}
	
	// review 댓글 등록
		@PostMapping("/review/comment_insert")
		public ModelAndView getCommentInsert(CommentVO cvo, 
				 @ModelAttribute("rev_idx") String rev_idx,
				 @ModelAttribute("cPage") String cPage) {
			
			ModelAndView mv = new ModelAndView("redirect:/review_detail");
			commentService.getCommentInsert(cvo);
			
			return mv;
		}
	
	
	@PostMapping("/review/comment_delete")
	public ModelAndView commentDeleteReview(String c_idx, String rev_idx) {
		ModelAndView mv = new ModelAndView("redirect:/review/detail?rev_idx="+rev_idx);
		commentService.getCommentDelete(c_idx);
		return mv;
	}
	
}
