package com.seok.home.admin;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seok.home.cs_board.CsBoardDTO;
import com.seok.home.cs_board.CsDAO;
import com.seok.home.f_board.FreeBoardDTO;
import com.seok.home.lecture.LectureDAO;
import com.seok.home.lecture.LectureDTO;
import com.seok.home.lecture.add.LectureAddDAO;
import com.seok.home.member.MemberDAO;
import com.seok.home.member.MemberDTO;
import com.seok.home.member.RoleDTO;
import com.seok.home.pay.PayDAO;
import com.seok.home.pay.PaymentDTO;
import com.seok.home.util.ChartDTO;
import com.seok.home.util.EmailManager;

@Service
public class AdminService {
	
	@Autowired
	private AdminDAO adminDAO;
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private LectureDAO lectureDAO;
	@Autowired
	private LectureAddDAO lectureAddDAO;
	@Autowired
	private CsDAO csDAO;
	@Autowired
	private PayDAO payDAO;
	@Autowired
	private EmailManager emailManager;
	
	public HashMap<String, Object> getAdminDashBoard () throws Exception{
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		//하루 매출액 그래프
		List<ChartDTO> charts = payDAO.getChartAdminDashBoard();
		
		//전체 회원수 
		Long memberCnt = memberDAO.getMemberCnt();
		//전체 강의수
		Long lectureCnt = lectureDAO.getLectureCnt();
		//전체 게시글 수
		Long boardCnt = adminDAO.getBoardCnt();
		//현재 수강중인 강의 수
		Long lectureIng = lectureAddDAO.getLectureIngCnt();
		
		//미답변 문의수 
		Long notAnswerCnt = csDAO.getNotAnswerCnt();
		
		result.put("charts", charts);
		result.put("memberCnt", memberCnt);
		result.put("lectureCnt", lectureCnt);
		result.put("boardCnt", boardCnt);
		result.put("lectureIng", lectureIng);
		result.put("notAnswerCnt", notAnswerCnt);
		
		return result;
	}
	
	
	public List<FreeBoardDTO> getBoardsList(AdminPager pager) throws Exception{
		pager.calNum(adminDAO.getTotalBoardList(pager));
		
		return adminDAO.getBoardList(pager);
	}
	
	public List<LectureDTO> getLectureList(AdminPager pager) throws Exception{
		Long totalCount = lectureDAO.getCount(pager);
		pager.calNum(totalCount);
		
		List<LectureDTO> dtos = lectureDAO.getLecture(pager);
		return dtos;
	}
	
	public List<MemberDTO> getMember(AdminPager adminPager) throws Exception{
		adminPager.calNum(memberDAO.getAdminMemberTotal(adminPager));
		
		return memberDAO.getAdminMemberList(adminPager);
	}
	
	public List<PaymentDTO> getPaymentsList(AdminPager adminPager) throws Exception{
		adminPager.calNum(payDAO.getPayAdminTotal(adminPager));
		
		List<PaymentDTO> paylist = payDAO.getPayAdminList(adminPager);
		return paylist;
	}
	
	public String setCsAnswer(CsBoardDTO csBoardDTO) throws Exception{
		int result = csDAO.setAnswerDefault(csBoardDTO);
		
		String message = "";
		if(result==1) {
			message = "답변 등록에 성공하였습니다.";
			
			csBoardDTO = csDAO.getBoardDetail(csBoardDTO);
			
			String mailText = emailManager.getcsAnswerHtml(csBoardDTO.getCs_title(), csBoardDTO.getCs_contents(), csBoardDTO.getCs_answer());
			emailManager.sendHTML(csBoardDTO.getCs_email(), "[일석이조]문의에 답변이 완료되었습니다", mailText);
		}else {
			message = "답변 등록에 실패하였습니다";
		}
		
		return message;
	}
	
	public CsBoardDTO getCsAnswer(CsBoardDTO csBoardDTO) throws Exception{
		csBoardDTO = csDAO.getBoardDetail(csBoardDTO);
		return csBoardDTO;
	}
	
	public List<CsBoardDTO> getCsList(AdminPager pager)throws Exception{
		pager.calNum(csDAO.getTotalCount(pager));

		List<CsBoardDTO> csList = csDAO.getBoardList(pager);
		
		return csList;
	}
	
	public MemberDTO getLogin(MemberDTO memberDTO) throws Exception {
		
		memberDTO = memberDAO.getLogin(memberDTO);
		
		if(memberDTO!=null) {			
			List<RoleDTO> roles = memberDTO.getRoleDTOs();
			
			for(RoleDTO role : roles) {
				//로그인 후 관리자인걸 확인하면 memberDTO를 되돌려줌
				if(role.getRoleName().equals("관리자")) {
					return memberDTO;
				}
			}
		}
		
		//관리자 확인이 되지 않거나 로그인이 되지 않으면 null을 되돌려줌
		return null;
	}
	
	public String getAuth(MemberDTO member) throws Exception{
		//아이디 패스워드 맞는지 확인
		member = memberDAO.getLogin(member);
		String msg = "";
		if(member==null) { //일석이조 회원이 아닌 경우
			return "일석이조 회원 인증 실패";
		}else {
			//이미 권한이 있는지 확인
			for(RoleDTO role:member.getRoleDTOs()) {
				if(role.getRoleNum()==1L) {
					msg = "관리자 권한이 있는 계정입니다.";
					break;
				}
			}
			//권한추가
			int result = memberDAO.setAdminRole(member);
			if(result==1) {
				msg ="인증이 완료되었습니다 관리자 로그인을 진행해주세요";				
			}else {
				msg ="관리자 인증 실패 담당자에게 문의해주세요";
			}
		}
		return msg;
	}
	
	//board삭제
	public int delBoardAdmin(FreeBoardDTO dto) throws Exception{
		dto = adminDAO.findBoard(dto);
		int result = adminDAO.setBoardDelete(dto);
		return result;
	}

}
