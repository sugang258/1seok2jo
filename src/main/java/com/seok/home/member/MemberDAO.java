package com.seok.home.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.seok.home.member.MemberDAO.";
	
	//회원가입
	public int setJoin(MemberDTO memberDTO)throws Exception{
		System.out.println(memberDTO.getB_date());
		return sqlSession.insert(NAMESPACE+"setJoin", memberDTO);
	}
	
	//회원로그인
	public MemberDTO getLogin(MemberDTO memberDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getLogin", memberDTO);
	}
	
}
