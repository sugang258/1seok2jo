package com.seok.home.member;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seok.home.cart.CartDAO;
import com.seok.home.cart.CartDTO;
import com.seok.home.lecture.teacher.TeacherDAO;
import com.seok.home.lecture.teacher.TeacherDTO;

@Service
public class MemberService {

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
	
	public MemberDTO getSessionRole(MemberDTO memberDTO) throws Exception{
		return memberDAO.getSessionRole(memberDTO);
	}
	
	//아이디중복 확인
	public int getIdCheck(MemberDTO memberDTO)throws Exception{
		return memberDAO.getIdCheck(memberDTO);
	}
	
	//닉네임중복 확인
	public int getNnameCheck(MemberDTO memberDTO)throws Exception{
		return memberDAO.getNnameCheck(memberDTO);
	}
	
	//회원가입
	public int setJoin(MemberDTO memberDTO, String yy, String mm, String dd, String e, String mail)throws Exception{

		MemberFileDTO memberFileDTO = new MemberFileDTO();
		memberFileDTO.setId(memberDTO.getId());
		memberFileDTO.setF_name("default.png");
		memberFileDTO.setF_oriname("default.png");
		
		memberDTO.setB_date(Long.parseLong(yy+mm+dd));
		memberDTO.setEmail(e+mail);
		memberDTO.setMemberFileDTO(memberFileDTO);
		System.out.println("memberfileDTO"+memberDTO.getMemberFileDTO().getF_name());
		
		//회원가입이 성공하면 등급을 추가
		int susess = memberDAO.setJoin(memberDTO);
		int file = 0;
		int result = 0;
		if(susess == 1) {
			file = memberDAO.setAddFile(memberFileDTO);
			result = memberDAO.setMemberRole(memberDTO);
			result = file*result;
		}
		
		return result;	
	}
	
	//강사신청
	public int setTeacherAdd(TeacherDTO teacherDTO, ServletContext servletContext, MemberDTO memberDTO)throws Exception{
		
		List<RoleDTO> roleDTOs = memberDTO.getRoleDTOs();
		//2
		System.out.println("강사신청서비스 : "+roleDTOs.get(0).getRoleNum());
		//강사
		System.out.println("강사신청서비스 : "+roleDTOs.get(0).getRoleName());
		
		Long roleNum = roleDTOs.get(0).getRoleNum();
		
		int result = 0;
		if(roleNum != 2) {
			//강사신청 성공하면 등급을 추가
			int susess = teacherDAO.setTeacherAdd(teacherDTO);
			if(susess == 1) {
				result = teacherDAO.setTeacherRole(teacherDTO);
			}
		
		}
		return result;
	}
	
	//강사삭제
	public int setDeleteTeacherAll(MemberDTO dto)throws Exception{
		return memberDAO.setDeleteTeacherAll(dto);
	}
	
	//회원탈퇴
	public int setDeleteMember(MemberDTO memberDTO)throws Exception{
//		int susess = memberDAO.setDeleteMemberRole(memberDTO);
//		int result = 0;
//		if(susess != 0) {
//			result = memberDAO.setDeleteJoin(memberDTO);
//		}
		return memberDAO.setDeleteJoin(memberDTO);
	}
	
	//메인페이지 멤버카운트
	public Long getMemberCnt() throws Exception{
		return memberDAO.getMemberCnt();
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
		System.out.println("멤버 파일디티오 안에 f_name : "+memberFileDTO.getF_name());
		
		/*************** file이 X ***************/		
		if(file.getF_name() == null && file.getF_oriname() == null) {
			
			return result;
		}else {
			
			/*************** file이 O ***************/	
			
			//memberFileDTO을 삭제
			result = memberDAO.setDeleteFile(memberFileDTO);
			
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
	
	//프로필사진 삭제
	public int setDeleteFile(MemberDTO memberDTO)throws Exception{
		MemberFileDTO memberFileDTO = new MemberFileDTO();
		memberFileDTO = memberDTO.getMemberFileDTO();
		System.out.println("memberFileDTO : "+memberFileDTO.getId());
		return memberDAO.setDeleteFile(memberFileDTO);
	}
	
	//프로필 회원비밀번호 확인
	public String getPwCheck(MemberDTO memberDTO)throws Exception{
		MemberDTO respMemberDTO = new MemberDTO();
		respMemberDTO = memberDAO.getPwCheck(memberDTO);
		String pw = respMemberDTO.getPw();
		
		return pw;
	}
	
	//프로필 회원비밀번호 수정
	public int setUpdatePw(MemberDTO memberDTO)throws Exception{
		
		int result=0;
		if(memberDTO.getPw()==null) {
			return result;
		}
		
		result = memberDAO.setUpdatePw(memberDTO);
		
		return result;
	}
	
	//강사프로필정보조회
	public TeacherDTO getTcherProfile(TeacherDTO teacherDTO)throws Exception{
		return teacherDAO.getTeacherDetail(teacherDTO);
	}
	
	//강사프로필수정
	public int setEditTcherProfile(TeacherDTO teacherDTO)throws Exception{
		return teacherDAO.setTeacherUpdate(teacherDTO);
	}
	
	//장바구니
	public List<CartDTO> getCartList(CartDTO cartDTO) throws Exception {
		return cartDAO.getCartList(cartDTO);
	}
	
	
}
