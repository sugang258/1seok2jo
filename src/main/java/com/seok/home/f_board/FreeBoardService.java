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
	/* 자유게시판 글작성 */
	public int setF_boardAdd(FreeBoardDTO freeBoardDTO)throws Exception{
		return freeBoardDAO.setF_boardAdd(freeBoardDTO);
	}
	/* 자유게시판 글 상세보기 */
	public FreeBoardDTO getF_boardDetail(FreeBoardDTO freeBoardDTO)throws Exception{
		return freeBoardDAO.getF_boardDetail(freeBoardDTO);
	}
	/* 자유게시판 글 수정 */
	public int setF_boardUpdate(FreeBoardDTO freeBoardDTO)throws Exception{
		return freeBoardDAO.setF_boardUpdate(freeBoardDTO);
	}

}
