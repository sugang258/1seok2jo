package com.seok.home.lecture.add;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.seok.home.MyAbstractTest;
import com.seok.home.lecture.LectureDTO;

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

	//@Test
	public void setLectureCount() throws Exception{
		LectureAddDTO lectureAddDTO = new LectureAddDTO();
		
		lectureAddDTO.setL_num(69L);
		int result = lectureAddDAO.setLectureCount(lectureAddDTO);
		
		assertEquals(1,result);

	}
	
	//@Test
	public void getLectureAddAll() throws Exception{
		List<LectureAddDTO> ar =lectureAddDAO.getLectureAddAll();
		
		assertNotEquals(0, ar.size());
	}
	
	//@Test
	public void getLectureSearch() throws Exception{
		LectureAddDTO lectureAddDTO = new LectureAddDTO();
		
		lectureAddDTO.setL_num(72L);
		
		List<LectureAddDTO> ar = lectureAddDAO.getLectureSearch(lectureAddDTO);
		assertNotEquals(0, ar.size());

	}
	
	//@Test
	public void setLectureDeleteAll() throws Exception{
		LectureDTO lectureDTO = new LectureDTO();
		
		lectureDTO.setL_num(73L);
		
		int result = lectureAddDAO.setLectureDeleteAll(lectureDTO);
		
		assertEquals(1,result);

	}
	
	//@Test
	public void getLectureCancel() throws Exception{
		LectureAddDTO lectureAddDTO = new LectureAddDTO();
		lectureAddDTO.setL_num(72L);
		lectureAddDTO.setId("ss");
		
		lectureAddDTO = lectureAddDAO.getLectureCancel(lectureAddDTO);
		
		assertNotNull(lectureAddDTO);

	}
	

}
