package com.seok.home.member;

import static org.junit.Assert.*;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seok.home.MyAbstractTest;
import com.seok.home.lecture.teacher.TeacherDTO;

public class MemberServiceTest extends MyAbstractTest {

	@Autowired
	private MemberService memberService;
	
	//회원가입시 회원등급설정이 들어가나 테스트
	//@Test
	public void setJoinTest()throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("hyo");
		memberDTO.setPw("123");
		memberDTO.setName("효경");
		memberDTO.setN_name("갱");
		memberDTO.setB_date(19990823L);
		memberDTO.setGender("여자");
		memberDTO.setEmail("hyo@naver.com");
		memberDTO.setPhone("010-2222-2222");
		int result = memberService.setJoin(memberDTO);
		
		assertEquals(1, result);
	}

	//강사신청시 강사등급설정이 들어가나 테스트
	//@Test
	public void setTeacherAddTest()throws Exception{
		TeacherDTO teacherDTO = new TeacherDTO();
		teacherDTO.setId("koo");
		teacherDTO.setBank_num("1111-1111");
		teacherDTO.setBank_name("신한은행");
		teacherDTO.setIntroduce("반갑습니다");
		//int result = memberService.setTeacherAdd(teacherDTO);
		
		//assertEquals(1, result);
	}
	
	//회원탈퇴시 회원등급설정이 지워지고 회원도 탈퇴되는지 확인
	//@Test
	public void setDeleteMemberTest()throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("hyo");
		
		int result = memberService.setDeleteMember(memberDTO);
		
		assertNotEquals(0, result);
	}
	
}
