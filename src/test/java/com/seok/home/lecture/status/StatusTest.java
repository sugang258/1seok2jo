package com.seok.home.lecture.status;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.seok.home.MyAbstractTest;
import com.seok.home.lecture.LectureDTO;
import com.seok.home.lecture.LectureVideoDTO;
import com.seok.home.lecture.add.LectureAddDTO;

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
	
	//@Test
	public void setStatusUpdate() throws Exception{
		StatusDTO statusDTO = new StatusDTO();
		
		statusDTO.setNum(1L);
		
		int result = statusDAO.setStatusUpdate(statusDTO);
		
		assertEquals(1,result);

	}
	
	//@Test
//	public void getStatus() throws Exception{
//		StatusDTO statusDTO = new StatusDTO();
//		statusDTO.setS_num(19L);
//		statusDTO.setV_num(125L);
//		
//		List<StatusDTO> ar = statusDAO.getStatus(statusDTO);
//		
//		assertNotNull(ar);
//
//	}
	
	//@Test
	public void getSignList() throws Exception{
		LectureAddDTO lectureAddDTO = new LectureAddDTO();
		
		lectureAddDTO.setId("gg");
		
		List<LectureDTO> ar = statusDAO.getSignList(lectureAddDTO);
		
		assertNotEquals(0, ar.size());
	}
	
	//@Test
//	public void getStatusCount() throws Exception{
//		LectureAddDTO lectureAddDTO = new LectureAddDTO();
//		lectureAddDTO.setId("gg");
//		lectureAddDTO.setS_num(20L);
//		
//		long result = statusDAO.getStatusCount(lectureAddDTO);
//		
//		assertNotEquals(0L, result);
//	}
	
	//@Test
//	public void getStatusTotal() throws Exception{
//		LectureAddDTO lectureAddDTO = new LectureAddDTO();
//		
//		lectureAddDTO.setId("gg");
//		lectureAddDTO.setS_num(20L);
//		
//		long result= statusDAO.getStatusTotal(lectureAddDTO);
//		
//		assertNotEquals(0L, result);
//	}
	
	//@Test
	public void setStatusDelete() throws Exception{
		StatusDTO statusDTO = new StatusDTO();
		
		statusDTO.setS_num(9L);
		
		int result = statusDAO.setStatusDelete(statusDTO);
		
		assertEquals(1,result);

	}
}
