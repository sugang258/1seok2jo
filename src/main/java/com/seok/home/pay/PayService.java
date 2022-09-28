package com.seok.home.pay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seok.home.cart.CartDAO;
import com.seok.home.cart.CartDTO;
import com.seok.home.lecture.LectureDAO;
import com.seok.home.lecture.LectureDTO;
import com.seok.home.member.MemberDTO;

@Service
public class PayService {
	@Autowired
	PayDAO payDAO;
	@Autowired
	CartDAO cartDAO;
	
	public PaymentDTO cancel(PaymentDTO paymentDTO) throws Exception{

		paymentDTO = payDAO.getPayDetail(paymentDTO);
		
		return paymentDTO;
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
			lectureDTO = payDAO.getSimpleLecture(lectureDTO);

			lectures.add(lectureDTO);
		}
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("lectures", lectures);
		result.put("paymentDTO", paymentDTO);

		return result;
	}
	
	//결제후 주문목록 저장
	public int receiveSuccess(PaymentDTO paymentDTO) throws Exception{
		//payment저장
		int result = payDAO.savePayment(paymentDTO);
		
		//order목록 저장
		if(result==1) {
			
			//장바구니 목록 불러오기
			CartDTO cartDTO = new CartDTO();
			cartDTO.setId(paymentDTO.getId());
			
			cartDAO.getCartList(cartDTO);
			List<CartDTO> cartDTOs = cartDAO.getCartList(cartDTO);
			
			for(CartDTO cart : cartDTOs) {
				//강의정보가져오기
				LectureDTO lectureDTO = new LectureDTO();
				lectureDTO.setL_num(cart.getL_num());
				lectureDTO = payDAO.getSimpleLecture(lectureDTO);
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
			
		}
		return result;
	}
	
	public List<CartDTO> getCartList(CartDTO cartDTO) throws Exception {
		return cartDAO.getCartList(cartDTO);
	}
	
	public ArrayList<LectureDTO> getOrder(MemberDTO memberDTO) throws Exception {
		//강의번호가 비어있으면 장바구니의 강의 번호를 불러온다.
		
		CartDTO cartDTO = new CartDTO();
		cartDTO.setId(memberDTO.getId());
		
		//장바구니 목록 불러오기
		List<CartDTO> cartDTOs = cartDAO.getCartList(cartDTO);
		
		
		ArrayList<LectureDTO> lectureDTOs = new ArrayList<LectureDTO>();
		//for문으로 List<LectureDTO>를 만들어준다.
		for(CartDTO cart : cartDTOs) {
			LectureDTO lectureDTO = new LectureDTO();
			System.out.println(cart.getL_num());
			lectureDTO.setL_num(cart.getL_num());
			
			lectureDTO = payDAO.getSimpleLecture(lectureDTO);
			System.out.println(lectureDTO.getL_name());
			lectureDTOs.add(lectureDTO);
		}
		
		return lectureDTOs;
	}
	
	public ArrayList<LectureDTO> getOrder(String l_num) throws Exception {
		//강의 불러온다.
		LectureDTO lectureDTO = new LectureDTO();
		System.out.println(Long.parseLong(l_num));
		lectureDTO.setL_num(Long.parseLong(l_num));
		
		ArrayList<LectureDTO> lectureDTOs = new ArrayList<LectureDTO>();
		lectureDTO = payDAO.getSimpleLecture(lectureDTO);
		lectureDTOs.add(lectureDTO);
		
		return lectureDTOs;
	}
	


}
