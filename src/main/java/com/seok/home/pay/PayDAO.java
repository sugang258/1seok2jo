package com.seok.home.pay;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.seok.home.member.MemberDTO;

@Repository
public class PayDAO {
	
	@Autowired
	private SqlSession session;
	private final String NAMESPACE = "com.seok.home.pay.PayDAO.";
	
	
	public int savePayment(PaymentDTO dto)throws Exception{
		return session.insert(NAMESPACE+"savePayment", dto);
	}
	
	public int saveOrder(OrderDTO orderDTO) throws Exception{
		return session.insert(NAMESPACE+"saveOrder", orderDTO);
	}

}
