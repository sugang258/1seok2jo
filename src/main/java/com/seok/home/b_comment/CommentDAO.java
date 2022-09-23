package com.seok.home.b_comment;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDAO {
	
	@Autowired
	private SqlSession session;
	private static String NAMESPACE="com.seok.home.b_comment.CommentDAO.";
	
	//강사답글
	public CommentDTO getCommentDetail(CommentDTO commentDTO)throws Exception {
		return session.selectOne(NAMESPACE+"getCommentDetail", commentDTO);
	}
	
	/**
	 * 
	 * @param commentDTO (contents, sb_num)
	 * @return Insert result
	 * @throws Exception
	 * @author 설희
	 * 
	 */
	public int setCommentAdd(CommentDTO commentDTO)throws Exception{
		return session.insert(NAMESPACE+"setCommentAdd", commentDTO);
	}
	
	public int setCommentDelete(CommentDTO commentDTO)throws Exception{
		return session.delete(NAMESPACE+"setCommentDelete", commentDTO);
	}
		
	//게시글 댓글
	public List<CommentDTO> getSB_CommentList(CommentDTO commentDTO)throws Exception{
		return session.selectList(NAMESPACE+"getSB_CommentList", commentDTO);
	}
	
	public int setSB_CommentAdd(CommentDTO commentDTO)throws Exception{
		return session.insert(NAMESPACE+"setSB_CommentAdd", commentDTO);
	}
	
	public int setSB_CommentDelete(CommentDTO commentDTO)throws Exception{
		return session.delete(NAMESPACE+"setSB_CommentDelete", commentDTO);
	}
	
	public Long getComment_Count(CommentDTO commentDTO)throws Exception{
		return session.selectOne(NAMESPACE+"getComment_Count", commentDTO);
	}
	
	//강사답글 - 댓글
	public List<CommentDTO> getT_CommentList(CommentDTO commentDTO)throws Exception{
		return session.selectList(NAMESPACE+"getT_CommentList", commentDTO);
	}
	
	public int setT_CommentAdd(CommentDTO commentDTO)throws Exception{
		return session.insert(NAMESPACE+"setT_CommentAdd", commentDTO);
	}
	
	//강사답글 - 댓글 삭제 및 모든 댓글 삭제(강사답글 삭제 시)
	public int setT_CommentDelete(CommentDTO commentDTO)throws Exception{
		return session.delete(NAMESPACE+"setT_CommentDelete", commentDTO);
	}
	
	public int setAllCommentDelete(CommentDTO commentDTO)throws Exception{
		return session.delete(NAMESPACE+"setAllCommentDelete", commentDTO);
	}

}
