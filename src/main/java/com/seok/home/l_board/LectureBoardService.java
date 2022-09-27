package com.seok.home.l_board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LectureBoardService {
	
	@Autowired
	private LectureBoardDAO lectureBoardDAO;
	
	public List<LectureBoardDTO> getL_boardList()throws Exception{
		return lectureBoardDAO.getL_boardList();
	}
	
	public int setL_boardAdd(LectureBoardDTO lectureBoardDTO)throws Exception{
		return lectureBoardDAO.setL_boardAdd(lectureBoardDTO);
	}

}
