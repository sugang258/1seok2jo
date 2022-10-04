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
	public void updatePaymentRemainsTest() throws Exception{
		PaymentDTO dto = new PaymentDTO();
		
		dto.setP_uid("1seok2jo-1664359791350");
		dto.setP_remains(55000L);
		
		int result = dao.updatePaymentRemains(dto);
		
		assertEquals(1, result);
	}
	
//	@Test
	public void getPaymentRemainsTest() throws Exception{
//		String p_uid= "1seok2jo-1664359791350";
////		Long result = dao.getPaymentRemains(p_uid);
//		System.out.println(result);
//		
//		assertNotNull(result);
	}
	
//	@Test
	public void getOrderTest() throws Exception{
		OrderDTO orderDTO = new OrderDTO();
		
		orderDTO.setO_num(49L);
		
		orderDTO = dao.getOrder(orderDTO);
		
		System.out.println(orderDTO.getL_num());
		System.out.println(orderDTO.getP_uid());
		System.out.println(orderDTO.getLectureDTO().getL_name());
		System.out.println(orderDTO.getLectureDTO().getL_price());
		
		assertNotNull(orderDTO);
	}
	
//	@Test
	public void getSimpleLecture() throws Exception{
		LectureDTO dto = new LectureDTO();
		
		dto.setL_num(2L);
		

		for(LectureFileDTO f: dto.getLectureFileDTO()) {
			System.out.println(f.getF_oriname());
		}
		
		assertNotNull(dto);
	}
	
//	@Test
	public void getPaymentList() throws Exception{
		PaymentDTO dto = new PaymentDTO();
		
		dto.setP_uid("1seok2jo-1664515867547");
		
		List<PaymentDTO> lst = dao.getPaymentList(dto);
		
		for(PaymentDTO pay: lst) {
			System.out.println(pay.getId());
			System.out.println(pay.getRefunds().get(0).getPr_reason());
			for(OrderDTO order: pay.getOrders()) {
				System.out.println(order.getLectureDTO().getL_name());
				System.out.println(order.getLectureDTO().getId());
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
		dto.setP_uid("1seok2jo-1664515867547");
		
		dto = dao.getPayDetail(dto);
		
		System.out.println(dto.getP_uid());
		System.out.println(dto.getId());
		System.out.println(dto.getOrders().get(0).getL_num());
		System.out.println(dto.getOrders().get(0).getPr_num());
		assertNotNull(dto.getRefunds());
		
	}

}
