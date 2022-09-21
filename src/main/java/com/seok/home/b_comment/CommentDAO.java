package com.seok.home.b_comment;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDAO {
	
	@Autowired
	private SqlSession session;
	private static String NAMESPACE="com.seok.home.b_comment.CommentDAO.";
	
	public CommentDTO getCommentDetail(CommentDTO commentDTO)throws Exception {
		return session.selectOne(NAMESPACE+"getCommentDetail", commentDTO);
	}
	
	public int setCommentAdd(CommentDTO commentDTO)throws Exception{
		return session.insert(NAMESPACE+"setCommentAdd", commentDTO);
	}
	
	public int setCommentDelete(CommentDTO commentDTO)throws Exception{
		return session.delete(NAMESPACE+"setCommentDelete", commentDTO);
	}

}
