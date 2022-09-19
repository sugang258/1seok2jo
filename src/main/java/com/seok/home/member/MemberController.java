package com.seok.home.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	//강사 회원가입
	@GetMapping("t_join")
	public void setTjoin()throws Exception{
		System.out.println("강사 회원가입 접속(GET)");
	}
	
	//회원가입
	@GetMapping("join")
	public void setJoin()throws Exception{
		System.out.println("회원가입 접속(GET)");
	}
	
	//회원가입 폼
	@PostMapping
	public void setJoin(MemberDTO memberDTO)throws Exception{
		System.out.println("회원가입 접속(POST)");
	}
	
	//로그인
	@GetMapping("login")
	public String getLogin()throws Exception{
		return "member/login";
	}
	
}
