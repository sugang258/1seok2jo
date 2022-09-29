package com.seok.home.lecture.add;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.time.LocalDate;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import com.seok.home.lecture.LectureDTO;
import com.seok.home.lecture.LectureService;
import com.seok.home.lecture.LectureVideoDTO;
import com.seok.home.lecture.status.StatusDTO;
import com.seok.home.lecture.status.StatusService;
import com.seok.home.member.MemberDTO;

@Controller
@RequestMapping(value="/lectureAdd/*")
public class LectureAddController {
 
	@Autowired
	private LectureAddService lectureAddService;
	@Autowired
	private LectureService lectureService;
	@Autowired
	private StatusService statusService;
	
	@PostMapping("setLectureAdd")
	@ResponseBody
	public int setLectureAdd(LectureDTO lectureDTO, LectureAddDTO lectureAddDTO, HttpServletRequest request,HttpSession session) throws Exception{
		int result = 1;
		System.out.println("수강완료");
		
		lectureDTO = lectureService.getDetail(lectureDTO);
		MemberDTO mem = (MemberDTO)request.getSession().getAttribute("member");
		List<LectureAddDTO> list = lectureAddService.getLectureAddAll();
		for(int i=0;i<list.size(); i++) {
			if(list.get(i).getId().equals(mem.getId()) && list.get(i).getL_num().equals(lectureAddDTO.getL_num())) {
				result = 0;
			}else {
				result = 1;
			}
		}
		if(result == 1) {
			
			Date now = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(now);
			cal.add(Calendar.MONTH,lectureDTO.getL_date().intValue());
			System.out.println(cal.MONTH);
			java.sql.Date date1 = new java.sql.Date(cal.getTimeInMillis());
			
			lectureAddDTO.setS_end(date1);
			
			
			lectureAddService.setLectureAdd(lectureAddDTO);
			lectureAddService.setLectureCount(lectureAddDTO);
			
			StatusDTO statusDTO = new StatusDTO();
			List<LectureVideoDTO> ar = statusService.getVideoList(lectureDTO);
			lectureAddDTO.setL_num(lectureDTO.getL_num());
			//로그인 정보 가져오기
			lectureAddDTO.setId(mem.getId());
			lectureAddDTO = lectureAddService.getLectureAdd(lectureAddDTO);
			
			for(int i=0; i<ar.size();i++) {
				statusDTO.setS_num(lectureAddDTO.getS_num());
				statusDTO.setV_num(ar.get(i).getV_num());
				//System.out.println(ar.get(i).getV_num());
				//System.out.println(lectureAddDTO.getS_num());
				statusService.setStatusAdd(statusDTO);
			}
		}
		//session.setAttribute("sign", lectureAddDTO);
		return result;
	}
}
