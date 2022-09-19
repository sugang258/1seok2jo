package com.seok.home.s_board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board/*")
public class StudyBoardController {

	@Autowired
	private StudyBoardService studyBoardService;
	
	@GetMapping("sb_list")
	public ModelAndView setBoardList()throws Exception{
		List<StudyBoardDTO> ar = studyBoardService.getBoardList();
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", ar);
		mv.setViewName("board/sb_list");
		
		return mv;
	}
	
	@GetMapping("sb_detail")
	public void getBoardDetail()throws Exception {
		
	}
	
	@GetMapping("sb_add")
	public void setBoardAdd()throws Exception {
		
	}
}
