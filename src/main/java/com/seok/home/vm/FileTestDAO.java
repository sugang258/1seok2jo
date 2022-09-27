package com.seok.home.vm;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FileTestDAO {
	
	@Autowired
	private SqlSession session;
	private final String NAMESPACE = "com.seok.home.vm.FileTestDAO.";
	
	public int setBoardAdd(TestBoardDTO studyBoardDTO)throws Exception{
		return session.insert(NAMESPACE+"setBoardAdd", studyBoardDTO);
	}
	
	public int setFileAdd(TestFileDTO dto)throws Exception{
		return session.insert(NAMESPACE+"setFileAdd", dto);
	}
	
	public TestBoardDTO getBoardDetail(TestBoardDTO dto)throws Exception{
		return session.selectOne(NAMESPACE+"getBoardDetail", dto);
	}
}
