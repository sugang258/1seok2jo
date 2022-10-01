package com.seok.home.f_board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board/*")
public class FreeBoardController {
	
	@Autowired
	private FreeBoardService freeBoardService;
	
	@GetMapping("fb_list")
	public ModelAndView getF_boardList()throws Exception {
		ModelAndView mv = new ModelAndView();
		List<FreeBoardDTO> ar = freeBoardService.getF_boardList();
		System.out.println(ar.indexOf(ar));
		mv.addObject("list", ar);
		mv.setViewName("/board/fb_list");
		
		return mv;
	}

}
