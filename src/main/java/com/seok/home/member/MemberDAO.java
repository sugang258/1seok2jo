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
	
	//프로필정보조회
	public MemberDTO getProfile(MemberDTO memberDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getProfile", memberDTO);
	}
	
	//프로필수정
	public int setEditProfile(MemberDTO memberDTO)throws Exception{	
		return sqlSession.update(NAMESPACE+"setProfile", memberDTO);
	}
	
	//프로필사진업로드
	public int setAddFile(MemberFileDTO memberFileDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setAddFile", memberFileDTO);
	}
	
}
