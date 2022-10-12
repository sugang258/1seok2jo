package com.seok.home.cs_board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.seok.home.admin.AdminPager;

@Repository
public class CsDAO {
	
	@Autowired
	private SqlSession session;
	private String NAMESPACE="com.seok.home.cs_board.CsDAO.";
	
	public Long getNotAnswerCnt() throws Exception{
		return session.selectOne(NAMESPACE+"getNotAnswerCnt");
	}
	
	public int setBoardDelete(CsBoardDTO boardDTO) throws Exception{
		return session.delete(NAMESPACE+"setBoardDelete", boardDTO);
	}
	
	public int setBoardUpdate(CsBoardDTO boardDTO) throws Exception{
		return session.update(NAMESPACE+"setBoardUpdate", boardDTO);
	}
	
	public int setBoardAdd(CsBoardDTO boardDTO) throws Exception{
		return session.insert(NAMESPACE+"setBoardAdd", boardDTO);
	}
	
	public List<CsBoardDTO> getMylist(CsBoardDTO csBoardDTO) throws Exception{
		return session.selectList(NAMESPACE+"getMylist", csBoardDTO);
	}
	
	public int setAnswerDefault(CsBoardDTO csBoardDTO) throws Exception{
		return session.update(NAMESPACE+"setAnswerDefault", csBoardDTO);
	}
	
	public Long getTotalCount(AdminPager pager) throws Exception{
		return session.selectOne(NAMESPACE+"getTotalCount", pager);
	}
	
	public List<CsBoardDTO> getBoardList(AdminPager pager) throws Exception{
		return session.selectList(NAMESPACE+"getBoardList", pager);
	}
	
	public CsBoardDTO getBoardDetail(CsBoardDTO csBoardDTO) throws Exception{
		return session.selectOne(NAMESPACE+"getBoardDetail", csBoardDTO);
	}

}
