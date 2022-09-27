package com.seok.home.l_board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board/*")
public class LectureBoardController {
	
	@Autowired
	private LectureBoardService lectureBoardService;
	
	@GetMapping("lectureboard_index")
	public ModelAndView getL_boardList()throws Exception {
		ModelAndView mv = new ModelAndView();
		List<LectureBoardDTO> ar = lectureBoardService.getL_boardList();
		
		mv.addObject("list", ar);
		mv.setViewName("board/lectureboard_index");
		
		return mv;
	}
	
	@PostMapping("l_boardAdd")
	@ResponseBody
	public int setL_boardAdd(LectureBoardDTO lectureBoardDTO)throws Exception {
		int result = lectureBoardService.setL_boardAdd(lectureBoardDTO);
		
		return result;
	}
}
