package com.seok.home.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seok.home.lecture.LectureDAO;
import com.seok.home.lecture.LectureDTO;

@Service
public class CartService {
	
	@Autowired
	private CartDAO cartDAO;
	
	@Autowired
	private LectureDAO lectureDAO;
	
	public int setCartAdd(CartDTO cartDTO) throws Exception {
		
		return cartDAO.setCartAdd(cartDTO);
		
	}
	
	public List<CartDTO> getCartList(CartDTO cartDTO) throws Exception {
		return cartDAO.getCartList(cartDTO);
	}
	
	public List<LectureDTO> getCartDetail(CartDTO cartDTO) throws Exception {
		return lectureDAO.getCartDetail(cartDTO);
	}
	
	public int setCartDelete(CartDTO cartDTO) throws Exception{
		return cartDAO.setCartDelete(cartDTO);
	}
	
	public CartDTO getCartOne(CartDTO cartDTO) throws Exception{
	    return cartDAO.getCartOne(cartDTO);
	}
	
	public int setCartLM(CartDTO cartDTO) throws Exception{
	    return cartDAO.setCartLM(cartDTO);
	}

}
