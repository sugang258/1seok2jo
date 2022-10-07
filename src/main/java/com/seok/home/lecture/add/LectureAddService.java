package com.seok.home.lecture.add;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seok.home.lecture.LectureDTO;

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
	
	public List<LectureAddDTO> getLectureAddAll() throws Exception{
		return lectureAddDAO.getLectureAddAll();
	}
	
	public List<LectureAddDTO> getLectureSearch(LectureAddDTO lectureAddDTO) throws Exception{
		return lectureAddDAO.getLectureSearch(lectureAddDTO);
	}
	
	public int setLectureDeleteAll(LectureDTO lectureDTO) throws Exception{
		return lectureAddDAO.setLectureDeleteAll(lectureDTO);
	}
	public LectureAddDTO getLectureCancel(LectureAddDTO lectureAddDTO) throws Exception{
		return lectureAddDAO.getLectureCancel(lectureAddDTO);
	}
	public List<LectureAddDTO> getLectureEnd(LectureAddDTO lectureAddDTO) throws Exception{
	    return lectureAddDAO.getLectureEnd(lectureAddDTO);
	}
	public int setLectureUpdate(LectureAddDTO lectureAddDTO) throws Exception{
	    return lectureAddDAO.setLectureUpdate(lectureAddDTO);
	}
	
	public int setLectureCountM(LectureAddDTO lectureAddDTO) throws Exception{
	    return lectureAddDAO.setLectureCountM(lectureAddDTO);
	}
}
