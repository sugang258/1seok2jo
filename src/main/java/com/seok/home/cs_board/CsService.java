package com.seok.home.cs_board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CsService {
	
	@Autowired
	private CsDAO csDAO;
	
	public int setBoardAdd(CsBoardDTO csBoardDTO) throws Exception{
		return csDAO.setBoardAdd(csBoardDTO);
	}
	
	public List<CsBoardDTO> getMylist(CsBoardDTO csBoardDTO) throws Exception{
		return csDAO.getMylist(csBoardDTO);
	}

}
