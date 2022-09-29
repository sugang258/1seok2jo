package com.seok.home.lecture.add;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LectureAddService {

	@Autowired
	private LectureAddDAO lectureAddDAO;
	
	public int setLectureAdd(LectureAddDTO lectureAddDTO) throws Exception{
		return lectureAddDAO.setLectureAdd(lectureAddDTO);
	}
	
	public LectureAddDTO getLectureAdd(LectureAddDTO lectureAddDTO) throws Exception{
		return lectureAddDAO.getLectureAdd(lectureAddDTO);
	}
	
	public int setLectureAddDelete(LectureAddDTO lectureAddDTO) throws Exception{
		return lectureAddDAO.setLectureAddDelete(lectureAddDTO);
	}
	
	public int setLectureCount(LectureAddDTO lectureAddDTO) throws Exception{
		return lectureAddDAO.setLectureCount(lectureAddDTO);
	}
}
