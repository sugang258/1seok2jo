package com.seok.home.board;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.seok.home.MyAbstractTest;
import com.seok.home.n_board.NoticeDAO;
import com.seok.home.n_board.NoticeDTO;

public class NoticeTest extends MyAbstractTest{
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	//@Test
	public void setNoticeAdd()throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setContents("ggggg");
		noticeDTO.setHit(0L);
		noticeDTO.setId("관리자");
		noticeDTO.setTitle("제목이요");
		
		int resurt = noticeDAO.setNoticeAdd(noticeDTO);
		
		assertEquals(1, resurt);
	}

}
