package com.seok.home.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="cart/*")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("setCartAdd")
	@ResponseBody
	public int setCartAdd(CartDTO cartDTO) throws Exception {
		int result = 1;
		cartDTO.setId("gang");
		List<CartDTO> ar = cartService.getCartList(cartDTO);
		for(int i=0;i<ar.size();i++) {
			if(ar.get(i).getL_num().equals(cartDTO.getL_num())) {
				result = 0;// 이미 장바구니에 있어용
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
