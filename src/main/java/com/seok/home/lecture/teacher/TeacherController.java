package com.seok.home.lecture.teacher;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.seok.home.member.MemberDTO;
import com.seok.home.pay.OrderDTO;
import com.seok.home.pay.PaymentDTO;

@Controller
@RequestMapping("/teacher/*")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;
	
	@GetMapping("/salesList")
	public String getTeacherList() throws Exception{
		return "pay/teacherList";
	}
	
	@PostMapping("/salesList")
	@ResponseBody
	public ModelAndView getTeacherList(TeacherPager pager, ModelAndView mv, HttpSession session) throws Exception{
		
		MemberDTO member = (MemberDTO)session.getAttribute("member");
		
		pager.setTeacher(member.getId());
		
		List<OrderDTO> orderList = teacherService.getTeacherList(pager);
		mv.addObject("orderList", orderList);
		mv.addObject("pager", pager);
		mv.setViewName("pay/teacherListPost");
		return mv;
	}
	
	@PostMapping("/oamountTotal")
	@ResponseBody
	public String getOamountTotal(TeacherPager pager,HttpSession session)throws Exception{
		MemberDTO member = (MemberDTO)session.getAttribute("member");
		
		pager.setTeacher(member.getId());
		
		String result = teacherService.getOamountTotal(pager)+"";
		
		return result;
	}

	
}
