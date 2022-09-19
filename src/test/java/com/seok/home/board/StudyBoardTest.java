package com.seok.home.board;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.seok.home.MyAbstractTest;
import com.seok.home.s_board.StudyBoardDAO;
import com.seok.home.s_board.StudyBoardDTO;

public class StudyBoardTest extends MyAbstractTest{
	
	@Autowired
	private StudyBoardDAO studyBoardDAO;
	
	//@Test
	public void getBoardList()throws Exception{
		List<StudyBoardDTO> ar = studyBoardDAO.getBoardList();
		
		assertEquals(1, ar.size());
	}
	
	//@Test
	public void setBoardAdd()throws Exception{
		StudyBoardDTO studyBoardDTO = new StudyBoardDTO();
		 studyBoardDTO.setL_num(2L); 
		 studyBoardDTO.setId("USER2");
		 studyBoardDTO.setTitle("또 질문합니다.");
		 studyBoardDTO.setAnswer(0);
		 studyBoardDTO.setHit(0L);
		 studyBoardDTO.setContents("ㅠ ㅠㅠㅠ 아무것도 모르겠어요...........");
		 studyBoardDTO.setCategory("CSS");
		 
		 int result = studyBoardDAO.setBoardAdd(studyBoardDTO);
		 
		 assertEquals(1, result);
	}
	
	//@Test
	public void getBoardDetail()throws Exception{
		StudyBoardDTO studyBoardDTO = new StudyBoardDTO();
		studyBoardDTO.setSb_num(321L);
		
		studyBoardDTO = studyBoardDAO.getBoardDetail(studyBoardDTO);
		
		assertNotNull(studyBoardDTO);
	}

}
