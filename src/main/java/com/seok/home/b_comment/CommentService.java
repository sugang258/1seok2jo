package com.seok.home.b_comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

	@Autowired
	private CommentDAO commentDAO;
	
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
		return commentDAO.setCommentAdd(commentDTO);
	}
}
