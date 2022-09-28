package com.seok.home.lecture.status;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seok.home.lecture.LectureDTO;
import com.seok.home.lecture.LectureVideoDTO;

@Service
public class StatusService {
	
	@Autowired
	private StatusDAO statusDAO;
	
	public int setStatusAdd(StatusDTO statusDTO) throws Exception{
		return statusDAO.setStatusAdd(statusDTO);
	}
	
	public List<LectureVideoDTO> getVideoList(LectureDTO lectureDTO) throws Exception{
		return statusDAO.getVideoList(lectureDTO);
	}
	
	public int setStatusUpdate(StatusDTO statusDTO) throws Exception{
		return statusDAO.setStatusUpdate(statusDTO);
	}
	
	public StatusDTO getStatus(StatusDTO statusDTO) throws Exception{
		return statusDAO.getStatus(statusDTO);
	}

}
