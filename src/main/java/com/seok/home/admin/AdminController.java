package com.seok.home.admin;

import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonArray;
import com.seok.home.cs_board.CsBoardDTO;
import com.seok.home.f_board.FreeBoardDTO;
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
	
	//대시보드
	@GetMapping("getDashBoard")
	@ResponseBody
	private HashMap<String, Object> getDashBoard() throws Exception{
		HashMap<String, Object> result = service.getAdminDashBoard();
		
		return result;
	}
	
	//로그인 페이지 이동 컨트롤러
	@GetMapping(value = "login")
	private void getLogin() {
	}
	
	@GetMapping(value = "boardsList")
	private String getBoards() {
		return "admin/boardsList";
	}
	
	@PostMapping(value = "boardsList")
	@ResponseBody
	private ModelAndView getBoards(AdminPager pager, ModelAndView mv) throws Exception{

		mv.addObject("boardsList", service.getBoardsList(pager));
		mv.addObject("pager", pager);
		mv.setViewName("admin/boardListPost");
		
		return mv;
	}
	
	@GetMapping(value = "lectureList")
	private String getLecture() {
		return "admin/lectureList";
	}
	
	@PostMapping(value = "lectureList")
	@ResponseBody
	private ModelAndView getLecture(AdminPager pager, ModelAndView mv) throws Exception{
		
		mv.addObject("lectureList", service.getLectureList(pager));
		mv.addObject("pager", pager);
		mv.setViewName("admin/lectureListPost");
		
		return mv;
	}
	
	@GetMapping(value = "memberList")
	private String getMember() {
		return "admin/memberList";
	}
	@PostMapping(value = "memberList")
	@ResponseBody
	private ModelAndView getMember(AdminPager pager, ModelAndView mv) throws Exception{
		List<MemberDTO> members = service.getMember(pager);
		
		mv.addObject("memberList", members);
		mv.addObject("pager", pager);
		mv.setViewName("admin/memberListPost");
		
		return mv;
	}
	
	@GetMapping(value = "paymentList")
	private String getPayments() {
		return "admin/paymentList";
	}
	
	@PostMapping(value = "paymentList")
	@ResponseBody
	private ModelAndView getPayments(AdminPager pager, ModelAndView mv) throws Exception{
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
	
	@PostMapping("login")
	private String getLogin(String remember, MemberDTO member, HttpServletRequest request,HttpServletResponse response) throws Exception {
		//아이디 쿠키에 저장
		member = service.getLogin(member);
		//체크박스가 null이 아니면 쿠키에 아이디 저장
		if(remember!=null) {
			Cookie cookie = new Cookie("rememberid", request.getParameter("id"));
			cookie.setMaxAge(60*60*24*7);//쿠키 유효시간 설정 일주일
			cookie.setPath("/admin");
			response.addCookie(cookie);
		//체크박스가 null이면 쿠키 삭제
		}else {
			Cookie[] cookies = request.getCookies();
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("rememberid")) {
					cookie.setMaxAge(0);
					cookie.setPath("/admin"); 
					response.addCookie(cookie);
				}
			}
		}
		HttpSession session = request.getSession();
		
		
		//아이디와 비밀번호를 체크한 뒤 admin 자격이 있으면 세션의 admin값에 true로 돌려준다.
		String url = "";
		boolean chk = false;
		if(member!=null) {
			chk = true;
			session.setAttribute("member", member);
			session.setAttribute("admin", chk);
			url = "redirect: /admin/main";
		}else {
			url = "redirect: /admin/login";
		}

		return url;
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
	
	@PostMapping(value="delBoardAdmin")
	@ResponseBody
	private int delBoardAdmin(FreeBoardDTO dto)throws Exception{
		
		int result = service.delBoardAdmin(dto);
		return 0;
	}
	


}
