package com.seok.home.lecture.status;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.seok.home.lecture.LectureDTO;
import com.seok.home.lecture.LectureService;
import com.seok.home.lecture.add.LectureAddDTO;
import com.seok.home.lecture.add.LectureAddService;
import com.seok.home.member.MemberDTO;

@Controller
@RequestMapping(value="/status/*")
public class StatusController {
	
	@Autowired
	private StatusService statusService;
	@Autowired
	private LectureAddService lectureAddService;

	
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
	
	@GetMapping("sign")
	public ModelAndView getSignList(LectureAddDTO lectureAddDTO, HttpServletRequest request)throws Exception{
		System.out.println("진도페이지");
		ModelAndView mv = new ModelAndView();
		//LectureDTO lectureDTO = new LectureDTO();
		MemberDTO mem = (MemberDTO)request.getSession().getAttribute("member");
		System.out.println(lectureAddDTO.getS_num());
		   
    		lectureAddDTO.setId(mem.getId());
    		List<LectureDTO> ar = statusService.getSignList(lectureAddDTO);
    		List<LectureAddDTO> end = lectureAddService.getLectureEnd(lectureAddDTO);
    		if(ar.size() == 0) {
    		    mv.setViewName("/lecture/status");
    		}else {
    		Long count = 0L;
    		Long total = 0L;
    		List<Double> status = new ArrayList<Double>();
    		double percent=0L;
        		for(int i=0; i<ar.size();i++) {
        			lectureAddDTO.setId(mem.getId());
        			lectureAddDTO.setS_num(ar.get(i).getLectureAddDTO().getS_num());
        			count = statusService.getStatusCount(lectureAddDTO);
        			total = statusService.getStatusTotal(lectureAddDTO);
        			percent =((double)count/(double)total)*100;
        			
        			System.out.println("count"+count);
        			System.out.println("t"+total);
        			System.out.println("percent"+percent);
        			status.add(i, percent);
        			count =0L;
        			total=0L;
        			percent=0L;
        		}
        		
    		System.out.println(ar.size());
    		mv.addObject("end", end);
    		mv.addObject("ar", ar);
    		mv.addObject("status", status);
    		mv.setViewName("/lecture/status");
            }
		return mv;
        }
    	
 }
