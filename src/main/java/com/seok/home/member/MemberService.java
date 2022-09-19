package com.seok.home.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seok.home.lecture.teacher.TeacherDAO;
import com.seok.home.lecture.teacher.TeacherDTO;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private TeacherDAO teacherDAO;
	
	public int setTeacherAdd(TeacherDTO teacherDTO)throws Exception{
		return teacherDAO.setTeacherAdd(teacherDTO);
	}
	
}
