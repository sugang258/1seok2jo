package com.seok.home.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	//회원가입
	@GetMapping("join")
	public void setJoin()throws Exception{
		System.out.println("회원가입 접속");
	}
	
	//로그인
	@GetMapping("login")
	public String getLogin()throws Exception{
		return "member/login";
	}
}
