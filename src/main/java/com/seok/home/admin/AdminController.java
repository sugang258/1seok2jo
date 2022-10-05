package com.seok.home.admin;

import java.lang.reflect.Member;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.seok.home.cs_board.CsBoardDTO;
import com.seok.home.member.MemberDTO;
import com.seok.home.pay.PaymentDTO;

@Controller
@RequestMapping(value = "/admin/*")
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	@GetMapping(value="main")
	private String getMain() {
		return "admin/main";
	}
	
	//로그인 페이지 이동 컨트롤러
	@GetMapping(value = "login")
	private void getLogin() {
	}
	
	@GetMapping(value = "memberList")
	private String getMember() {
		return "admin/memberList";
	}
	
	@GetMapping(value = "paymentList")
	private String getPayments() {
		return "admin/paymentList";
	}
	
	@PostMapping(value = "paymentList")
	@ResponseBody
	private ModelAndView getPayments(AdminPager pager, ModelAndView mv) throws Exception{
		
		System.out.println(pager.getChkstatus());
		
		List<PaymentDTO> payList = service.getPaymentsList(pager);
		
		mv.addObject("payList", payList);
		mv.addObject("pager", pager);
		mv.setViewName("admin/paymentListPost");
		return mv;
	}
	
	@GetMapping(value = "csboardList")
	private String getCsList() {
		
		return "admin/csboardList";
	}
	
	@PostMapping(value = "csboardList")
	@ResponseBody
	private ModelAndView getCsList(AdminPager pager, ModelAndView mv) throws Exception{
		
		List<CsBoardDTO> csList = service.getCsList(pager);
		
		mv.addObject("csList", csList);
		mv.addObject("pager", pager);
		mv.setViewName("admin/csboardListPost");

		return mv;
	}
	
	@GetMapping("csAnswer")
	private ModelAndView getCsAnswer(CsBoardDTO csBoardDTO, ModelAndView mv) throws Exception{
		
		csBoardDTO = service.getCsAnswer(csBoardDTO);
		mv.addObject("csboard", csBoardDTO);
		mv.setViewName("admin/csAnswer");
		
		return mv;
	}
	
	@PostMapping("csAnswer")
	private ModelAndView setCsAnswer(CsBoardDTO csBoardDTO, HttpSession session, ModelAndView mv) throws Exception{
		MemberDTO member = (MemberDTO)session.getAttribute("member");
		
		csBoardDTO.setCs_admin(member.getId());
		
		String message = service.setCsAnswer(csBoardDTO);
		mv.addObject("message", message);
		mv.addObject("url", "/admin/csboardList");
		mv.setViewName("common/result");

		return mv;
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
	private ModelAndView getAuth(MemberDTO member, String authNum) throws Exception {
		//authNum은 "1seok2jo"로 통일
		String chkAuthNum = "1seok2jo";
		
		String message = "";
		if(chkAuthNum.equals(authNum)) {
			message = service.getAuth(member);
			
		}else {
			message = "관리자 인증번호가 맞지 않습니다.";
		}

		ModelAndView mv = new ModelAndView();
		mv.addObject("result", message);
		mv.setViewName("common/ajaxResult");
		
		return mv;
	}
	
	@PostMapping(value = "memberList")
	private String getMember(AdminPager pager) {
		
		
		return "admin/memberList";
	}

}
