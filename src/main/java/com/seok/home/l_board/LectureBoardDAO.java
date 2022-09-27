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
	
	public List<LectureBoardDTO> getL_boardList()throws Exception{
		return session.selectList(NAMESPACE+"getL_boardList");
	}
	
	public int setL_boardAdd(LectureBoardDTO lectureBoardDTO)throws Exception{
		return session.insert(NAMESPACE+"setL_boardAdd", lectureBoardDTO);
	}

}
