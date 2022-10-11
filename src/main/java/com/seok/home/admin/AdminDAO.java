package com.seok.home.admin;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.seok.home.f_board.FreeBoardDTO;
import com.seok.home.member.MemberDTO;

@Repository
public class AdminDAO {
	
	private final String NAMESPACE = "com.seok.home.admin.AdminDAO.";
	@Autowired
	private SqlSession session;
	
	public Long getTotalBoardList(AdminPager pager) throws Exception{
		return session.selectOne(NAMESPACE+"getTotalBoardList", pager);
	}
	
	public List<FreeBoardDTO> getBoardList(AdminPager pager) throws Exception{
		return session.selectList(NAMESPACE+"getBoardList", pager);
	}
	
	public Long getBoardCnt() throws Exception{
		return session.selectOne(NAMESPACE+"getBoardCnt");
	}
}
