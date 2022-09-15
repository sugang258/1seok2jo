package com.seok.home.lecture;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;


@Controller
@RequestMapping(value="lecture/*")
public class LectureController {

	@Autowired
	private LectureService lectureService;
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String getLecture(Model model) throws Exception {
		
		List<LectureDTO> ar = lectureService.getLecture();
		
		model.addAttribute("list", ar);
		
		return "lecture/list";
	}
	
	@RequestMapping(value="add", method=RequestMethod.GET)
	public String setLecture() throws Exception {
		System.out.println("강의 추가 GET");
		return "lecture/add";
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public ModelAndView setLecture(LectureDTO lectureDTO) throws Exception {
		System.out.println("강의 추가 POST");
		
		ModelAndView mv = new ModelAndView();
		
		lectureDTO.setId("gang");
		
		lectureService.setLecture(lectureDTO);
		
		mv.setViewName("redirect:./list");
		
		return mv;
	}
}
