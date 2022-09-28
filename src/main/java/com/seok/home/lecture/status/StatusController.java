package com.seok.home.lecture.status;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.seok.home.lecture.add.LectureAddDTO;

@Controller
@RequestMapping(value="/status/*")
public class StatusController {
	
	@Autowired
	private StatusService statusService;
	
	@PostMapping("setStatusUpdate")
	@ResponseBody
	public int setStatusUpdate(LectureAddDTO lectureAddDTO ,StatusDTO statusDTO,HttpServletRequest request) throws Exception{
		System.out.println("UPDATE");
		//lectureAddDTO = (LectureAddDTO) request.getSession().getAttribute("sign");
		//statusDTO.setS_num(lectureAddDTO.getS_num());
		//statusDTO = statusService.getStatus(statusDTO);
		int result = statusService.setStatusUpdate(statusDTO);
		return result;
	}
}
