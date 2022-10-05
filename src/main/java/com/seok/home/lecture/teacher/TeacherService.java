package com.seok.home.lecture.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

	@Autowired
	private TeacherDAO teacherDAO;
	
	public TeacherDTO getTeacherCheck(TeacherDTO teacherDTO) throws Exception{
	    return teacherDAO.getTeacherCheck(teacherDTO);
	}
	

	
}
