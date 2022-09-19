package com.seok.home.lecture;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;


@Controller
@RequestMapping(value="lecture/*")
public class LectureController {

	@Autowired
	private LectureService lectureService;
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public ModelAndView getLecture(ModelAndView mv,LectureDTO lectureDTO) throws Exception {
		
		List<LectureDTO> ar = lectureService.getLecture();
		mv.addObject("list", ar);
		
		return mv;
	}
	
	@RequestMapping(value="add", method=RequestMethod.GET)
	public String setLecture() throws Exception {
		System.out.println("강의 추가 GET");
		return "lecture/add";
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public ModelAndView setLecture(LectureDTO lectureDTO, HttpSession session, MultipartFile[] files,LectureVideoDTO lectureVideoDTO) throws Exception {
		System.out.println("강의 추가 POST");
		
		ModelAndView mv = new ModelAndView();
		lectureDTO.setId("gang");
		int result = lectureService.setLecture(lectureDTO, files, session.getServletContext(),lectureVideoDTO);
		
		mv.addObject("result", result);
		mv.setViewName("redirect:./list");
		
		return mv;
	}
	
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public String getDetailVideo(LectureDTO lectureDTO) throws Exception {
		
		System.out.println("detail");
		return "lecture/detail";
	}
	
	
}
