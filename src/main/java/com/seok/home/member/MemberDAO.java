package com.seok.home.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.seok.home.member.MemberDAO.";
	
	/************************ 회원 **************************/
	
	//회원로그인
	public MemberDTO getLogin(MemberDTO memberDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getLogin", memberDTO);
	}
	
	//회원가입
	public int setJoin(MemberDTO memberDTO)throws Exception{
		System.out.println(memberDTO.getB_date());
		return sqlSession.insert(NAMESPACE+"setJoin", memberDTO);
	}
	
	//회원등급설정
	public int setMemberRole(MemberDTO memberDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setMemberRole", memberDTO);
	}
	
	//어드민등급설정
	public int setAdminRole(MemberDTO memberDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setAdminRole", memberDTO);
	}
	
	/************************ 마이페이지 **************************/
	
	//프로필수정
	public int setProfile(MemberDTO memberDTO)throws Exception{	
		return sqlSession.update(NAMESPACE+"setProfile", memberDTO);
	}
	
}
