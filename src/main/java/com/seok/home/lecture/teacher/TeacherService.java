package com.seok.home.lecture.teacher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seok.home.pay.OrderDTO;
import com.seok.home.pay.PayDAO;
import com.seok.home.pay.PaymentDTO;

@Service
public class TeacherService {

	@Autowired
	private TeacherDAO teacherDAO;
	@Autowired
	private PayDAO payDAO;
	
	public TeacherDTO getTeacherCheck(TeacherDTO teacherDTO) throws Exception{
	    return teacherDAO.getTeacherCheck(teacherDTO);
	}
	
	public List<OrderDTO> getTeacherList(TeacherPager pager) throws Exception{
		pager.calNum(payDAO.getteacherListTotal(pager));
		return payDAO.getteacherList(pager);
	}
	
	public Long getOamountTotal(TeacherPager pager) throws Exception{
		return payDAO.getOamountTotal(pager);
	}
	

	
}
