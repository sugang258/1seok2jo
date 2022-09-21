package com.seok.home.b_comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/comment/*")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@GetMapping("c_detail")
	@ResponseBody
	public ModelAndView getCommentDetail(CommentDTO commentDTO)throws Exception {
		ModelAndView mv = new ModelAndView();
		commentDTO = commentService.getCommentDetail(commentDTO);
		mv.addObject("commentDTO", commentDTO);
		
		if(commentDTO.getContents()==null) {
			mv.setViewName("");
		}else {
			mv.setViewName("/comment/t_comment");			
		}
		return mv;
	}
	
	@PostMapping("c_detail")
	@ResponseBody
	public int setCommentAdd(CommentDTO commentDTO)throws Exception{
		int result = commentService.setCommentAdd(commentDTO);
		
		return result;
	}
	
	@GetMapping("c_delete")
	@ResponseBody
	public int setCommentDelete(CommentDTO commentDTO)throws Exception{
		int result = commentService.setCommentDelete(commentDTO);
		
		return result;
	}

}
