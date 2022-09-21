package com.seok.home.lecture;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.seok.home.util.Pager;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;


@Controller
@RequestMapping(value="lecture/*")
public class LectureController {

	@Autowired
	private LectureService lectureService;
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public ModelAndView getLecture(ModelAndView mv,LectureDTO lectureDTO,Pager pager) throws Exception {
		
		
		
		List<LectureDTO> ar = lectureService.getLecture(pager);
		System.out.println("ar : "+ar.size());
		System.out.println("search :"+pager.getSearch());
		System.out.println(pager.getStartRow());
		System.out.println(pager.getLastRow());
		System.out.println(pager.getKind());
		mv.addObject("list", ar);
		mv.addObject("Pager", pager);
		
		mv.setViewName("lecture/list");
		
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
	
	@GetMapping("detail")
	@ResponseBody
	public ModelAndView getDetail(LectureDTO lectureDTO) throws Exception {
		System.out.println("detail");
		
		lectureDTO = lectureService.getDetail(lectureDTO);
		ModelAndView mv = new ModelAndView();
		mv.addObject("detail", lectureDTO);
		mv.setViewName("/lecture/detail");
		return mv;
	}
	
	
	
	
}
