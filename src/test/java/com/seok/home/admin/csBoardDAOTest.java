package com.seok.home.admin;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.seok.home.MyAbstractTest;
import com.seok.home.cs_board.CsBoardDTO;
import com.seok.home.cs_board.CsDAO;

public class csBoardDAOTest extends MyAbstractTest{

	@Autowired
	private CsDAO dao;
	
	@Test
	public void setBoardAddtest() throws Exception {
		CsBoardDTO boardDTO = new CsBoardDTO();
		
		for(int i=0; i<100; i++) {
			boardDTO.setCs_title("제목"+i);
			boardDTO.setCs_contents("<br>내용"+i+"<br>내용"+i+"<br>내용"+i+"<br>내용"+i);
			boardDTO.setId("yj");
			boardDTO.setCs_email("simyj12@naver.com");
			boardDTO.setCs_phone("010-7777-8888");
			
			int result = dao.setBoardAdd(boardDTO);
			assertEquals(1,result);
		}
	}

}
