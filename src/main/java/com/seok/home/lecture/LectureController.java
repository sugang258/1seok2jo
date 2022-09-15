package com.seok.home.lecture;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;


@Controller
@RequestMapping(value="lecture/*")
public class LectureController {

	private LectureService lectureService;
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String getLecture(Model model) throws Exception {
		
//		List<LectureDTO> ar = lectureService.getLecture();
//		
//		model.addAttribute("list", ar);
		
		return "lecture/list";
	}
}
