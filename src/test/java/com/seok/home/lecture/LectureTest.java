package com.seok.home.lecture;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.seok.home.MyAbstractTest;
import com.seok.home.cart.CartDTO;
import com.seok.home.util.Pager;

public class LectureTest extends MyAbstractTest {
	
	@Autowired
	private LectureDAO lectureDAO;

	//@Test
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
	public void getLecture(Pager pager) throws Exception{
		//LectureDTO lectureDTO = new LectureDTO();
		
		List<LectureDTO> ar = lectureDAO.getLecture(pager);
		
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
	
	//@Test
	public void setAddFile() throws Exception {
		LectureFileDTO lectureFileDTO = new LectureFileDTO();
		
		lectureFileDTO.setL_num(1L);
		lectureFileDTO.setF_name("gang");
		lectureFileDTO.setF_oriname("ganggang");
		
		int result = lectureDAO.setAddFile(lectureFileDTO);
		assertEquals(1, result);

	}
	
	//@Test
	public void getDetail() throws Exception {
		LectureDTO lectureDTO = new LectureDTO();
		
		lectureDTO.setL_num(2L);
		
		lectureDTO = lectureDAO.getDetail(lectureDTO);
		
		assertNotNull(lectureDTO);
		
	}
	
	//@Test
	public void setVideoAdd() throws Exception {
		LectureVideoDTO lectureVideoDTO = new LectureVideoDTO();
		
		lectureVideoDTO.setL_num(2L);
		lectureVideoDTO.setV_url("https://www.youtube.com/watch?v=oXB1FcMkusU");
		lectureVideoDTO.setV_context("빙글빙글");
		
		int result = lectureDAO.setAddVideo(lectureVideoDTO);
		
		assertEquals(1, result);
		
	}
	
	//@Test
	public void getCartDetail() throws Exception {
		CartDTO cartDTO = new CartDTO();
		
		cartDTO.setId("gang");
		
		List<LectureDTO> ar = lectureDAO.getCartDetail(cartDTO);
		
		assertNotEquals(0, ar.size());
			
	}
	
	//@Test
	public void setVideoDelete() throws Exception {
		LectureVideoDTO lectureVideoDTO = new LectureVideoDTO();
		
		lectureVideoDTO.setV_num(101L);
		
		int result = lectureDAO.setVideoDelete(lectureVideoDTO);
		
		assertEquals(1, result);
		
	}
	
	//@Test
	public void setFileUpdate() throws Exception {
		LectureFileDTO lectureFileDTO = new LectureFileDTO();
		
		lectureFileDTO.setNum(52L);
		lectureFileDTO.setF_name("gang");
		lectureFileDTO.setF_oriname("gang");
		
		int result = lectureDAO.setFileUpdate(lectureFileDTO);
		
		assertEquals(1, result);
	}
	
	//@Test
	public void getFileDetail() throws Exception {
		LectureFileDTO lectureFileDTO = new LectureFileDTO();
		
		lectureFileDTO.setNum(52L);
		
		lectureFileDTO = lectureDAO.getFileDetail(lectureFileDTO);
		
		assertNotNull(lectureFileDTO);

		
	}
	
	//@Test
	public void setVideoUpdate() throws Exception {
		LectureVideoDTO lectureVideoDTO = new LectureVideoDTO();
		
		lectureVideoDTO.setV_num(120L);
		lectureVideoDTO.setV_url("HI");
		lectureVideoDTO.setV_context("HIII");
		
		int result = lectureDAO.setVideoUpdate(lectureVideoDTO);

		assertEquals(1, result);
		
	}
	
	//@Test
	public void setVideoStatus() throws Exception{
		LectureVideoDTO lectureVideoDTO = new LectureVideoDTO();
		
		lectureVideoDTO.setV_num(116L);
		
		int result = lectureDAO.setVideoStatus(lectureVideoDTO);
		
		assertEquals(1, result);
	}
	
	//@Test
	public void getVideoStatusCount() throws Exception{
		LectureVideoDTO lectureVideoDTO = new LectureVideoDTO();
		
		lectureVideoDTO.setL_num(72L);
		
		long result = lectureDAO.getVideoStatusCount(lectureVideoDTO);
		
		assertEquals(0L, result);
	}
	
	//@Test
	public void getVideoStatus() throws Exception{
		LectureDTO lectureDTO = new LectureDTO();
		
		lectureDTO.setL_num(72L);
		
		List<LectureDTO> ar = lectureDAO.getVideoStatus(lectureDTO);
		
		assertNotEquals(1, ar.size());
	}
	
	//@Test
	public void getListCount() throws Exception{
		LectureDTO lectureDTO = new LectureDTO();
		
		lectureDTO.setL_num(72L);
		
		long result = lectureDAO.getListCount(lectureDTO);
		
		assertEquals(6L, result);


	}
	
	//@Test
	public void getLecturePre() throws Exception{
		LectureVideoDTO lectureVideoDTO = new LectureVideoDTO();
		LectureDTO lectureDTO = new LectureDTO();
		lectureVideoDTO.setL_num(72L);
		lectureVideoDTO.setV_seq(6L);
		
		lectureDTO = lectureDAO.getLecturePre(lectureVideoDTO);
		
		assertNotNull(lectureDTO);
	}
	
	//@Test
	public void getVideoList() throws Exception{
		LectureVideoDTO lectureVideoDTO = new LectureVideoDTO();
		lectureVideoDTO.setL_num(72L);
		lectureVideoDTO.setV_seq(5L);
		
		lectureVideoDTO = lectureDAO.getVideoList(lectureVideoDTO);
		
		assertNotNull(lectureVideoDTO);

		
	}
}
