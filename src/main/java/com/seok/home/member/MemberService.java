package com.seok.home.member;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seok.home.cart.CartDAO;
import com.seok.home.cart.CartDTO;
import com.seok.home.lecture.teacher.TeacherDAO;
import com.seok.home.lecture.teacher.TeacherDTO;

@Service
public class MemberService {

	//회원
	@Autowired
	private MemberDAO memberDAO;
	//강사
	@Autowired
	private TeacherDAO teacherDAO;
	//장바구니
	@Autowired
	private CartDAO cartDAO;
	
	/************************ 회원 **************************/
	
	//회원로그인
	public MemberDTO getLogin(MemberDTO memberDTO)throws Exception{
		return memberDAO.getLogin(memberDTO);
	}
	
	//회원가입
	public int setJoin(MemberDTO memberDTO)throws Exception{
		//MemberDAO에 멤버등급 인서트 메서드를 만들어서 실행
		int susess = memberDAO.setJoin(memberDTO);
		int result = 0;
		if(susess == 1 ) {
			result = memberDAO.setMemberRole(memberDTO);
		}
		
		return result;	
	}
	
	//강사신청
	public int setTeacherAdd(TeacherDTO teacherDTO, ServletContext servletContext)throws Exception{
		return teacherDAO.setTeacherAdd(teacherDTO);
	}
	
	/************************ 마이페이지 **************************/
	
	//프로필수정
	public int setProfile(MemberDTO memberDTO)throws Exception{
		return memberDAO.setProfile(memberDTO);
	}
	
	//장바구니
	public List<CartDTO> getCartList(CartDTO cartDTO) throws Exception {
		return cartDAO.getCartList(cartDTO);
	}
	
	
}
