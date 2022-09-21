package com.seok.home.b_comment;

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
}
