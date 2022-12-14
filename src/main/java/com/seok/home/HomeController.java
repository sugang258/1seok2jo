package com.seok.home;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seok.home.l_board.LectureBoardDTO;
import com.seok.home.l_board.LectureBoardService;
import com.seok.home.lecture.LectureDTO;
import com.seok.home.lecture.LectureService;
import com.seok.home.member.MemberDTO;
import com.seok.home.member.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private LectureService lectureService;
	
	@Autowired
	private LectureBoardService lectureBoardService;
	
	@Autowired
	private MemberService memberService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model, HttpSession session) throws Exception {

		LectureBoardDTO lectureBoardDTO = new LectureBoardDTO();
	    ModelAndView mv = new ModelAndView();
	    List<LectureDTO> list = lectureService.getLectureC();
	    List<LectureDTO> level = lectureService.getLectureLevel();
	    List a = new ArrayList<Double>();
	    List aa = new ArrayList<Double>();

	    
	    for(int i=0;i<list.size();i++) {
	    	lectureBoardDTO.setL_num(list.get(i).getL_num());
	    	double avg = lectureBoardService.getAvgScore(lectureBoardDTO);
	    	avg = Math.round(avg*100)/100.0;
	    	a.add(avg);
	    }
	    for(int i=0;i<level.size();i++) {
	    	lectureBoardDTO.setL_num(level.get(i).getL_num());
	    	double avg = lectureBoardService.getAvgScore(lectureBoardDTO);
	    	avg = Math.round(avg*100)/100.0;
	    	aa.add(avg);
	    }
	    
	    MemberDTO member = (MemberDTO)session.getAttribute("member");
	    if(member!=null) {
	    	 member = memberService.getProfile(member);
	    	 mv.addObject("f_name", member.getMemberFileDTO().getF_name());
	    	 System.out.println(member.getMemberFileDTO().getF_name());
	    }
	    
	    mv.addObject("avgg", aa);
	    mv.addObject("avg", a);
	    mv.addObject("list", list);
	    mv.addObject("level", level);
	    
	    Long cntMember = memberService.getMemberCnt();
	    mv.addObject("cntMember",cntMember);
	    mv.setViewName("index");
		
		return mv;
	}
	
}
