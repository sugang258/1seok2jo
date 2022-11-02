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
			StringBuffer mailMsg = new StringBuffer();
			
			//https://unlayer.com/download-template?url=https://assets.unlayer.com/projects/6070/_generated/zip/1667390037363-gTLhhTwSpiKb9v93.zip&utm_source=automation&utm_medium=email&utm_campaign=lead-d0
			
			mailMsg.append("<html><body>");
			mailMsg.append("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT\" crossorigin=\"anonymous\">");
			
			mailMsg.append("<div class=\"board\">\r\n"
					+ "                  <!--내가 문의한 부분-->\r\n"
					+ "                  <div class=\"board_contents\">\r\n"
					+ "                    <div class=\"row py-2\">\r\n"
					+ "                      <div class=\"col-10 align-content-center\" style=\"padding: 8px 8px 8px 0px; font-size: 14px; margin-top: 0.5rem\">\r\n"
					+ "                        <h5 class=\"px-2\"><b>eee</b></h5>\r\n"
					+ "                      </div>\r\n"
					+ "                      <div class=\"col-2 align-content-center my-auto\">\r\n"
					+ "                        \r\n"
					+ "                          \r\n"
					+ "                        <div class=\"b1 d-flex\">\r\n"
					+ "                          <div class=\"mx-auto\">\r\n"
					+ "                            <b>\r\n"
					+ "                              답변완료\r\n"
					+ "                            </b>\r\n"
					+ "                          </div>\r\n"
					+ "                        </div>\r\n"
					+ "                        \r\n"
					+ "          \r\n"
					+ "                      </div>\r\n"
					+ "                    </div>\r\n"
					+ "                    <hr style=\"margin: 0;\">\r\n"
					+ "                    <div class=\"row p-3 text-muted flex-row-reverse\">\r\n"
					+ "                      2022-11-02\r\n"
					+ "                    </div>\r\n"
					+ "                    <div class=\"row\">\r\n"
					+ "                      <p>eeee</p>\r\n"
					+ "                    </div>\r\n"
					+ "                  </div>\r\n"
					+ "          \r\n"
					+ "                  <!--답변부분-->\r\n"
					+ "                  <div class=\"cs_answers\">\r\n"
					+ "                    <div class=\"mb-3\">\r\n"
					+ "                      <h5><b>답변</b></h5>\r\n"
					+ "                      \r\n"
					+ "                        eeee\r\n"
					+ "                      \r\n"
					+ "                        \r\n"
					+ "                    </div>\r\n"
					+ "                  </div>\r\n"
					+ "                </div>");
			
			mailMsg.append("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8\" crossorigin=\"anonymous\"></script>");
			mailMsg.append("</html></body>");
			csBoardDTO = csDAO.getBoardDetail(csBoardDTO);
			emailManager.sendHTML(csBoardDTO.getCs_email(), "[일석이조]문의에 답변이 완료되었습니다", mailMsg.toString());
		}else {
			message = "답변 등록에 실패하였습니다";
		}
		System.out.println(message);
		
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
		
		if(member==null) {
			return "일석이조 회원 인증 실패";
		}else {
			//이미 권한이 있는지 확인
			for(RoleDTO role:member.getRoleDTOs()) {
				if(role.getRoleNum()==1L) {
					return "관리자 권한이 있는 계정입니다.";
				}
			}
			//권한추가
			int result = memberDAO.setAdminRole(member);
			if(result==1) {
				return "인증이 완료되었습니다\n관리자 로그인을 진행해주세요";				
			}else {
				return "관리자 인증 실패\n 담당자에게 문의해주세요";
			}
		}
		
	}
	
	//board삭제
	public int delBoardAdmin(FreeBoardDTO dto) throws Exception{
		dto = adminDAO.findBoard(dto);
		int result = adminDAO.setBoardDelete(dto);
		return result;
	}

}
