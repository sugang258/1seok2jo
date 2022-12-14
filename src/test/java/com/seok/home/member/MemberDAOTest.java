package com.seok.home.member;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.seok.home.MyAbstractTest;
import com.seok.home.admin.AdminPager;

public class MemberDAOTest extends MyAbstractTest {

	@Autowired
	private MemberDAO memberDAO;
	
//	@Test
	public void getPointTest() throws Exception{
		MemberDTO dto = new MemberDTO();
		dto.setId("yj");
		
		Long result = memberDAO.getPoint(dto);
		System.out.println(result);
	}
	
//	@Test
	public void updatePointTest() throws Exception{
		MemberDTO dto = new MemberDTO();
		dto.setId("yj");
		dto.setPoint(-2000L);
		int result = memberDAO.updatePoint(dto);
		
		assertEquals(1, result);
	}
	
//	@Test
	public void setDeleteTeacherAllTest() throws Exception{
		MemberDTO dto = new MemberDTO();
		dto.setId("yj");
		
		int result = memberDAO.setDeleteTeacherAll(dto);
		
		assertEquals(1, result);
	}
	
//	@Test
	public void getAdminMemberListTest() throws Exception{
		AdminPager pager = new AdminPager();
		List<MemberDTO> memlist = memberDAO.getAdminMemberList(pager);
		
		for(MemberDTO mem:memlist) {
			System.out.println(mem.getId());
			for(RoleDTO r:mem.getRoleDTOs()) {
				System.out.println(r.getRoleName());
			}
		}
		assertNotNull(memlist);
	}
	
	//@Test
	public void getIdCheckTest()throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("hyo");
		int result = memberDAO.getIdCheck(memberDTO);
		
		assertEquals(1, result);
	}
	
	//@Test
	public void getNnameCheckTest()throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setN_name("효효");
		int result = memberDAO.getNnameCheck(memberDTO);
		
		assertEquals(1, result);
	}
	
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
	
	//@Test
	public void setEditProfileTest()throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("koo");
		memberDTO.setN_name("9");
		memberDTO.setGender("여자");
		memberDTO.setEmail("koo@naver.com");
		memberDTO.setPhone("010-1111-1111");
		int result = memberDAO.setEditProfile(memberDTO);
		
		assertEquals(1, result);
	}
	
	//@Test
	public void getPwCheckTest()throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("koo");
		
		memberDTO = memberDAO.getPwCheck(memberDTO);
		
		assertNotNull(memberDTO);
	}
	
	//@Test
	public void setUpdatePwTest()throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("koo");
		memberDTO.setPw("koo");
		
		int result = memberDAO.setUpdatePw(memberDTO);
		
		assertEquals(1, result);
		
	}
	
	//@Test
	public void getProfileTest()throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("koo");
//		MemberFileDTO memberFileDTO = new MemberFileDTO();
//		memberFileDTO.setNum(1L);
//		memberFileDTO.setF_name("ㅎㅎ");
		
		memberDTO = memberDAO.getProfile(memberDTO);
		
		assertNotNull(memberDTO);
	}

	//@Test
	public void setDeleteMemberRole()throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("hyo");
		
		int result = memberDAO.setDeleteMemberRole(memberDTO);
		
		assertNotEquals(0, result);
	}
	
//	@Test
	public void setAddFileTest()throws Exception{
		MemberFileDTO memberFileDTO = new MemberFileDTO();
		memberFileDTO.setF_name("haha");
		memberFileDTO.setF_oriname("ha");
		int result = memberDAO.setAddFile(memberFileDTO);
		assertEquals(1, result);
	}
	
}
