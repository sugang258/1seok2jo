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
	
	public List<StudyBoardDTO> getBoardList(Pager pager)throws Exception{
		return session.selectList(NAMESPACE+"getBoardList", pager);
	}
	
	public Long getTotalCount(Pager pager)throws Exception{
		return session.selectOne(NAMESPACE+"getTotalCount", pager);
	}
	
	public StudyBoardDTO getBoardDetail(StudyBoardDTO studyBoardDTO)throws Exception{
		return session.selectOne(NAMESPACE+"getBoardDetail", studyBoardDTO);
	}
	
	public int setBoardAdd(StudyBoardDTO studyBoardDTO)throws Exception{
		return session.insert(NAMESPACE+"setBoardAdd", studyBoardDTO);
	}
	
	public int setBoardDelete(StudyBoardDTO studyBoardDTO)throws Exception{
		return session.delete(NAMESPACE+"setBoardDelete", studyBoardDTO);
	}
	
	public int setBoardUpdate(StudyBoardDTO studyBoardDTO)throws Exception{
		return session.update(NAMESPACE+"setBoardUpdate", studyBoardDTO);
	}
	
	public int setBoardHit(StudyBoardDTO studyBoardDTO)throws Exception{
		return session.update(NAMESPACE+"setBoardHit", studyBoardDTO);
	}
	
}
