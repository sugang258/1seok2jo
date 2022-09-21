package com.seok.home.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.seok.home.member.MemberDTO;

@Controller
@RequestMapping(value = "/admin/*")
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	//로그인 페이지 이동 컨트롤러
	@GetMapping(value = "login")
	private void getLogin() {
	}
	
	@PostMapping
	private void getLogin(MemberDTO member, HttpServletRequest request) throws Exception {
		//아이디와 비밀번호를 체크한 뒤 admin 자격이 있으면 세션의 admin값에 true로 돌려준다.
		boolean chk = service.getLogin(member);
		
		HttpSession session = request.getSession();
		
		if(chk==true) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		session.setAttribute("admin", chk);
		
	}
	
	
	@PostMapping(value = "auth")
	@ResponseBody
	private int getAuth(String id, String pw, String authNum) {
		System.out.println("관리자 인증 컨트롤러"+authNum+id+pw);
		
		return 1;
	}

}
