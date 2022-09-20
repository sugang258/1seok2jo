package com.seok.home.pay;

import java.util.ArrayList;
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
	
	public ArrayList<LectureDTO> getOrder(MemberDTO memberDTO) throws Exception {
		//강의번호가 비어있으면 장바구니의 강의 번호를 불러온다.
		LectureDAO lectureDAO = new LectureDAO();
		CartDAO cartDAO = new CartDAO();
		
		CartDTO cartDTO = new CartDTO();
		cartDTO.setId(memberDTO.getId());
		
		List<CartDTO> cartDTOs = cartDAO.getCartList(cartDTO);
		
		ArrayList<LectureDTO> lectureDTOs = new ArrayList<LectureDTO>();
		
		//for문으로 List<LectureDTO>를 만들어준다.
		for(CartDTO cart : cartDTOs) {
			LectureDTO lectureDTO = new LectureDTO();
			lectureDTO.setL_num(cart.getL_num());
			
			lectureDTO = lectureDAO.getDetail(lectureDTO);
			lectureDTOs.add(lectureDTO);
		}
		
		return lectureDTOs;
	}
	
	public ArrayList<LectureDTO> getOrder(String l_num) throws Exception {
		//강의 불러온다.
		LectureDAO lectureDAO = new LectureDAO();
		LectureDTO lectureDTO = new LectureDTO();
		System.out.println(Long.parseLong(l_num));
		lectureDTO.setL_num(Long.parseLong(l_num));
		
		ArrayList<LectureDTO> lectureDTOs = new ArrayList<LectureDTO>();
		lectureDTO = lectureDAO.getDetail(lectureDTO);
		lectureDTOs.add(lectureDTO);
		
		return lectureDTOs;
	}
	


}
