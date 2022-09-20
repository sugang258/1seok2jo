package com.seok.home.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.seok.home.MyAbstractTest;

public class MemberDAOTest extends MyAbstractTest {

	@Autowired
	private MemberDAO memberDAO;
	
	//@Test
	public void setJoinTest()throws Exception{
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("hyo");
		memberDTO.setPw("123");
		memberDTO.setName("효경");
		memberDTO.setN_name("갱");
		memberDTO.setB_date(19990823L);
		memberDTO.setGender("여자");
		memberDTO.setEmail("hyo@naver.com");
		memberDTO.setPhone("010-2222-2222");
//		memberDTO.setPoint(0L);
		
		System.out.println(memberDTO.getB_date());
		int result  = memberDAO.setJoin(memberDTO);
		
		assertEquals(1, result);
		
	}
	
	//@Test
	public void getLoginTest()throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("koo");
		memberDTO.setPw("123");
		memberDTO = memberDAO.getLogin(memberDTO);
		
		assertNotNull(memberDTO);
		
	}

}
