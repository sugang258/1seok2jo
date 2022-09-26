package com.seok.home.s_board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seok.home.b_comment.CommentDTO;
import com.seok.home.b_comment.CommentService;

@Service
public class StudyBoardService {

	@Autowired
	private StudyBoardDAO studyBoardDAO;
	
	public List<StudyBoardDTO> getBoardList(Pager pager)throws Exception{
		Long totalCount = studyBoardDAO.getTotalCount(pager);
		pager.getBlockNum(totalCount);
		pager.getRowNum();
		return studyBoardDAO.getBoardList(pager);
	}
	
	public StudyBoardDTO getBoardDetail(StudyBoardDTO studyBoardDTO)throws Exception{
		studyBoardDAO.setBoardHit(studyBoardDTO);
		return studyBoardDAO.getBoardDetail(studyBoardDTO);
	}
	
	public int setBoardAdd(StudyBoardDTO studyBoardDTO)throws Exception{
		return studyBoardDAO.setBoardAdd(studyBoardDTO);
	}
	
	public int setBoardDelete(StudyBoardDTO studyBoardDTO)throws Exception{
		return studyBoardDAO.setBoardDelete(studyBoardDTO);
	}
	
	public int setBoardUpdate(StudyBoardDTO studyBoardDTO)throws Exception{
		return studyBoardDAO.setBoardUpdate(studyBoardDTO);
	}
	
	//댓글 수 
	public Long getCount(StudyBoardDTO studyBoardDTO)throws Exception{
		return studyBoardDAO.getCount(studyBoardDTO);
	}
	

}
