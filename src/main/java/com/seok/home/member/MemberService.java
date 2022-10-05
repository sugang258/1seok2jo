package com.seok.home.member;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.seok.home.cart.CartDAO;
import com.seok.home.cart.CartDTO;
import com.seok.home.lecture.LectureFileDTO;
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
	//강사정보 조회
	public TeacherDTO getTeacherDetail(TeacherDTO teacherDTO)throws Exception{
		return teacherDAO.getTeacherDetail(teacherDTO);
	}
	
	//강사신청
	public int setTeacherAdd(TeacherDTO teacherDTO, ServletContext servletContext)throws Exception{
		System.out.println("강사신청한거에 너의 강사신청번호가 있니? "+teacherDTO.getT_num());
		int result = 0;
		if(teacherDTO.getT_num() == null) {
			//강사신청 성공하면 등급을 추가
			int susess = teacherDAO.setTeacherAdd(teacherDTO);
			if(susess == 1) {
				result = teacherDAO.setTeacherRole(teacherDTO);
			}
		
		teacherDTO = teacherDAO.getTeacherDetail(teacherDTO);
		System.out.println("강사신청한거에 강사신청번호가있니? "+teacherDTO.getT_num());
		
		}
		return result;
	}
	
	//회원탈퇴
	public int setDeleteMember(MemberDTO memberDTO)throws Exception{
		int susess = memberDAO.setDeleteMemberRole(memberDTO);
		int result = 0;
		if(susess != 0) {
			result = memberDAO.setDeleteJoin(memberDTO);
		}
		return result;
	}
	
	
	/************************ 마이페이지 **************************/
	
	//프로필정보조회
	public MemberDTO getProfile(MemberDTO memberDTO)throws Exception{
		return memberDAO.getProfile(memberDTO);
	}
	
	//프로필수정
	public int setEditProfile(MemberDTO memberDTO, MemberFileDTO file, ServletContext servletContext)throws Exception{
		
		//정보수정 먼저
		int result = memberDAO.setEditProfile(memberDTO);
		
		//수정된 정보를 조회해서 memberDTO에 대입
		//그럼 memberDTO에는 insert가 되어 null이 아니다
		memberDTO = memberDAO.getProfile(memberDTO);
		
		//memberDTO안에 있는 한개의 memberFileDTO을 
		//memberFileDTO변수에 대입
		MemberFileDTO memberFileDTO = memberDTO.getMemberFileDTO();
		
		//memberFileDTO가 있으면
		if(memberFileDTO != null) {
			//memberFileDTO을 삭제
			result = memberDAO.setDeleteFile(memberFileDTO);
		}
		
		//insert 가 되면
		if(result == 1) {
			System.out.println("파일이왔니? "+file.getF_name());
			
			//파일 리스트를 파일 DB에 저장
			file.setId(memberDTO.getId());
			result = memberDAO.setAddFile(file);
			
			if(result!=1) {
				System.out.println("파일 추가 오류");
			}
			
		}else {
			System.out.println("EditProfile에러");
		}
		
		//(삭제후) memberFileDTO없으면(없으니) 폴더에 추가
//		String path = "resources/upload/member";
//		
//		String fileName = fileManager.saveFile(path, servletContext, profile);
//		
//		if(!profile.isEmpty()) {
//			MemberFileDTO memberFileDTO2 = new MemberFileDTO();
//			memberFileDTO2.setF_name(fileName);
//			memberFileDTO2.setF_oriname(profile.getOriginalFilename());
//			memberFileDTO2.setId(memberDTO.getId());
//			result = memberDAO.setAddFile(memberFileDTO2);
//			memberDTO.setMemberFileDTO(memberFileDTO2);
//		}
		
		return result;
	}
	
	//장바구니
	public List<CartDTO> getCartList(CartDTO cartDTO) throws Exception {
		return cartDAO.getCartList(cartDTO);
	}
	
	
}
