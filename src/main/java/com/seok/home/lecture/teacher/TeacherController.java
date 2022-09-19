package com.seok.home.lecture.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seok.home.member.MemberDTO;

@Controller
@RequestMapping("/member/*")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;
	

	
}
