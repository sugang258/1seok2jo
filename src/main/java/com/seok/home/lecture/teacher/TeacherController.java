package com.seok.home.lecture.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seok.home.member.MemberDTO;

@Controller
@RequestMapping("/teacher/*")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;
	
	@GetMapping("/salesList")
	public String getTeacherList() throws Exception{
		return "pay/teacherList";
	}

	
}
