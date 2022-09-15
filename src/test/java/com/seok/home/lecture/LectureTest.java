package com.seok.home.lecture;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.seok.home.MyAbstractTest;

public class LectureTest extends MyAbstractTest {
	
	@Autowired
	private LectureDAO lectureDAO;

	@Test
	public void setLecture() throws Exception{
		LectureDTO lectureDTO = new LectureDTO();
		
		lectureDTO.setId("ID2");
		lectureDTO.setLevel_num(1L);
		lectureDTO.setL_name("JJ");
		lectureDTO.setL_contents("JJ");
		lectureDTO.setL_price(10000L);
		lectureDTO.setL_date(30L);
		
		int result = lectureDAO.setLecture(lectureDTO);
		
		assertEquals(1,result);
	}
	
	//@Test
	public void getLecture() throws Exception{
		//LectureDTO lectureDTO = new LectureDTO();
		
		List<LectureDTO> ar = lectureDAO.getLecture();
		
		assertNotEquals(0, ar.size());
	}
	
	//@Test
	public void setUpdate() throws Exception {
		LectureDTO lectureDTO = new LectureDTO();
		
		lectureDTO.setLevel_num(2L);
		lectureDTO.setL_name("dd");
		lectureDTO.setL_contents("dd");
		lectureDTO.setC_num(2L);
		lectureDTO.setL_price(20000L);
		lectureDTO.setL_date(20L);
		
		lectureDTO.setL_num(2L);
		
		int result = lectureDAO.setUpdate(lectureDTO);
		
		assertEquals(1,result);
		
	}
	
	//@Test
	public void setDelete() throws Exception{
		LectureDTO lectureDTO = new LectureDTO();
		
		lectureDTO.setL_num(3L);
		
		int result = lectureDAO.setDelete(lectureDTO);
		
		assertEquals(1, result);
	}
	
	
	

}
