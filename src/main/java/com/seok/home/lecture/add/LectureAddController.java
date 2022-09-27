package com.seok.home.lecture.add;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.time.LocalDate;
import java.util.Calendar;

import javax.servlet.http.HttpSession;


import com.seok.home.lecture.LectureDTO;
import com.seok.home.lecture.LectureService;

@Controller
@RequestMapping(value="/lectureAdd/*")
public class LectureAddController {

	@Autowired
	private LectureAddService lectureAddService;
	
	@Autowired
	private LectureService lectureService;
	
	@PostMapping("setLectureAdd")
	@ResponseBody
	public int setLectureAdd(LectureDTO lectureDTO, LectureAddDTO lectureAddDTO, HttpSession session) throws Exception{
		System.out.println("수강완료");
		lectureDTO = lectureService.getDetail(lectureDTO);
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.add(Calendar.MONTH,lectureDTO.getL_date().intValue());
		System.out.println(cal.MONTH);
		java.sql.Date date1 = new java.sql.Date(cal.getTimeInMillis());
		
//		LocalDate now = LocalDate.now();
//		int year=now.getYear();
//		int datOfMonth = now.getDayOfMonth();
//		Long monthValue = (long) now.getDayOfMonth();
//		Long mdate = lectureDTO.getL_date()+monthValue;
		
		
		lectureAddDTO.setS_end(date1);
		//System.out.println(date);
		
		int result = lectureAddService.setLectureAdd(lectureAddDTO);
		return result;
	}
}
