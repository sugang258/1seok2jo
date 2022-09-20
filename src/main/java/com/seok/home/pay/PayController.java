package com.seok.home.pay;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
			System.out.println("c_num은 널");
			lectureDTOs = payService.getOrder(l_num);			
		}else {
			System.out.println("c_num은 낫널");
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
	public String getSuccess(@RequestBody HashMap<String, Object> res, HttpSession session) {
		//주문상세내역과 결제내역 저장
		System.out.println(res.keySet());
		System.out.println(res.get("buyer_email"));
		MemberDTO mem = (MemberDTO)session.getAttribute("member");
		System.out.println(mem.getId());
		
		return "1";

	}
	
	@GetMapping(value="complete")
	public void showComplete() {
		//주문정보 DB에서 가져와서 화면에 뿌려준다.
	}

}
