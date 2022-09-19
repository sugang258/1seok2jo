package com.seok.home.pay;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/pay/*")
public class PayController {
	
	@Autowired
	private PayService service;
	
	//‘강의 상세’  ‘장바구니’ 페이지에서 결제하기 버튼을 눌러 주문페이지로 이동
	@GetMapping(value="order")
	public String showOrder() {
		//로그인한 회원정보 (세션에 저장된 정보로 jsp파일에서 가져올 수 있음)
		//구매하려는 강의정보를 받아와 (강의상세에서 바로 넘어오는 경우 강의번호로, 장바구니에서 넘어오는 경우 장바구니 표시로 넘겨준다.)
		//페이지 표시
		return "pay/order";
	}
	
	//결제성공시
	@PostMapping(value="success")
	@ResponseBody
	public void getSuccess(HashMap<String, Object> param) {
		//넘어오긴하는데 못받아옴아모암오
		System.out.println(param.keySet());
		
	}

}
