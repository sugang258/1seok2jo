package com.seok.home.cart;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.seok.home.MyAbstractTest;

public class CartTest extends MyAbstractTest  {

	@Autowired
	private CartDAO cartDAO;
	
	//@Test
	public void setCartAdd() throws Exception {
		CartDTO cartDTO = new CartDTO();
		
		cartDTO.setId("GANG");
		cartDTO.setL_num(2L);
		
		int result = cartDAO.setCartAdd(cartDTO);
		
		assertEquals(1,result);
	}
	@Test
	public void setCartDelete() throws Exception{
		CartDTO cartDTO = new CartDTO();
		
		cartDTO.setC_num(2L);
		
		int result = cartDAO.setCartDelete(cartDTO);
		
		assertEquals(1,result);
		
	}

}
