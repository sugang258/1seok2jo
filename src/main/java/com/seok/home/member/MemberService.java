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

	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private TeacherDAO teacherDAO;
	@Autowired
	private CartDAO cartDAO;
	
	public int setTeacherAdd(TeacherDTO teacherDTO, ServletContext servletContext)throws Exception{
		return teacherDAO.setTeacherAdd(teacherDTO);
	}
	
	public int setJoin(MemberDTO memberDTO, ServletContext servletContext)throws Exception{
		return memberDAO.setJoin(memberDTO);
	}
	
	public MemberDTO getLogin(MemberDTO memberDTO)throws Exception{
		return memberDAO.getLogin(memberDTO);
	}
	
	public List<CartDTO> getCartList(CartDTO cartDTO) throws Exception {
		return cartDAO.getCartList(cartDTO);
	}
	
	
}
