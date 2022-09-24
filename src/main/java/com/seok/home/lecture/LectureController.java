package com.seok.home.lecture;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.YamlProcessor.ResolutionMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

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
		session.setAttribute("add", lectureDTO);
		mv.addObject("result", result);
		mv.setViewName("redirect:./list");
		
		return mv;
	}
	
	@GetMapping("detail")
	@ResponseBody
	public ModelAndView getDetail(LectureDTO lectureDTO, HttpSession session) throws Exception {
		System.out.println("detail");
		
		lectureDTO = lectureService.getDetail(lectureDTO);
		System.out.println(lectureDTO);
		List<LectureVideoDTO> ar  = lectureDTO.getLectureVideoDTO();
		List<LectureFileDTO> file = lectureDTO.getLectureFileDTO();
		System.out.println("ar : "+ar.size());
		System.out.println("file : "+ file.size());
		
		//List<LectureDTO> ar = lectureService.getDetailVideo(lectureDTO);
		ModelAndView mv = new ModelAndView();
		session.setAttribute("detail", lectureDTO);
		mv.addObject("detail", lectureDTO);
		mv.addObject("ar", ar);
		mv.addObject("file", file);
		//mv.addObject("video", ar);
		mv.setViewName("/lecture/detail");
		return mv;
	}
	
	@GetMapping("update")
	public ModelAndView setUpdate(LectureDTO lectureDTO,HttpSession session) throws Exception {
		
		System.out.println("update");
		ModelAndView mv = new ModelAndView();
		
		lectureDTO = (LectureDTO) session.getAttribute("detail");
		List<LectureVideoDTO> ar = lectureDTO.getLectureVideoDTO();
		System.out.println("video ar: "+ar.size());
		System.out.println("l_num : "+lectureDTO.getL_num());
		Long l_num = lectureDTO.getL_num();
		session.setAttribute("update", l_num);
		mv.addObject("video", ar);
		mv.addObject("update", lectureDTO);
		mv.setViewName("/lecture/update");
		//int result = lectureService.setUpdate(lectureDTO);
		
		return mv;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public ModelAndView setUpdate(LectureDTO lectureDTO, ModelAndView mv,MultipartFile[] files,HttpSession session,LectureVideoDTO lectureVideoDTO) throws Exception{
		System.out.println("update post");
		//System.out.println("l_nummmm"+lectureDTO.getL_num());
		lectureService.setUpdate(lectureDTO,lectureVideoDTO);
		
		mv.addObject("dto", lectureDTO);
		mv.setViewName("redirect:./detail?l_num="+lectureDTO.getL_num());
		
		return mv;
	}
	
	@PostMapping("setVideoDelete")
	@ResponseBody
	public int setVideoDelete(LectureVideoDTO lectureVideoDTO) throws Exception {
		System.out.println("동영상 삭제");
		
		int result = lectureService.setVideoDelete(lectureVideoDTO);
		
		return result;
	}
	
	@PostMapping("setDelete")
	@ResponseBody
	public int setDelete(LectureDTO lectureDTO) throws Exception {
		lectureService.setFileDelete(lectureDTO);
		lectureService.setVideoDele(lectureDTO);
		int result = lectureService.setDelete(lectureDTO);
		
		return result;
	}
	
	@PostMapping("setFileUpdate")
	@ResponseBody
	public ModelAndView setFileUpdate(LectureDTO lectureDTO, MultipartFile[] files, HttpSession session) throws Exception{
		System.out.println("파일 업데이트");
		ModelAndView mv = new ModelAndView();
		LectureFileDTO lectureFileDTO = new LectureFileDTO();
		lectureDTO = (LectureDTO) session.getAttribute("detail");
		lectureFileDTO.setL_num(lectureDTO.getL_num());
		System.out.println(lectureFileDTO.getL_num());
		int result = lectureService.setFileUpdate(lectureFileDTO,files,session.getServletContext());
		
		mv.setViewName("redirect:./detail?l_num="+lectureDTO.getL_num());
		
		
		return mv;
		
	}
	
	@PostMapping("setVideoUpdate")
	@ResponseBody
	public int setVideoUpdate(LectureVideoDTO lectureVideoDTO) throws Exception{
		int result = lectureService.setVideoUpdate(lectureVideoDTO);
		return result;
	}
	
	
	
	
}
