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
		int result = cartService.setCartAdd(cartDTO);
		return result;
	}
	
	


}
