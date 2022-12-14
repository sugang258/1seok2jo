package com.seok.home.s_board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.seok.home.b_comment.CommentDTO;

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
	
	/* 게시판 파일 등록 */
	public int setBoardFile(BoardFileDTO boardFileDTO)throws Exception{
		return session.insert(NAMESPACE+"setBoardFile", boardFileDTO);
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
	
	//댓글 수
	public Long getCount(StudyBoardDTO studyBoardDTO)throws Exception{
		return session.selectOne(NAMESPACE+"getCount", studyBoardDTO);
	}	
	
	//답변상태
	public int setAnsewer(StudyBoardDTO studyBoardDTO)throws Exception{
		return session.update(NAMESPACE+"setAnsewer", studyBoardDTO);
	}
	
	public int setAnsewerDefault(StudyBoardDTO studyBoardDTO)throws Exception{
		return session.update(NAMESPACE+"setAnsewerDefault", studyBoardDTO);
	}
	
	public List<StudyBoardDTO> getMyBoardList(StudyBoardDTO studyBoardDTO) throws Exception{
	    return session.selectList(NAMESPACE+"getMyBoardList", studyBoardDTO);
	}
	
}
