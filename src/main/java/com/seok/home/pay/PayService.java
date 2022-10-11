package com.seok.home.pay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seok.home.cart.CartDAO;
import com.seok.home.cart.CartDTO;
import com.seok.home.lecture.LectureDAO;
import com.seok.home.lecture.LectureDTO;
import com.seok.home.lecture.add.LectureAddDAO;
import com.seok.home.lecture.add.LectureAddDTO;
import com.seok.home.lecture.status.StatusDAO;
import com.seok.home.lecture.status.StatusDTO;
import com.seok.home.member.MemberDAO;
import com.seok.home.member.MemberDTO;
import com.seok.home.util.ChartDTO;

@Service
public class PayService {
	@Autowired
	PayDAO payDAO;
	@Autowired
	CartDAO cartDAO;
	@Autowired
	LectureAddDAO lectureAddDAO;
	@Autowired
	StatusDAO statusDAO;
	@Autowired
	LectureDAO lectureDAO;
	@Autowired
	MemberDAO memberDAO;
	
	//마일리지 가져오기
	public Long getPoint(MemberDTO dto) throws Exception{
		return memberDAO.getPoint(dto);
	}
	
	//마일리지 업데이트
	public int updatePoint(MemberDTO dto) throws Exception{
		return memberDAO.updatePoint(dto);
	}
	
	public HashMap<String, Object> getChartAdminDashBoard () throws Exception{
		
		List<ChartDTO> charts = payDAO.getChartAdminDashBoard();
		
		String[] labels = new String[5];
		
		for(ChartDTO chart: charts) {
			
		}
		
		return null;
	}
	
	public HashMap<String, Object> getMyPayList(MemberDTO member)throws Exception{
		member = memberDAO.getProfile(member);
		PaymentDTO paymentDTO = new PaymentDTO();
		paymentDTO.setId(member.getId());
		List<PaymentDTO> payList = payDAO.getPaymentList(paymentDTO);
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("payList", payList);
		result.put("member", member);
		Integer Lcnt = 0;
		for(PaymentDTO pay:payList) {
			Lcnt += pay.getOrders().size();
		}
		result.put("Lcnt", Lcnt);
		return result;
	}
	
	
	public int cancelSuccess(RefundDTO refundDTO, Long l_num,HttpServletRequest request) throws Exception{
		
		//결제 취소에 성공하면 refundDTO DB에 저장
		int result = payDAO.saveRefund(refundDTO);
		
		//payment의 remains변경해야딤
		PaymentDTO payment = new PaymentDTO();
		payment.setP_uid(refundDTO.getP_uid());
		//p_remains값을 가져온다
		Long premains = payDAO.getPaymentRemains(payment);
		
		payment.setP_remains(premains - refundDTO.getPr_amount());
		//업데이트
		result = payDAO.updatePaymentRemains(payment);
		
		MemberDTO mem = (MemberDTO)request.getSession().getAttribute("member");

		LectureAddDTO lectureAddDTO = new LectureAddDTO();
		StatusDTO statusDTO = new StatusDTO();
		lectureAddDTO.setL_num(l_num);
		lectureAddDTO.setId(mem.getId());
		
		lectureAddDTO = lectureAddDAO.getLectureCancel(lectureAddDTO);
		
		statusDTO.setS_num(lectureAddDTO.getS_num());
		
		statusDAO.setStatusDelete(statusDTO);
		lectureAddDAO.setLectureAddDelete(lectureAddDTO);
		lectureAddDAO.setLectureCountM(lectureAddDTO);
		
		return result;
	}
	
	public OrderDTO requestCancle(OrderDTO orderDTO) throws Exception{

		orderDTO = payDAO.getOrder(orderDTO);
		
		return orderDTO;
	}
	
	public PaymentDTO getPayDetail(PaymentDTO paymentDTO) throws Exception{
		return payDAO.getPayDetail(paymentDTO);
	}
	
	public HashMap<String, Object> showComplete(PaymentDTO paymentDTO) throws Exception{
		
		paymentDTO = payDAO.getPayDetail(paymentDTO);
		//강의정보가져오기
		ArrayList<LectureDTO> lectures = new ArrayList<LectureDTO>();
		for(OrderDTO o : paymentDTO.getOrders()) {
			LectureDTO lectureDTO = new LectureDTO();
			lectureDTO.setL_num(o.getL_num());
			lectureDTO = lectureDAO.getSimpleLecture(lectureDTO);

			lectures.add(lectureDTO);
		}
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("lectures", lectures);
		result.put("paymentDTO", paymentDTO);

		return result;
	}
	
	//결제후 주문목록 저장
	public int paySuccess(PaymentDTO paymentDTO, String l_num) throws Exception{
		//payment저장
		int result = payDAO.savePayment(paymentDTO);
		
		//order목록 저장
		if(result==1) {
			
			
			if(l_num==null) {
			//장바구니 목록 불러오기
			CartDTO cartDTO = new CartDTO();
			cartDTO.setId(paymentDTO.getId());
			
			cartDAO.getCartList(cartDTO);
			List<CartDTO> cartDTOs = cartDAO.getCartList(cartDTO);
			
			for(CartDTO cart : cartDTOs) {
				//강의정보가져오기
				LectureDTO lectureDTO = new LectureDTO();
				lectureDTO.setL_num(cart.getL_num());
				lectureDTO = lectureDAO.getSimpleLecture(lectureDTO);
				//강의넘이랑 가격만 가져다 DB에 저장할거임
				OrderDTO orderDTO = new OrderDTO();
				orderDTO.setL_num(lectureDTO.getL_num());
				orderDTO.setO_amount(lectureDTO.getL_price());
				orderDTO.setP_uid(paymentDTO.getP_uid());
				
				//orderDB에 저장!
				result = payDAO.saveOrder(orderDTO);
				if(result!=1) {
					System.out.println("order저장실패");
				}
			}
			}else {
				Long lNum = Long.parseLong(l_num);
				//강의정보가져오기
				LectureDTO lectureDTO = new LectureDTO();
				lectureDTO.setL_num(lNum);
				lectureDTO = lectureDAO.getSimpleLecture(lectureDTO);
				//강의넘이랑 가격만 가져다 DB에 저장할거임
				OrderDTO orderDTO = new OrderDTO();
				orderDTO.setL_num(lectureDTO.getL_num());
				orderDTO.setO_amount(lectureDTO.getL_price());
				orderDTO.setP_uid(paymentDTO.getP_uid());
				
				//orderDB에 저장!
				result = payDAO.saveOrder(orderDTO);
			}
			
		}
		return result;
	}
	
	public List<CartDTO> getCartList(CartDTO cartDTO) throws Exception {
		return cartDAO.getCartList(cartDTO);
	}
	
	public ArrayList<LectureDTO> getCartLectures(MemberDTO memberDTO) throws Exception {
		//강의번호가 비어있으면 장바구니의 강의 번호를 불러온다.
		
		CartDTO cartDTO = new CartDTO();
		cartDTO.setId(memberDTO.getId());
		
		//장바구니 목록 불러오기
		List<CartDTO> cartDTOs = cartDAO.getCartList(cartDTO);
		
		
		ArrayList<LectureDTO> lectureDTOs = new ArrayList<LectureDTO>();
		//for문으로 List<LectureDTO>를 만들어준다.
		for(CartDTO cart : cartDTOs) {
			LectureDTO lectureDTO = new LectureDTO();
			lectureDTO.setL_num(cart.getL_num());
			
			lectureDTO = lectureDAO.getSimpleLecture(lectureDTO);
			lectureDTOs.add(lectureDTO);
		}
		
		return lectureDTOs;
	}
	
	public ArrayList<LectureDTO> getCartLectures(String l_num) throws Exception {
		//강의 불러온다.
		LectureDTO lectureDTO = new LectureDTO();
		lectureDTO.setL_num(Long.parseLong(l_num));
		
		ArrayList<LectureDTO> lectureDTOs = new ArrayList<LectureDTO>();
		lectureDTO = lectureDAO.getSimpleLecture(lectureDTO);
		lectureDTOs.add(lectureDTO);
		
		return lectureDTOs;
	}
	


}
