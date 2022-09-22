package com.seok.home.b_comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seok.home.s_board.StudyBoardDAO;
import com.seok.home.s_board.StudyBoardDTO;

@Service
public class CommentService {

	@Autowired
	private CommentDAO commentDAO;
	@Autowired
	private StudyBoardDAO studyBoardDAO;
	
	public CommentDTO getCommentDetail(CommentDTO commentDTO)throws Exception {
		return commentDAO.getCommentDetail(commentDTO);
	}
	
	public int setCommentAdd(CommentDTO commentDTO)throws Exception{
		return commentDAO.setCommentAdd(commentDTO);
	}
	
	public int setCommentDelete(CommentDTO commentDTO)throws Exception{
		return commentDAO.setCommentDelete(commentDTO);
	}
	
	//게시판 댓글
	public List<CommentDTO> getSB_CommentList(CommentDTO commentDTO)throws Exception{
		return commentDAO.getSB_CommentList(commentDTO);
	}
	
	public int setSB_CommentAdd(CommentDTO commentDTO)throws Exception{
		return commentDAO.setSB_CommentAdd(commentDTO);
	}
	
	public int setSB_CommentDelete(CommentDTO commentDTO)throws Exception{
		return commentDAO.setSB_CommentDelete(commentDTO);
	}
	
	public Long getComment_Count(CommentDTO commentDTO)throws Exception{
		return commentDAO.getComment_Count(commentDTO);
	}
	
	//강사답글 - 댓글
	public List<CommentDTO> getT_CommentList(CommentDTO commentDTO)throws Exception{
		return commentDAO.getT_CommentList(commentDTO);
	}
	
	public int setT_CommentAdd(CommentDTO commentDTO)throws Exception{
		return commentDAO.setT_CommentAdd(commentDTO);
	}
}
