package com.seok.home.f_board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FreeBoardService {
	
	@Autowired
	private FreeBoardDAO freeBoardDAO;
	
	/* 자유게시판 목록조회 */
	public List<FreeBoardDTO> getF_boardList()throws Exception{
		return freeBoardDAO.getF_boardList();
	}

}
