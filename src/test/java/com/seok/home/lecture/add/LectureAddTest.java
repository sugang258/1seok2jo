package com.seok.home.lecture.add;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.seok.home.MyAbstractTest;

public class LectureAddTest extends MyAbstractTest {
	
	@Autowired
	private LectureAddDAO lectureAddDAO;

	//@Test
	public void setLectureAdd() throws Exception {
		LectureAddDTO lectureAddDTO = new LectureAddDTO();
		lectureAddDTO.setL_num(1L);
		lectureAddDTO.setId("gang");
		
		
		int result = lectureAddDAO.setLectureAdd(lectureAddDTO);
		assertEquals(1,result);
	}
	
	//@Test
	public void setLectureDelete() throws Exception{
		LectureAddDTO lectureAddDTO = new LectureAddDTO();
		
		lectureAddDTO.setS_num(1L);
		
		int result = lectureAddDAO.setLectureDelete(lectureAddDTO);
		assertEquals(1,result);
	}
	
	//@Test
	public void setLectureUpdate() throws Exception {
		LectureAddDTO lectureAddDTO = new LectureAddDTO();
		lectureAddDTO.setS_num(4L);
		
		
		int result = lectureAddDAO.setLectureUpdate(lectureAddDTO);
		assertEquals(1,result);
	}
	
	//@Test
	public void setLectureAddDelete() throws Exception{
		LectureAddDTO lectureAddDTO = new LectureAddDTO();
		
		lectureAddDTO.setS_num(22L);
		
		int result = lectureAddDAO.setLectureAddDelete(lectureAddDTO);
		
		assertEquals(1,result);

	}
	
	

}
