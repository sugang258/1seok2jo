package com.seok.home.f_board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FreeBoardDAO {
	
	@Autowired
	private SqlSession session;
	private String NAMESPCE="com.seok.home.f_board.FreeBoardDAO.";
	
	/* 자유게시판 목록조회 */
	public List<FreeBoardDTO> getF_boardList()throws Exception{
		return session.selectList(NAMESPCE+"getF_boardList");
	}

}
