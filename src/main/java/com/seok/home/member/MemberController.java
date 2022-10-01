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
	
	
	//로그인 화면(GET)
	@GetMapping("login")
	public String getLogin()throws Exception{
		System.out.println("로그인 접속(GET)");
		
		return "member/login";
	}
	
	//로그인 로직 처리(POST)
	@PostMapping("login")
	public ModelAndView getLogin(MemberDTO memberDTO, HttpSession session)throws Exception{
		System.out.println("로그인 접속(POST)");
		
		ModelAndView mv = new ModelAndView();
		
		//DB에 아이디 패스워드 확인->(아이디, 이름, 닉네임, 성별, 이메일, 전화번호, 마일리지, 등급번호, 등급이름 조회)
		memberDTO = memberService.getLogin(memberDTO);
		
		
		//로그인 성공 실패 확인
		if(memberDTO!=null) {
			System.out.println("로그인 성공!!");
			//세션에 memberDTO 담기(아이디, 이름, 닉네임, 성별, 이메일, 전화번호, 마일리지, 등급번호, 등급이름 조회)
			session.setAttribute("member", memberDTO);
			mv.setViewName("redirect:../");
		}else {
			System.out.println("로그인 실패..");
			mv.setViewName("member/login");		
		}
		
		
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
	
	//회원가입 화면(GET)
	@GetMapping("join")
	public String setJoin()throws Exception{
		System.out.println("회원가입 접속(GET)");
		
		return "member/join";
	}
	
	//회원가입 로직 처리(POST)
	@PostMapping
	public String setJoin(MemberDTO memberDTO, HttpSession session)throws Exception{
		System.out.println("회원가입 접속(POST)");
		
		//DB에 새로운 회원데이터추가
		int result = memberService.setJoin(memberDTO);
		
		//새로운 회원데이터추가 성공 실패 확인
		if(result>0) {
			System.out.println("회원가입 성공!!");
			return "redirect:member/login";
		}else {
			System.out.println("회원가입 실패..");
			return "member/join";
		}
	
	}
	
	//강사신청 화면(GET)
	@GetMapping("teacherAdd")
	public void setTeacherAdd()throws Exception{
		System.out.println("강사신청 접속(GET)");
	}
	
	//강사신청 로직 처리(POST)
	@PostMapping("teacherAdd")
	public String setTeacherAdd(TeacherDTO teacherDTO, HttpSession session)throws Exception{
		System.out.println("강사신청 접속(POST)");
		
		//DB에 새로운 강사데이터추가
		int result = memberService.setTeacherAdd(teacherDTO, session.getServletContext());
		
		//새로운 강사데이터추가 성공 실패 확인
		if(result>0) {
			System.out.println("강사신청 성공!!");
		}else {
			System.out.println("강사신청 실패..");
		}

		return "member/teacherAdd";
	}
	
	/************************ 마이페이지 **************************/
	
	//프로필정보조회 화면(GET)
	@GetMapping("profile")
	public ModelAndView getProfile(HttpSession session)throws Exception {
		System.out.println("프로필 정보(GET)");
		
		ModelAndView mv = new ModelAndView();
		MemberDTO memberDTO = new MemberDTO();
		//세션정보(아이디, 이름, 닉네임, 성별, 이메일, 전화번호, 마일리지, 등급번호, 등급이름 조회)를 꺼내서
		//memberDTO에 담음
		memberDTO = (MemberDTO) session.getAttribute("member");
		System.out.println("get에 session.memberDTO.닉네임 : "+memberDTO.getN_name());
		
		//프로필정보조회(아이디, 이름, 닉네임, *생년월일,* 성별, 이메일, 연락처 조회)
		//getProfile을 갔다온 memberDTO를 respMemberDTO(responseMemberDTO)에 담음
		MemberDTO respMemberDTO = memberService.getProfile(memberDTO);
		
		//그 데이터를 "member"로 JSP에 보내줌
		mv.addObject("member", respMemberDTO);
		mv.setViewName("member/profile");
		
		return mv;
	}
	
	//프로필 내 정보 수정 로직 처리(POST)
	@PostMapping("profile")
	public ModelAndView getProfile(MemberDTO memberDTO, HttpSession session, MultipartFile profile)throws Exception {
		System.out.println("프로필 정보(POST)");
//		MemberDTO memberDTO2 = new MemberDTO();
//	 	memberDTO2 = (MemberDTO)session.getAttribute("member");
//		System.out.println(memberDTO2.getPw());
		ModelAndView mv = new ModelAndView();
		
		System.out.println(profile);
		System.out.println("upload 파일명 : "+profile.getOriginalFilename());
		System.out.println("upload 파라미터명 : "+profile.getName());
		System.out.println("upload 파일 크기 : "+profile.getSize());
		
		//구효입니당
		System.out.println("수정 전 memberDTO.닉네임 : "+memberDTO.getN_name());
		int result = memberService.setEditProfile(memberDTO, profile, session.getServletContext());
		
		//구효입니당
		System.out.println("수정 후 memberDTO.닉네임 : "+memberDTO.getN_name());
		
		//memberService.getProfile(memberDTO);
		
		if(result > 0) {
			System.out.println("프로필 수정 성공!!");
//			session.setAttribute("member", memberDTO);
			mv.addObject("member", memberDTO);
			//mv.addObject("memberFile", memberDTO.getMemberFileDTO());
			mv.setViewName("redirect:./profile");
		}else {
			System.out.println("프로필 수정 실패..");
			mv.setViewName("member/profile");
		}
		
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
		
		return mv;
	}
	
	//장바구니 화면(GET)
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
