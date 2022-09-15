package com.seok.home.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/admin/*")
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	//로그인 페이지 이동 컨트롤러
	@GetMapping(value = "login")
	private void getLogin() {
		
	}
	
	
	@PostMapping(value = "auth")
	@ResponseBody
	private int getAuth(String id, String pw, String authNum) {
		System.out.println("관리자 인증 컨트롤러"+authNum+id+pw);
		
		return 1;
	}

}
