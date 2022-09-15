package com.seok.home.lecture;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LectureService {

	@Autowired
	private LectureDAO lectureDAO;
	
	public List<LectureDTO> getLecture() throws Exception {
		
		return lectureDAO.getLecture();
	}
	
	public int setLecture(LectureDTO lectureDTO) throws Exception {
		return lectureDAO.setLecture(lectureDTO);
	}
	
	
}
