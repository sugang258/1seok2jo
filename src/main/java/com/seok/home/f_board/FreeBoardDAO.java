package com.seok.home.f_board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.seok.home.b_comment.FreeBoardReplyDTO;

@Repository
public class FreeBoardDAO {
	
	@Autowired
	private SqlSession session;
	private String NAMESPCE="com.seok.home.f_board.FreeBoardDAO.";
	
	/* 자유게시판 목록조회 */
	public List<FreeBoardDTO> getF_boardList()throws Exception{
		return session.selectList(NAMESPCE+"getF_boardList");
	}
	/* 자유게시판 글작성 */
	public int setF_boardAdd(FreeBoardDTO freeBoardDTO)throws Exception{
		return session.insert(NAMESPCE+"setF_boardAdd", freeBoardDTO);
	}
	/* 자유게시판 글 상세보기 */
	public FreeBoardDTO getF_boardDetail(FreeBoardDTO freeBoardDTO)throws Exception{
		return session.selectOne(NAMESPCE+"getF_boardDetail", freeBoardDTO);
	}
	/* 자유게시판 글 수정 */
	public int setF_boardUpdate(FreeBoardDTO freeBoardDTO)throws Exception{
		return session.update(NAMESPCE+"setF_boardUpdate", freeBoardDTO);
	}
	/* 자유게시판 글 삭제 */
	public int setF_boardDelete(FreeBoardDTO freeBoardDTO)throws Exception{
		return session.delete(NAMESPCE+"setF_boardDelete", freeBoardDTO);
	}
	
	/* 자유게시판 댓글리스트 */
	public List<FreeBoardReplyDTO> getFb_replyList(FreeBoardReplyDTO freeBoardReplyDTO)throws Exception{
		return session.selectList(NAMESPCE+"getFb_replyList", freeBoardReplyDTO);
	}

}
