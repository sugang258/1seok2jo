package com.seok.home.f_board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seok.home.b_comment.FreeBoardReplyDTO;
import com.seok.home.s_board.CommentPager;
import com.seok.home.s_board.Pager;

@Service
public class FreeBoardService {
	
	@Autowired
	private FreeBoardDAO freeBoardDAO;
	
	/* 자유게시판 목록조회 */
	public List<FreeBoardDTO> getF_boardList(Pager pager)throws Exception{
		Long totalCount = freeBoardDAO.getTotalCount(pager);
		pager.getBlockNum(totalCount);
		pager.getRowNum();
		return freeBoardDAO.getF_boardList(pager);
	}
	/* 자유게시판 글작성 */
	public int setF_boardAdd(FreeBoardDTO freeBoardDTO)throws Exception{
		return freeBoardDAO.setF_boardAdd(freeBoardDTO);
	}
	/* 자유게시판 글 상세보기 */
	public FreeBoardDTO getF_boardDetail(FreeBoardDTO freeBoardDTO)throws Exception{
		/* 자유게시판 조회수 */
		freeBoardDAO.setFb_hit(freeBoardDTO);
		return freeBoardDAO.getF_boardDetail(freeBoardDTO);
	}
	/* 자유게시판 글 수정 */
	public int setF_boardUpdate(FreeBoardDTO freeBoardDTO)throws Exception{
		return freeBoardDAO.setF_boardUpdate(freeBoardDTO);
	}
	/* 자유게시판 글 삭제 */
	public int setF_boardDelete(FreeBoardDTO freeBoardDTO)throws Exception{
		return freeBoardDAO.setF_boardDelete(freeBoardDTO);
	}
	
	/* 자유게시판 추천조회 */
	public Fb_heartDTO getFb_heart(Fb_heartDTO fb_heartDTO)throws Exception{
		return freeBoardDAO.getFb_heart(fb_heartDTO);
	}
	/* 자유게시판 추천등록 */
	public int setFb_heartAdd(Fb_heartDTO fb_heartDTO)throws Exception{
		return freeBoardDAO.setFb_heartAdd(fb_heartDTO);
	}
	/* 자유게시판 추천취소 */
	public int setFb_heartDelete(Fb_heartDTO fb_heartDTO)throws Exception{
		return freeBoardDAO.setFb_heartDelete(fb_heartDTO);
	}
	/* 자유게시판 추천갯수 */
	public Long getFb_heartCount(Fb_heartDTO fb_heartDTO)throws Exception{
		return freeBoardDAO.getFb_heartCount(fb_heartDTO);
	}
	
	/* 자유게시판 댓글리스트 */
	public List<FreeBoardReplyDTO> getFb_replyList(CommentPager commentPager)throws Exception{
		return freeBoardDAO.getFb_replyList(commentPager);
	}
	
	/* 자유게시판 댓글작성 */
	public int setFb_replyAdd(FreeBoardReplyDTO freeBoardReplyDTO)throws Exception{
		return freeBoardDAO.setFb_replyAdd(freeBoardReplyDTO);
	}
	
	/* 자유게시판 댓글삭제 */
	public int setFb_replyDelete(FreeBoardReplyDTO freeBoardReplyDTO)throws Exception{
		return freeBoardDAO.setFb_replyDelete(freeBoardReplyDTO);
	}
	
	/* 자유게시판 댓글수 */
	public Long getReplyCount(FreeBoardReplyDTO freeBoardReplyDTO)throws Exception{
		return freeBoardDAO.getReplyCount(freeBoardReplyDTO);
	}

}
