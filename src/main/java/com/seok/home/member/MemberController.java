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
import com.seok.home.f_board.FreeBoardDTO;
import com.seok.home.f_board.FreeBoardService;
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
	
	@Autowired
	private FreeBoardService freeBoardService;
	
	@GetMapping("test")
	public String test()throws Exception{
		return "member/test";
	}
	
	//로그인 화면(GET)
	@GetMapping("login")
	public String getLogin()throws Exception{
		
		return "member/login";
	}
	
	//로그인 로직 처리(POST)
	@PostMapping("login")
	public ModelAndView getLogin(MemberDTO memberDTO, HttpSession session)throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		//DB에 아이디 패스워드 확인->(아이디, 이름, 닉네임, 성별, 이메일, 전화번호, 마일리지, 등급번호, 등급이름 조회)
		memberDTO = memberService.getLogin(memberDTO);
		
		//로그인 성공 실패 확인
		if(memberDTO!=null) {
			//세션에 memberDTO 담기(아이디, 이름, 닉네임, 성별, 이메일, 전화번호, 마일리지, 등급번호, 등급이름 조회)
			session.setAttribute("member", memberDTO);

			mv.setViewName("redirect:../");
		}else {
			mv.setViewName("redirect:../member/login");		
		}
		
		
		return mv;
	}
	
	//로그아웃(GET)
	@GetMapping("logout")
	public String setLogout(HttpSession session)throws Exception{
		
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
	
	//닉네임중복 확인 로직 처리 (POST)
	@ResponseBody
	@PostMapping("nNameCheck")
	public int getNnameCheck(MemberDTO memberDTO)throws Exception{
		int result = memberService.getNnameCheck(memberDTO);
		return result;
	}
	
	//회원가입 화면(GET)
	@GetMapping("join")
	public String setJoin()throws Exception{
		
		return "member/join";
	}
	
	//회원가입 로직 처리(POST)
	@PostMapping
	public String setJoin(MemberDTO memberDTO, HttpSession session, String yy, String mm, String dd, String e, String mail)throws Exception{
		
		//DB에 새로운 회원데이터추가
		int result = memberService.setJoin(memberDTO, yy, mm, dd, e, mail);
		
		//새로운 회원데이터추가 성공 실패 확인
		if(result>0) {
			
			return "redirect:../member/login";
		}
		
		return "redirect:../member/join";
	}
	
	//강사신청 화면(GET)
	@GetMapping("teacherAdd")
	public String setTeacherAdd()throws Exception{
		
		return "member/teacherAdd";
	}
	
	//강사신청 로직 처리(POST)
	@PostMapping("teacherAdd")
	public ModelAndView setTeacherAdd(TeacherDTO teacherDTO, HttpSession session, ModelAndView mv)throws Exception{
		
		//세션에 있는 한 회원정보를 memberDTO에 담음
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		
		//DB에 새로운 강사데이터추가
		int result = memberService.setTeacherAdd(teacherDTO, session.getServletContext(), memberDTO);
		
		//새로운 강사데이터추가 성공 실패 확인
		if(result>0) {
			mv.addObject("message", "강사신청 성공!");
			memberDTO = memberService.getSessionRole(memberDTO);
			session.setAttribute("member", memberDTO);
			
		}else {
			mv.addObject("message", "강사신청 실패..");
		}
		
		mv.addObject("result", result);
		mv.addObject("url","/");
		mv.setViewName("common/result");
		
		return mv;
	}
	
	//회원탈퇴 화면(GET)
	@GetMapping("deleteMember")
	public String setDeleteMember()throws Exception{

		return "member/deleteMember";
	}
	
	//회원탈퇴 로직 처리(POST)
	@PostMapping("deleteMember")
	public String setDeleteMember(MemberDTO memberDTO, HttpSession session)throws Exception{
		
		//DB에 있는 회원정보(등급까지)를 삭제
		int result = memberService.setDeleteMember(memberDTO);
		
		//회원탈퇴 성공 실패 확인
		if(result!=0) {
			//세션삭제
			session.invalidate();
			return "redirect:../";
		}
		
		return "redirect:../member/deleteMember";
	}
	
	//어드민 회원탈퇴
	@PostMapping("deleteMemberAdmin")
	@ResponseBody
	public int setDeleteMemberAdmin(MemberDTO memberDTO)throws Exception{
		
		//DB에 있는 회원정보(등급까지)를 삭제
		int result = memberService.setDeleteMember(memberDTO);
		
		return result;
	}
	
	/************************ 마이페이지 **************************/
	
	//회원프로필정보조회 화면(GET)
	@GetMapping("profile")
	public ModelAndView getProfile(HttpSession session, MemberDTO memberDTO)throws Exception {
		
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
		
		
		//프로필정보조회(아이디, 이름, 닉네임, 성별, 이메일, 연락처 조회)
		//getProfile을 갔다온 memberDTO를 respMemberDTO(responseMemberDTO)에 담음
		respMemberDTO = memberService.getProfile(memberDTO);

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
		
		ModelAndView mv = new ModelAndView();

		MemberFileDTO file = new MemberFileDTO();
		file.setF_name(f_name);
		file.setF_oriname(f_oriname);
		
		
		int result = memberService.setEditProfile(memberDTO, file, session.getServletContext());
		
		String message = "❗프로필을 수정하지 못했습니다..❗";
		String url = "./profile";
		if(result != 0) {
			
			message = "🎉프로필을 수정했습니다🎉";
			url = "./profile";
			
			if(session.getAttribute("admin")==null) {
				//그 데이터를 "member"로 JSP에 보내줌
				mv.setViewName("redirect:../member/profile");
			}else {
				mv.setViewName("redirect:../member/profile?id="+memberDTO.getId());
			}
		}
		mv.addObject("result", result);
		mv.addObject("message", message);
		mv.addObject("url", url);
		mv.setViewName("common/result");
		
		return mv;
	}
	
	//프로필사진 삭제(POST)
	@ResponseBody
	@PostMapping("deleteFile")
	public int setDeleteFile(MemberFileDTO memberFileDTO)throws Exception{
		
		int result = memberService.setDeleteFile(memberFileDTO);
		return result;
	}
	
	//프로필 회원비밀번호 수정 화면(GET)
	@GetMapping("updatePw")
	public String setUpdatePw()throws Exception{
		
		return "member/updatePw";
	}
	
	//프로필 회원비밀번호 확인 로직(POST)
	@ResponseBody
	@PostMapping("pwCheck")
	public String getPwCheck(MemberDTO memberDTO, HttpSession session)throws Exception{
		
		MemberDTO sesMemberDTO = new MemberDTO();
		sesMemberDTO = (MemberDTO) session.getAttribute("member");
		memberDTO.setId(sesMemberDTO.getId());
		
		String respPw = memberService.getPwCheck(memberDTO);
		
		return respPw;
	}
	
	//프로필 회원비밀번호 수정 로직(POST)
	@PostMapping("updatePw")
	public String setUpdatePw(MemberDTO memberDTO, HttpSession session, String new_pw)throws Exception{
		
		MemberDTO sesMemberDTO = new MemberDTO();
		sesMemberDTO = (MemberDTO) session.getAttribute("member");
		memberDTO.setId(sesMemberDTO.getId());
		memberDTO.setPw(new_pw);
		
		int result = memberService.setUpdatePw(memberDTO);
		
		if(result != 0){
			
			return "redirect:../member/login";
		}
		
		return "redirect:../member/updatePw";
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
		ModelAndView mv = new ModelAndView();
		
		int result = memberService.setEditTcherProfile(teacherDTO);
		
		String message = "❗강사프로필을 수정하지 못했습니다..❗";
		String url = "./tcherProfile";
		if(result!=0) {

			message = "🎉강사프로필을 수정했습니다🎉";
			url = "./tcherProfile";
			
			//바뀐 강사정보를 조회(계좌번호, 은행이름, 소개글)
			teacherDTO = memberService.getTcherProfile(teacherDTO);
			//teacher로 JSP에 보내줌
			mv.addObject("teacher", teacherDTO);
			
		}
		mv.addObject("result", result);
		mv.addObject("message", message);
		mv.addObject("url", url);
		mv.setViewName("common/result");
		
		return mv;
	}
	
	//장바구니 화면(GET)
	@RequestMapping(value="cart", method=RequestMethod.GET)
	public ModelAndView getCartList(CartDTO cartDTO,HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
	    MemberDTO mem = (MemberDTO)request.getSession().getAttribute("member");

		cartDTO.setId(mem.getId());
		List<LectureDTO> ar = cartService.getCartDetail(cartDTO);
		
		mv.addObject("c_size", ar.size());
		mv.addObject("lectureDTO", ar);
		mv.setViewName("/member/cart");
		
		return mv;
	
	}
	
	@GetMapping("board")
    @ResponseBody
    public ModelAndView getMyBoardList(FreeBoardDTO freeBoardDTO,ModelAndView mv, HttpServletRequest request) throws Exception{
        MemberDTO mem = (MemberDTO)request.getSession().getAttribute("member");
        freeBoardDTO.setId(mem.getId());
        List<FreeBoardDTO> ar = freeBoardService.getMyBoardList(freeBoardDTO);
        int size = ar.size();
        
        mv.addObject("size", size);
        mv.addObject("f_board", ar);
        mv.setViewName("/member/board");
        return mv;
    }
	
	//강사권한 삭제
	@PostMapping("delTeacherAdmin")
	@ResponseBody
	public int setDeleteTeacherAll(MemberDTO dto) throws Exception{
		return memberService.setDeleteTeacherAll(dto);
	}
	
}
