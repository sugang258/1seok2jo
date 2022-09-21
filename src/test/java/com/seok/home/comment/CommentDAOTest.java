package com.seok.home.comment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.seok.home.MyAbstractTest;
import com.seok.home.b_comment.CommentDAO;
import com.seok.home.b_comment.CommentDTO;

public class CommentDAOTest extends MyAbstractTest{
	
	@Autowired
	private CommentDAO commentDAO;
	
	//@Test
	public void getCommentDetail()throws Exception{
		CommentDTO commentDTO = new CommentDTO();
		commentDTO.setSb_num(1163L);
		commentDAO.getCommentDetail(commentDTO);
		
		assertNotNull(commentDTO);
	}
	
	//@Test
	public void setCommentAdd()throws Exception{
		CommentDTO commentDTO = new CommentDTO();
		commentDTO.setSb_num(1128L);
		commentDTO.setContents("ㅎㅎㅎㅎㅎㅎ");
		int result = commentDAO.setCommentAdd(commentDTO);
		
		assertEquals(1, result);
	}
	
	//@Test
	public void setCommentDelete()throws Exception{
		CommentDTO commentDTO = new CommentDTO();
		commentDTO.setSb_num(1115L);
		
		int result = commentDAO.setCommentDelete(commentDTO);
		
		assertEquals(1, result);
	}

}
