package com.seok.home.cs_board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CsDAO {
	
	@Autowired
	private SqlSession session;
	private String NAMESPACE="com.seok.home.cs_board.CsDAO.";
	
	public int setBoardAdd(CsBoardDTO boardDTO) throws Exception{
		return session.insert(NAMESPACE+"setBoardAdd", boardDTO);
	}
	
	public List<CsBoardDTO> getMylist(CsBoardDTO csBoardDTO) throws Exception{
		return session.selectList(NAMESPACE+"getMylist", csBoardDTO);
	}
	
	public int setAnswerDefault(CsBoardDTO csBoardDTO) throws Exception{
		return session.update(NAMESPACE+"setAnswerDefault", csBoardDTO);
	}

}
