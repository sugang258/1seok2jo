package com.seok.home.l_board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LectureBoardService {
	
	@Autowired
	private LectureBoardDAO lectureBoardDAO;
	
	public List<LectureBoardDTO> getL_boardList(LectureBoardDTO lectureBoardDTO)throws Exception{
		System.out.println("service"+lectureBoardDTO.getArray());
		return lectureBoardDAO.getL_boardList(lectureBoardDTO);
	}
	
	public int setL_boardAdd(LectureBoardDTO lectureBoardDTO)throws Exception{
		return lectureBoardDAO.setL_boardAdd(lectureBoardDTO);
	}
	
	public int setL_boardDelete(LectureBoardDTO lectureBoardDTO)throws Exception{
		return lectureBoardDAO.setL_boardDelete(lectureBoardDTO);
	}
	/* 수강평 댓글 수 */ 
	public Long getTotalCount(LectureBoardDTO lectureBoardDTO)throws Exception{
		return lectureBoardDAO.getTotalCount(lectureBoardDTO);
	}

}
