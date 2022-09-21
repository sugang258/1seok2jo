package com.seok.home.b_comment;

import java.util.List;

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
		
		if(commentDTO==null) {
			mv.setViewName("comment/blank");
		}else {
			mv.setViewName("comment/t_comment");			
		}
		return mv;
	}
	
	@PostMapping("c_detail")
	@ResponseBody
	public int setCommentAdd(CommentDTO commentDTO)throws Exception{
		int result = commentService.setCommentAdd(commentDTO);
		
		return result;
	}
	
	@PostMapping("c_delete")
	@ResponseBody
	public int setCommentDelete(CommentDTO commentDTO)throws Exception{
		int result = commentService.setCommentDelete(commentDTO);
		
		return result;
	}
	
	//게시글 댓글
	@GetMapping("sb_comment")
	@ResponseBody
	public ModelAndView getSB_CommentList(CommentDTO commentDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		List<CommentDTO>ar = commentService.getSB_CommentList(commentDTO);
		mv.addObject("list", ar);
		mv.setViewName("comment/all_comment");
		
		return mv;
	}

	@PostMapping("sb_commentAdd")
	@ResponseBody
	public int setSB_CommentAdd(CommentDTO commentDTO)throws Exception{
		int result = commentService.setSB_CommentAdd(commentDTO);
		return result;
	}

}
