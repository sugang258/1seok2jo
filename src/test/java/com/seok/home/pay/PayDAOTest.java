package com.seok.home.pay;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.seok.home.MyAbstractTest;
import com.seok.home.lecture.LectureDTO;
import com.seok.home.lecture.LectureFileDTO;

public class PayDAOTest extends MyAbstractTest{

	@Autowired
	PayDAO dao;
	
//	@Test
	public void getSimpleLecture() throws Exception{
		LectureDTO dto = new LectureDTO();
		
		dto.setL_num(2L);
		
		dto = dao.getSimpleLecture(dto);
		for(LectureFileDTO f: dto.getLectureFileDTO()) {
			System.out.println(f.getF_oriname());
		}
		
		assertNotNull(dto);
	}
	
//	@Test
	public void getPaymentList() throws Exception{
		PaymentDTO dto = new PaymentDTO();
		
		dto.setP_uid("1seok2jo-1663730923460");
		
		List<PaymentDTO> lst = dao.getPaymentList(dto);
		for(PaymentDTO pay: lst) {
			for(OrderDTO order: pay.getOrders()) {
				System.out.println(order.getLectureDTO().getL_price());
			}
		}
		
		assertNotNull(lst);
	}
	
//	@Test
	public void savePaymenttest() throws Exception {
		PaymentDTO pay = new PaymentDTO();
		
		pay.setId("id");
		pay.setP_uid("uid");
		pay.setP_point(1L);
		pay.setP_amount(1L);
		pay.setP_realamount(1L);
		pay.setP_method("nme");
		pay.setP_c_name("name");
		pay.setP_c_num(1L);
		pay.setP_c_quota(0L);
		pay.setP_remains(1L);
		pay.setP_at(1234L);
		pay.setP_receipt("hiell");
		pay.setP_c_apply(1111L);
		
		int result = dao.savePayment(pay);
		assertEquals(1, result);
	}
	
//	@Test
	public void saveOrdertest() throws Exception{
		OrderDTO order = new OrderDTO();
		
		order.setL_num(1L);
		order.setP_uid("String");
		order.setO_amount(122L);
		
		int result = dao.saveOrder(order);
		assertEquals(1, result);
	}
	
//	@Test
	public void getPayDetailTest() throws Exception{
		PaymentDTO dto = new PaymentDTO();
		dto.setP_uid("1seok2jo-1663731094101");
		
		dto = dao.getPayDetail(dto);
		
		System.out.println(dto.getP_uid());
		System.out.println(dto.getId());
		System.out.println(dto.getOrders().get(2).getL_num());
		assertNotNull(dto);
		
	}

}
