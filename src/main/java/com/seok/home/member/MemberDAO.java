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
	
	/************************ 마일리지 **************************/
	
	//마일리지 가져오기
	public Long getPoint(MemberDTO dto) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getPoint", dto);
	}
	
	//전달받은 포인트를 계산해서 업데이트 하기
	public int updatePoint(MemberDTO dto) throws Exception{
		Long point = this.getPoint(dto) + dto.getPoint();
		if(point<0) {
			return 0;
		}else {
			dto.setPoint(point);
			return sqlSession.update(NAMESPACE+"updatePoint", dto);
		}
		
	}
	
	/************************ 회원 **************************/
	
	//관리자 페이지 회원목록 출력
	public List<MemberDTO> getAdminMemberList(AdminPager adminPager) throws Exception{
		return sqlSession.selectList(NAMESPACE+"getAdminMemberList", adminPager);
	}
	
	public Long getAdminMemberTotal(AdminPager adminPager) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getAdminMemberTotal", adminPager);
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
	
	//강사권한삭제
	public int setDeleteTeacherAll(MemberDTO dto) throws Exception{
		int result = 1;
		result = result * this.setDeleteTeacher(dto);
		result = result *this.setDeleteTeacherRole(dto);
		
		return result;
	}
	
	private int setDeleteTeacher(MemberDTO dto) throws Exception{
		return sqlSession.delete(NAMESPACE+"setDeleteTeacher", dto);
	}
	
	private int setDeleteTeacherRole(MemberDTO dto) throws Exception{
		return sqlSession.delete(NAMESPACE+"setDeleteTeacherRole", dto);
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
	
	//프로필사진 삭제
	public int setDeleteFile(MemberFileDTO memberFileDTO)throws Exception{
		return sqlSession.delete(NAMESPACE+"setDeleteFile", memberFileDTO);
	}
	
	//프로필 회원비밀번호 확인
	public MemberDTO getPwCheck(MemberDTO memberDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getPwCheck", memberDTO);
	}
	
	//프로필 회원비밀번호 수정
	public int setUpdatePw(MemberDTO memberDTO)throws Exception{
		return sqlSession.update(NAMESPACE+"setUpdatePw", memberDTO);
	}
	
	//프로필사진 추가
	public int setAddFile(MemberFileDTO memberFileDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setAddFile", memberFileDTO);
	}
}
