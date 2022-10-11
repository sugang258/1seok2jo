package com.seok.home.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.seok.home.cart.CartDTO;
import com.seok.home.cart.CartService;
import com.seok.home.lecture.LectureDTO;
import com.seok.home.lecture.teacher.TeacherDTO;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	@Autowired
	private MemberService memberService;
	

	/************************ 회원 **************************/

	@Autowired
	private CartService cartService;
	
	@GetMapping("test")
	public String test()throws Exception{
		return "member/test";
	}
	
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
			System.out.println("Role : "+memberDTO.getRoleDTOs().get(0).getRoleName());
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
	
	//아이디중복 확인 로직 처리 (POST)
	@ResponseBody
	@PostMapping("idCheck")
	public int getIdCheck(MemberDTO memberDTO)throws Exception{
		int result = memberService.getIdCheck(memberDTO);
		return result;
	}
	
	//회원가입 화면(GET)
	@GetMapping("join")
	public String setJoin()throws Exception{
		System.out.println("회원가입 접속(GET)");
		
		return "member/join";
	}
	
	//회원가입 로직 처리(POST)
	@PostMapping
	public String setJoin(MemberDTO memberDTO, HttpSession session, String yy, String mm, String dd, String e, String mail)throws Exception{
		System.out.println("회원가입 접속(POST)");
		
		//int result = memberService.getIdCheck(memberDTO);
		
		//DB에 새로운 회원데이터추가
		int result = memberService.setJoin(memberDTO, yy, mm, dd, e, mail);
		
		//새로운 회원데이터추가 성공 실패 확인
		if(result>0) {
			System.out.println("회원가입 성공!!");
			return "redirect:../member/login";
		}else {
			System.out.println("회원가입 실패..");
			return "member/join";
		}
	
	}
	
	//강사신청 화면(GET)
	@GetMapping("teacherAdd")
	public String setTeacherAdd()throws Exception{
		System.out.println("강사신청 접속(GET)");
		
		return "member/teacherAdd";
	}
	
	//강사신청 로직 처리(POST)
	@PostMapping("teacherAdd")
	public String setTeacherAdd(TeacherDTO teacherDTO, HttpSession session)throws Exception{
		System.out.println("강사신청 접속(POST)");
		
		//세션에 있는 한 회원정보를 memberDTO에 담음
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		System.out.println("강사신청POST : "+memberDTO);
		
		//DB에 새로운 강사데이터추가
		int result = memberService.setTeacherAdd(teacherDTO, session.getServletContext(), memberDTO);
		
		//새로운 강사데이터추가 성공 실패 확인
		if(result>0) {
			System.out.println("강사신청 성공!!");
		}else {
			System.out.println("강사신청 실패..");
		}

		return "member/teacherAdd";
	}
	
	//회원탈퇴 화면(GET)
	@GetMapping("deleteMember")
	public String setDeleteMember()throws Exception{
		System.out.println("회원탈퇴 접속(GET)");
		return "member/deleteMember";
	}
	
	//회원탈퇴 로직 처리(POST)
	@PostMapping("deleteMember")
	public String setDeleteMember(MemberDTO memberDTO, HttpSession session)throws Exception{
		System.out.println("회원탈퇴 접속(POST)");
		
		//DB에 있는 회원정보(등급까지)를 삭제
		int result = memberService.setDeleteMember(memberDTO);
		
		//회원탈퇴 성공 실패 확인
		if(result!=0) {
			System.out.println("회원탈퇴 성공!!");
			//세션삭제
			session.invalidate();
		}else {
			System.out.println("회원탈퇴 실패..");
		}
		
		return "member/deleteMember";
	}
	
	//비밀번호 확인 로직 처리 (POST)
//	@ResponseBody
//	@PostMapping("pwCheck")
//	public MemberDTO getPwCheck(MemberDTO memberDTO)throws Exception{
//		memberDTO = memberService.getIdCheck(memberDTO);
//		return memberDTO;
//	}
	
	/************************ 마이페이지 **************************/
	
	//회원프로필정보조회 화면(GET)
	@GetMapping("profile")
	public ModelAndView getProfile(HttpSession session, MemberDTO memberDTO)throws Exception {
		System.out.println("프로필 정보(GET)");
		
		ModelAndView mv = new ModelAndView();
		MemberDTO respMemberDTO = new MemberDTO();
		
		if(memberDTO.getId()!=null) {
			if((Boolean)session.getAttribute("admin")) {
				respMemberDTO = memberService.getProfile(memberDTO);
			}
		}else {
		
		//세션정보(아이디, 이름, 닉네임, 성별, 이메일, 전화번호, 마일리지, 등급번호, 등급이름 조회)를 꺼내서
		//memberDTO에 담음
		memberDTO = (MemberDTO) session.getAttribute("member");
		
		
		//프로필정보조회(아이디, 이름, 닉네임, *생년월일*, 성별, 이메일, 연락처 조회)
		//getProfile을 갔다온 memberDTO를 respMemberDTO(responseMemberDTO)에 담음
		respMemberDTO = memberService.getProfile(memberDTO);
//		System.out.println("file : "+respMemberDTO.getMemberFileDTO().getNum());
//		System.out.println("file : "+respMemberDTO.getMemberFileDTO().getF_name());
//		System.out.println("file : "+respMemberDTO.getMemberFileDTO().getF_oriname());
		}
		
		//그 데이터를 "member"로 JSP에 보내줌
		mv.addObject("member", respMemberDTO);
		mv.setViewName("member/profile");
		return mv;
	}
	
	//회원프로필 내 정보 수정 로직 처리(POST)
	@PostMapping("profile")
	@ResponseBody
	public ModelAndView setProfile(MemberDTO memberDTO, HttpSession session, String f_name, String f_oriname)throws Exception {
		System.out.println("프로필 정보(POST)");
		ModelAndView mv = new ModelAndView();
		
		System.out.println("fileDTO F_NAME : "+f_name);
		System.out.println("fileDTO F_ORINAME : "+f_oriname);		
		
		MemberDTO memberDTO2 = new MemberDTO();
		
		memberDTO2 = (MemberDTO) session.getAttribute("member");
		System.out.println("memberDTO2 : "+memberDTO2.getMemberFileDTO());
		
		
		MemberFileDTO file = new MemberFileDTO();
		file.setF_name(f_name);
		file.setF_oriname(f_oriname);
		
		int result = memberService.setEditProfile(memberDTO, file, session.getServletContext());
		
		if(result != 0) {
			System.out.println("프로필 수정 성공!!");

			//프로필정보조회(아이디, 이름, 닉네임, *생년월일,* 성별, 이메일, 연락처 조회)
			//getProfile을 갔다온 memberDTO를 respMemberDTO(responseMemberDTO)에 담음
			MemberDTO respMemberDTO = memberService.getProfile(memberDTO);
			
			//그 데이터를 "member"로 JSP에 보내줌
			mv.addObject("member", respMemberDTO);
			mv.setViewName("redirect:../member/profile");
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
	
	//프로필사진 삭제(GET)
	@GetMapping("deleteFile")
	public void setDeleteFile()throws Exception{
		System.out.println("프로필사진 삭제 접속(GET)");
		memberService.setDeleteFile(null);
		
	}
	
	//프로필 회원비밀번호 수정 화면(GET)
	@GetMapping("updatePw")
	public String setUpdatePw()throws Exception{
		System.out.println("프로필 회원비밀번호 수정(GET)");
		
		return "member/updatePw";
	}
	
	//프로필 회원비밀번호 확인 로직(POST)
	@ResponseBody
	@PostMapping("pwCheck")
	public String getPwCheck(MemberDTO memberDTO, String now_pw, String new_pw)throws Exception{
		System.out.println("프로필 회원비밀번호 확인(POST)");
		ModelAndView mv = new ModelAndView();
		System.out.println("현재 비밀번호 : "+now_pw);
		System.out.println("새 비밀번호 : "+new_pw);
		
		String respPw = memberService.getPwCheck(memberDTO);
		
		return respPw;
	}
	
	//프로필 회원비밀번호 수정 로직(POST)
	@PostMapping("updatePw")
	public void setUpdatePw(MemberDTO memberDTO, HttpSession session)throws Exception{
		
	}
	
	//강사프로필 정보조회 화면(GET)
	@GetMapping("tcherProfile")
	public ModelAndView getTcherProfile(HttpSession session, TeacherDTO teacherDTO)throws Exception{
		System.out.println("강사프로필 정보(GET)");
		ModelAndView mv = new ModelAndView();
		//어드민 확인
		if(teacherDTO.getId()!=null) {
			if((Boolean)session.getAttribute("admin")) {
				teacherDTO = memberService.getTcherProfile(teacherDTO);
			}
		}else {
		//세션에서 아이디를 꺼냅니다
		MemberDTO memberDTO = new MemberDTO();
		memberDTO = (MemberDTO) session.getAttribute("member");
		//꺼낸 아이디를 teacherDTO에 담습니다
		teacherDTO.setId(memberDTO.getId());
		//DB에 갔다온 teacherDTO에는 신청번호, 계좌번호, 은행이름, 소개글이 있습니다.
		teacherDTO = memberService.getTcherProfile(teacherDTO);
		}
		mv.addObject("teacher", teacherDTO);
		mv.setViewName("member/tcherProfile");
		
		return mv;
	}
	
	//강사프로필 정보수정 로직(POST)
	@PostMapping("tcherProfile")
	public ModelAndView setTcherProfile(TeacherDTO teacherDTO, HttpSession session)throws Exception{
		System.out.println("강사프로필 정보(POST)");
		ModelAndView mv = new ModelAndView();
		
		int result = memberService.setEditTcherProfile(teacherDTO);

		if(result!=0) {
			System.out.println("강사프로필 수정 성공!!");
			//바뀐 강사정보를 조회(계좌번호, 은행이름, 소개글)
			teacherDTO = memberService.getTcherProfile(teacherDTO);
			//teacher로 JSP에 보내줌
			mv.addObject("teacher", teacherDTO);
			mv.setViewName("redirect:../member/tcherProfile");
		}else {
			System.out.println("강사프로필 수정 실패..");
			mv.setViewName("member/tcherProfile");
		}
		
		
		return mv;
	}
	
	//장바구니 화면(GET)
	@RequestMapping(value="cart", method=RequestMethod.GET)
	public ModelAndView getCartList(CartDTO cartDTO,HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
	    MemberDTO mem = (MemberDTO)request.getSession().getAttribute("member");

		cartDTO.setId(mem.getId());
		List<LectureDTO> ar = cartService.getCartDetail(cartDTO);
		
		System.out.println("ararararar:"+ar.size());
		
		mv.addObject("lectureDTO", ar);
		mv.setViewName("/member/cart");
		
		return mv;
	
	}
	
}
