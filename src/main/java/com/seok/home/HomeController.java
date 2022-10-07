package com.seok.home;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.seok.home.lecture.LectureDTO;
import com.seok.home.lecture.LectureService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private LectureService lectureService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model) throws Exception {

	    ModelAndView mv = new ModelAndView();
	    List<LectureDTO> list = lectureService.getLectureC();
	    List<LectureDTO> level = lectureService.getLectureLevel();
	    
	    mv.addObject("list", list);
	    mv.addObject("level", level);
	    mv.setViewName("index");
		
		return mv;
	}
	
}
