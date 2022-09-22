package com.seok.home.pay;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.seok.home.lecture.LectureDTO;
import com.seok.home.member.MemberDTO;

@Controller
@RequestMapping(value="/pay/*")
public class PayController {
	
	@Autowired
	private PayService payService;
	
	//‘강의 상세’  ‘장바구니’ 페이지에서 결제하기 버튼을 눌러 주문페이지로 이동
	@GetMapping(value="order")
	public ModelAndView showOrder(String l_num, HttpServletRequest request) throws Exception{
		//구매하려는 강의정보를 받아와 (강의상세에서 바로 넘어오는 경우 강의번호로, 장바구니에서 넘어오는 경우 장바구니 표시로 넘겨준다.)
		
		ModelAndView mv = new ModelAndView();
		
		ArrayList<LectureDTO> lectureDTOs = new ArrayList<LectureDTO>();
		
		if(l_num!=null) {
			lectureDTOs = payService.getOrder(l_num);			
		}else {
			MemberDTO member = (MemberDTO)request.getSession().getAttribute("member");
			lectureDTOs = payService.getOrder(member);
		}
		
		
		mv.addObject("lectures", lectureDTOs);
		mv.setViewName("pay/order");
		
		return mv;
	}
	
	//결제성공시
	@PostMapping(value="success")
	@ResponseBody
	public int receiveSuccess(@RequestBody HashMap<String, String> res, HttpServletRequest request) throws Exception {
		//주문상세내역과 결제내역 저장
		//paymenDTO에 받아온 변수 값 매칭
		PaymentDTO paymentDTO = new PaymentDTO();
		MemberDTO mem = (MemberDTO)request.getSession().getAttribute("member");
		
		System.out.println(res.keySet());
		System.out.println(res.get("point"));
		paymentDTO.setId(mem.getId());
		paymentDTO.setP_uid(res.get("merchant_uid"));
		paymentDTO.setP_point(Long.parseLong(res.get("point")));
		paymentDTO.setP_amount(Long.parseLong(res.get("amount")));
		paymentDTO.setP_realamount(Long.parseLong(res.get("paid_amount")));
		paymentDTO.setP_method(res.get("pay_method"));
		paymentDTO.setP_remains(Long.parseLong(res.get("paid_amount")));
		paymentDTO.setP_c_name(res.get("card_name"));
		paymentDTO.setP_c_apply(Long.parseLong(res.get("apply_num")));
		paymentDTO.setP_c_num(Long.parseLong(res.get("card_number")));
		paymentDTO.setP_c_quota(Long.parseLong(res.get("card_quota")));
		paymentDTO.setP_at(Long.parseLong(res.get("paid_amount")));
		paymentDTO.setP_receipt(res.get("receipt_url"));
		
		int result = payService.receiveSuccess(paymentDTO);
		
		//포인트 계산
		

		return result;

	}
	
	@GetMapping(value="complete")
	public ModelAndView showComplete(PaymentDTO paymentDTO) throws Exception {
		//주문정보, 강의정보 DB에서 가져와서 화면에 뿌려준다.
		HashMap<String, Object> result = payService.showComplete(paymentDTO);
		
		paymentDTO = (PaymentDTO)result.get("paymentDTO");
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("result",result);
		mv.setViewName("pay/complete");
		return mv;
	}

}
