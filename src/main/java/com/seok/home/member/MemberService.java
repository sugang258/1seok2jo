package com.seok.home.member;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.seok.home.cart.CartDAO;
import com.seok.home.cart.CartDTO;
import com.seok.home.lecture.teacher.TeacherDAO;
import com.seok.home.lecture.teacher.TeacherDTO;
import com.seok.home.util.FileManager;

@Service
public class MemberService {

	//파일매니저
	@Autowired
	private FileManager fileManager;
	//회원
	@Autowired
	private MemberDAO memberDAO;
	//강사
	@Autowired
	private TeacherDAO teacherDAO;
	//장바구니
	@Autowired
	private CartDAO cartDAO;
	
	/************************ 회원 **************************/
	
	//회원로그인
	public MemberDTO getLogin(MemberDTO memberDTO)throws Exception{
		return memberDAO.getLogin(memberDTO);
	}
	
	//회원가입
	public int setJoin(MemberDTO memberDTO)throws Exception{
		//회원가입이 성공하면 등급을 추가
		int susess = memberDAO.setJoin(memberDTO);
		int result = 0;
		if(susess == 1 ) {
			result = memberDAO.setMemberRole(memberDTO);
		}
		
		return result;	
	}
	
	//강사신청
	public int setTeacherAdd(TeacherDTO teacherDTO, ServletContext servletContext)throws Exception{
		return teacherDAO.setTeacherAdd(teacherDTO);
	}
	
	/************************ 마이페이지 **************************/
	
	//프로필정보조회
	public MemberDTO getProfile(MemberDTO memberDTO)throws Exception{
		return memberDAO.getProfile(memberDTO);
	}
	
	//프로필수정
	public int setProfile(MemberDTO memberDTO, MultipartFile profile, ServletContext servletContext)throws Exception{
		
		int result = memberDAO.setJoin(memberDTO);
		String path = "resources/upload/member";
		
		String fileName = fileManager.saveFile(path, servletContext, profile);
		
		if(!profile.isEmpty()) {
			MemberFileDTO memberFileDTO = new MemberFileDTO();
			memberFileDTO.setF_name(fileName);
			memberFileDTO.setF_oriname(profile.getOriginalFilename());
			memberFileDTO.setId(memberDTO.getId());
			memberDAO.setAddFile(memberFileDTO);
		}
		
		return result;
	}
	
	//장바구니
	public List<CartDTO> getCartList(CartDTO cartDTO) throws Exception {
		return cartDAO.getCartList(cartDTO);
	}
	
	
}
