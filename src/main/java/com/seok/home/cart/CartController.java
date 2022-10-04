package com.seok.home.cart;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.seok.home.lecture.add.LectureAddDTO;
import com.seok.home.lecture.add.LectureAddService;
import com.seok.home.member.MemberDTO;

@Controller
@RequestMapping(value="cart/*")
public class CartController {
	
	@Autowired
	private CartService cartService;
	@Autowired
	private LectureAddService lectureAddService;
	
	@PostMapping("setCartAdd")
	@ResponseBody
	public int setCartAdd(CartDTO cartDTO,HttpServletRequest request) throws Exception {
		int result = 1;
		MemberDTO mem = (MemberDTO)request.getSession().getAttribute("member");
		cartDTO.setId(mem.getId());
		List<CartDTO> ar = cartService.getCartList(cartDTO);
		//이미 수강한 상태인 강의를 장바구니에 넣는 것 불가
		//수강 테이블에서
		LectureAddDTO lectureAddDTO = new LectureAddDTO();
		lectureAddDTO.setId(mem.getId());
		lectureAddDTO.setL_num(cartDTO.getL_num());
		lectureAddDTO = lectureAddService.getLectureCancel(lectureAddDTO);
		//System.out.println(lectureAddDTO);
		//lectureAddDTO == null => 수강 신청 전
		for(int i=0;i<ar.size();i++) {
			if(ar.get(i).getL_num().equals(cartDTO.getL_num()) || lectureAddDTO.getS_num() != null) {
				result = 0;// 이미 장바구니에 있거나 수강 신청이 되어있는 것
				break;
			}else {
				result = 1;
			}
		}
		if(result == 1) {
			cartService.setCartAdd(cartDTO);
		}
		
		return result;
	}
	
	@PostMapping("setCartDelete")
	@ResponseBody
	public int setCartDelete(CartDTO cartDTO) throws Exception {
		int result = cartService.setCartDelete(cartDTO);
		return result;
	}


}
