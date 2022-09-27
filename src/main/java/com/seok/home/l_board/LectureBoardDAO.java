package com.seok.home.l_board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LectureBoardDAO {
	
	@Autowired
	private SqlSession session;
	private String NAMESPACE = "com.seok.home.l_board.LectureBoardDAO.";
	
	public List<LectureBoardDTO> getL_boardList(LectureBoardDTO lectureBoardDTO)throws Exception{
		System.out.println("dto"+lectureBoardDTO.getArray());
		return session.selectList(NAMESPACE+"getL_boardList", lectureBoardDTO);
	}
	
	public int setL_boardAdd(LectureBoardDTO lectureBoardDTO)throws Exception{
		return session.insert(NAMESPACE+"setL_boardAdd", lectureBoardDTO);
	}
	
	public int setL_boardDelete(LectureBoardDTO lectureBoardDTO)throws Exception{
		return session.delete(NAMESPACE+"setL_boardDelete", lectureBoardDTO);
	}
	/* 수강평 댓글 수 */ 	
	public Long getTotalCount(LectureBoardDTO lectureBoardDTO)throws Exception{
		return session.selectOne(NAMESPACE+"getTotalCount", lectureBoardDTO);
	}

}
