package com.seok.home.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin/*")
public class AdminController {
	
	//로그인 페이지 이동 컨트롤러
	@GetMapping(value = "login")
	private void getLogin() {
		System.out.println("로그인 컨트롤러");
	}

}
