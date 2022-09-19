package com.seok.home.cart;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CartDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE ="com.seok.home.cart.CartDAO.";
	
	public int setCartAdd(CartDTO cartDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setCartAdd", cartDTO);
	}
	
	public int setCartDelete(CartDTO cartDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"setCartDelete", cartDTO);
	}
	
	public List<CartDTO> getCartList(CartDTO cartDTO) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getCartList", cartDTO);
	}
}
