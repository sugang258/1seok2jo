package com.seok.home.member;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.seok.home.cart.CartDTO;
import com.seok.home.cart.CartService;
import com.seok.home.lecture.LectureDTO;
import com.seok.home.lecture.LectureService;
import com.seok.home.lecture.teacher.TeacherDTO;
import com.seok.home.util.Pager;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	@Autowired
	private MemberService memberService;
	

	/************************ 회원 **************************/

	@Autowired
	private CartService cartService;
	
	
	//로그인(GET)
	@GetMapping("login")
	public String getLogin()throws Exception{
		System.out.println("로그인 접속(GET)");
		
		return "member/login";
	}
	
	//로그인(POST)
	@PostMapping("login")
	public ModelAndView getLogin(MemberDTO memberDTO, HttpSession session)throws Exception{
		System.out.println("로그인 접속(POST)");
		
		ModelAndView mv = new ModelAndView();
		
		//DB에 아이디 패스워드 확인->(아이디, 이름, 닉네임, 생년월일, 성별, 이메일, 전화번호, 마일리지, 등급번호, 등급이름 조회)
		memberDTO = memberService.getLogin(memberDTO);
		
		//세션에 memberDTO 담기(아이디, 이름, 닉네임, 생년월일, 성별, 이메일, 전화번호, 마일리지, 등급번호, 등급이름 조회)
		session.setAttribute("member", memberDTO);
		
		//로그인 성공 실패 확인
		if(memberDTO!=null) {
			System.out.println("로그인 성공!");
		}else {
			System.out.println("로그인 실패..");
		}
		
		mv.setViewName("member/login");
		
		return mv;
	}
	
	//로그아웃(GET)
	@GetMapping("logout")
	public String setLogout(HttpSession session)throws Exception{
		System.out.println("로그아웃 접속(GET)");
		
		//세션 삭제
		session.invalidate();
		
		return "redirect:../";
	}
	
	//회원가입(GET)
	@GetMapping("join")
	public String setJoin()throws Exception{
		System.out.println("회원가입 접속(GET)");
		
		return "member/join";
	}
	
	//회원가입(POST)
	@PostMapping
	public String setJoin(MemberDTO memberDTO, HttpSession session)throws Exception{
		System.out.println("회원가입 접속(POST)");
		
		//DB에 새로운 회원데이터추가
		int result = memberService.setJoin(memberDTO);
		
		//새로운 회원데이터추가 성공 실패 확인
		if(result>0) {
			System.out.println("회원가입 성공!");
		}else {
			System.out.println("회원가입 실패..");
		}
		
		return "member/join";
	}
	
	//강사신청(GET)
	@GetMapping("teacherAdd")
	public void setTeacherAdd()throws Exception{
		System.out.println("강사신청 접속(GET)");
	}
	
	//강사신청(POST)
	@PostMapping("teacherAdd")
	public String setTeacherAdd(TeacherDTO teacherDTO, HttpSession session)throws Exception{
		System.out.println("강사신청 접속(POST)");
		
		//DB에 새로운 강사데이터추가
		int result = memberService.setTeacherAdd(teacherDTO, session.getServletContext());
		
		//새로운 강사데이터추가 성공 실패 확인
		if(result>0) {
			System.out.println("강사신청 성공!");
		}else {
			System.out.println("강사신청 실패..");
		}

		return "member/teacherAdd";
	}
	
	/************************ 마이페이지 **************************/
	
	//프로필정보조회(GET)
	@GetMapping("profile")
	public String getProfile()throws Exception {
		System.out.println("프로필 정보(GET)");
		
		return "member/profile";
	}
	
	//프로필정보조회(POST)
	@PostMapping("profile")
	public ModelAndView getProfile(MemberDTO memberDTO, HttpSession session)throws Exception {
		System.out.println("프로필 정보(POST)");
		ModelAndView mv = new ModelAndView();
//		MemberDTO memberDTO2 = new MemberDTO();
//	 	memberDTO2 = (MemberDTO)session.getAttribute("member");
//		System.out.println(memberDTO2.getPw());
		
		
		MemberDTO respMemberDTO = memberService.getProfile(memberDTO);
//		int result = memberService.setProfile(memberDTO, profile, session.getServletContext());
//		
//		//session.setAttribute("member", memberDTO);
//		
//		String message = "프로필수정 실패";
//		String url = "./profile";
//		if(result>0) {
//			message = "프로필수정 성공";
//			url = "./profile";
//		}
//		
//		mv.addObject("result", result);
//		mv.addObject("message", message);
//		mv.addObject("url", url);
//		mv.setViewName("common/result");
		mv.addObject("dto", respMemberDTO);
		mv.setViewName("member/profile");
		
		return mv;
	}
	
//	//프로필수정(GET)
//	@GetMapping("profile")
//	public void setProfile()throws Exception{
//		System.out.println("프로필 수정(GET)");
//	}
//	
//	//프로필수정(POST)
//	@PostMapping("profile")
//	public ModelAndView setProfile(MemberDTO memberDTO, HttpSession session, MultipartFile profile)throws Exception{
//		System.out.println("프로필 수정(POST)");
//		
//		ModelAndView mv = new ModelAndView();
//		
//		int result = memberService.setProfile(memberDTO, profile, session.getServletContext());
//		
//		mv.setViewName("member/profile");
//		
//		return mv;
//	}
	
	//장바구니(GET)
	@RequestMapping(value="cart", method=RequestMethod.GET)
	public ModelAndView getCartList(CartDTO cartDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		cartDTO.setId("gang");
		List<LectureDTO> ar = cartService.getCartDetail(cartDTO);
		
		System.out.println(ar.size());
		
		mv.addObject("lectureDTO", ar);
		mv.setViewName("/member/cart");
		
		return mv;
	
	}
	
}
