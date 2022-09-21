package com.seok.home.member;

import static org.junit.Assert.*;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seok.home.MyAbstractTest;

public class MemberServiceTest extends MyAbstractTest {

	@Autowired
	private MemberService memberService;
	
	//@Test
	public void setMemberRole()throws Exception {
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

}
