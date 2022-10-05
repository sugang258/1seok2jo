package com.seok.home.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.seok.home.admin.AdminPager;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.seok.home.member.MemberDAO.";
	
	/************************ 회원 **************************/
	
	//관리자 페이지 회원목록 출력
	public List<MemberDTO> getAdminMemberList(AdminPager adminPager) throws Exception{
		return sqlSession.selectList(NAMESPACE+"getAdminMemberList", adminPager);
	}
	
	//회원로그인
	public MemberDTO getLogin(MemberDTO memberDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getLogin", memberDTO);
	}
	
	//아이디중복 확인
	public int getIdCheck(MemberDTO memberDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getIdCheck", memberDTO);
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
	
	/************************ 회원탈퇴 **************************/
	//회원등급삭제
	public int setDeleteMemberRole(MemberDTO memberDTO)throws Exception{
		return sqlSession.delete(NAMESPACE+"setDeleteMemberRole", memberDTO);
	}
	
	//회원탈퇴
	public int setDeleteJoin(MemberDTO memberDTO)throws Exception{
		return sqlSession.delete(NAMESPACE+"setDeleteJoin", memberDTO);
	}
	
	/************************ 마이페이지 **************************/
	
	//프로필정보조회 화면
	public MemberDTO getProfile(MemberDTO memberDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getProfile", memberDTO);
	}
	
	//프로필정보 수정
	public int setEditProfile(MemberDTO memberDTO)throws Exception{	
		return sqlSession.update(NAMESPACE+"setEditProfile", memberDTO);
	}
	
	//프로필사진 추가
	public int setAddFile(MemberFileDTO memberFileDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setAddFile", memberFileDTO);
	}
	
	//프로필사진 삭제
	public int setDeleteFile(MemberFileDTO memberFileDTO)throws Exception{
		return sqlSession.delete(NAMESPACE+"setDeleteFile", memberFileDTO);
	}
}
