package com.seok.home.lecture.status;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.seok.home.MyAbstractTest;
import com.seok.home.lecture.LectureDTO;
import com.seok.home.lecture.LectureVideoDTO;

public class StatusTest extends MyAbstractTest{
	
	@Autowired
	private StatusDAO statusDAO;

	//@Test
	public void setStatusAdd() throws Exception{
		StatusDTO statusDTO = new StatusDTO();
		
		statusDTO.setV_num(129L);
		statusDTO.setS_num(9L);
		
		int result = statusDAO.setStatusAdd(statusDTO);
		
		assertEquals(1,result);

	}
	
	//@Test
	public void getVideoList() throws Exception{
		LectureDTO lectureDTO = new LectureDTO();
		
		lectureDTO.setL_num(73L);
		
		List<LectureVideoDTO> ar = statusDAO.getVideoList(lectureDTO);
		
		assertNotEquals(0, ar.size());

	}
}
