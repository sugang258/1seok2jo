package com.seok.home.b_comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seok.home.s_board.CommentPager;
import com.seok.home.s_board.StudyBoardDAO;
import com.seok.home.s_board.StudyBoardDTO;

@Service
public class CommentService {

	@Autowired
	private CommentDAO commentDAO;
	@Autowired
	private StudyBoardDAO studyBoardDAO;
	
	//강사답글 확인
	public CommentDTO getCommentDetail(CommentDTO commentDTO)throws Exception {
		return commentDAO.getCommentDetail(commentDTO);
	}
	
	//강사답글 추가 및 게시글 답변상태 변경
	public int setCommentAdd(CommentDTO commentDTO)throws Exception{
		StudyBoardDTO studyBoardDTO = new StudyBoardDTO();
		studyBoardDTO.setSb_num(commentDTO.getSb_num());
		studyBoardDAO.setAnsewer(studyBoardDTO);
		return commentDAO.setCommentAdd(commentDTO);
	}
	
	//강사 답글 수정
	public int setCommentUpdate(CommentDTO commentDTO)throws Exception{
		return commentDAO.setCommentUpdate(commentDTO);
	}
	
	//강사답글 삭제 및 게시글 답변상태 변경
	public int setCommentDelete(CommentDTO commentDTO)throws Exception{
		StudyBoardDTO studyBoardDTO = new StudyBoardDTO();
		studyBoardDTO.setSb_num(commentDTO.getSb_num());
		studyBoardDAO.setAnsewerDefault(studyBoardDTO);
		return commentDAO.setCommentDelete(commentDTO);
	}
	
	//게시판 댓글
	public List<CommentDTO> getSB_CommentList(CommentPager commentPager)throws Exception{
		return commentDAO.getSB_CommentList(commentPager);
	}
	
	public int setSB_CommentAdd(CommentDTO commentDTO)throws Exception{
		return commentDAO.setSB_CommentAdd(commentDTO);
	}
	
	public int setSB_CommentDelete(CommentDTO commentDTO)throws Exception{
		return commentDAO.setSB_CommentDelete(commentDTO);
	}
	
	//강사답글 - 댓글
	public List<CommentDTO> getT_CommentList(CommentPager commentPager)throws Exception{
		return commentDAO.getT_CommentList(commentPager);
	}
	
	public int setT_CommentAdd(CommentDTO commentDTO)throws Exception{
		return commentDAO.setT_CommentAdd(commentDTO);
	}
	
	//강사답글 - 댓글 삭제 및 모든 댓글 삭제(강사답글 삭제 시)
	public int setT_CommentDelete(CommentDTO commentDTO)throws Exception{
		return commentDAO.setT_CommentDelete(commentDTO);
	}
	
	public int setAllCommentDelete(CommentDTO commentDTO)throws Exception{
		return commentDAO.setAllCommentDelete(commentDTO);
	}

	//강사답글의 댓글 수
	public Long getComment_Count(CommentDTO commentDTO)throws Exception{
		return commentDAO.getComment_Count(commentDTO);
	}
}
