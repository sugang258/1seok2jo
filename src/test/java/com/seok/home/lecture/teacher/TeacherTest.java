package com.seok.home.lecture.teacher;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.seok.home.MyAbstractTest;

public class TeacherTest extends MyAbstractTest {

	@Autowired
	private TeacherDAO teacherDAO;
	
	//@Test
	public void setTeacherAdd() throws Exception {
		TeacherDTO teacherDTO = new TeacherDTO();
		
		teacherDTO.setId("GANG");
		teacherDTO.setBank_num("43434-33433");
		teacherDTO.setBank_name("농협");
		teacherDTO.setIntroduce("안녕하세요오오오");
		
		int result = teacherDAO.setTeacherAdd(teacherDTO);
		
		assertEquals(1, result);
	}
	
	//@Test
	public void setTeacherUpdate() throws Exception {
		TeacherDTO teacherDTO = new TeacherDTO();
		
		teacherDTO.setBank_num("43434-334");
		teacherDTO.setBank_name("농");
		teacherDTO.setIntroduce("하세요오오오");
		teacherDTO.setT_num(3L);
		
		int result = teacherDAO.setTeacherUpdate(teacherDTO);
		
		assertEquals(1, result);
		
	}
	
	//@Test
	public void getTeacherDetail() throws Exception {
		TeacherDTO teacherDTO = new TeacherDTO();
		
		teacherDTO.setT_num(3L);
		teacherDTO = teacherDAO.getTeacherDetail(teacherDTO);
		
		assertNotNull(teacherDTO);
		
	}
	
	//@Test
	public void getTeacher() throws Exception {
		List<TeacherDTO> ar = teacherDAO.getTeacher();
		
		assertNotEquals(0, ar.size());
		
	}
	

}
