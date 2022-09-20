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
	
	/************************ 회원 **************************/
	
	//강사신청(GET)
	@GetMapping("teacherAdd")
	public void setTeacherAdd()throws Exception{
		System.out.println("강사신청 접속(GET)");
	}
	
	//강사신청(POST)
	@PostMapping("teacherAdd")
	public void setTeacherAdd(TeacherDTO teacherDTO, HttpSession session)throws Exception{
		System.out.println("강사신청 접속(POST)");
		
		int result = memberService.setTeacherAdd(teacherDTO, session.getServletContext());
		if(result>0) {
			System.out.println("강사신청 성공!");
		}else {
			System.out.println("강사신청 실패..");
		}

	}
	
	//로그인(GET)
	@GetMapping("login")
	public String getLogin()throws Exception{
		System.out.println("로그인 접속(GET)");
		return "member/login";
	}
	
	//로그인(POST)
	@PostMapping("login")
	public String getLogin(MemberDTO memberDTO, HttpSession session)throws Exception{
		System.out.println("로그인 접속(POST)");
		memberDTO = memberService.getLogin(memberDTO);
		session.setAttribute("member", memberDTO);
		return "member/login";
	}
	
	//로그아웃(GET)
	@GetMapping("logout")
	public String setLogout(HttpSession session)throws Exception{
		System.out.println("로그아웃 접속(GET)");
		
		session.invalidate();
		
		return "redirect:../";
	}
	
	//회원가입(GET)
	@GetMapping("join")
	public void setJoin()throws Exception{
		System.out.println("회원가입 접속(GET)");
	}
	
	//회원가입(POST)
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
	
	//장바구니(GET)
	@RequestMapping(value="cart", method=RequestMethod.GET)
	public String getCartList() throws Exception{
		
		return "member/cart";
	}
	
	/************************ 마이페이지 **************************/
	
	//프로필
	@GetMapping("profile")
	public String setProfile()throws Exception {
		System.out.println("프로필 접속(GET)");
		
		return "member/profile";
	}
	
}
