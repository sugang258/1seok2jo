package com.seok.home.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.seok.home.lecture.teacher.TeacherDTO;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	//강사 회원가입
	@GetMapping("teacherAdd")
	public void setTeacherAdd()throws Exception{
		System.out.println("강사 회원가입 접속(GET)");
	}
	
	//강사 회원가입
	@PostMapping("teacherAdd")
	public void setTeacherAdd(TeacherDTO teacherDTO, HttpSession session)throws Exception{
		System.out.println("강사 회원가입 접속(POST)");
		
		int result = memberService.setTeacherAdd(teacherDTO, session.getServletContext());
		if(result>0) {
			System.out.println("강사신청 성공!");
		}else {
			System.out.println("강사신청 실패..");
		}

	}
	
	//회원가입
	@GetMapping("join")
	public void setJoin()throws Exception{
		System.out.println("회원가입 접속(GET)");
	}
	
	//회원가입 폼
	@PostMapping
	public void setJoin(MemberDTO memberDTO, HttpSession session)throws Exception{
		System.out.println("회원가입 접속(POST)");
		
		int result = memberService.setJoin(memberDTO, session.getServletContext());
		if(result>0) {
			System.out.println("회원가입 성공!");
		}else {
			System.out.println("회원가입 실패..");
		}
	}
	
	//로그인
	@GetMapping("login")
	public String getLogin()throws Exception{
		System.out.println("로그인 접속(GET)");
		return "member/login";
	}
	
	//로그인
	@PostMapping("login")
	public String getLogin(MemberDTO memberDTO)throws Exception{
		System.out.println("로그인 접속(POST)");
		return "member/login";
	}
	
	@RequestMapping(value="cart", method=RequestMethod.GET)
	public String getCartList() throws Exception{
		
		return "member/cart";
	}
	
	
	
}
