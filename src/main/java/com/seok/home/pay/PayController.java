package com.seok.home.pay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/pay/*")
public class PayController {
	
	@Autowired
	private PayService service;
	
	//‘강의 상세’  ‘장바구니’ 페이지에서 결제하기 버튼을 눌러 주문페이지로 이동
	@GetMapping(value="order")
	public String showOrder() {
		//로그인한 회원정보
		//구매하려는 강의정보를 받아와
		//페이지 표시
		return "pay/order";
	}

}
