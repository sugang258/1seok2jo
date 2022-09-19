package com.seok.home.s_board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudyBoardDAO {
	
	@Autowired
	private SqlSession session;
	private String NAMESPACE="com.seok.home.s_board.StudyBoardDAO.";
	
	public List<StudyBoardDTO> getBoardList()throws Exception{
		return session.selectList(NAMESPACE+"getBoardList");
	}
	
	public int setBoardAdd(StudyBoardDTO studyBoardDTO)throws Exception{
		return session.insert(NAMESPACE+"setBoardAdd", studyBoardDTO);
	}
	
}
