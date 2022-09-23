package com.seok.home.b_comment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	//강사 답글 불러오기 및 댓글 불러오기 
	//강사 답글을 가져올때 댓글DTO의 값을 리스트에 담아서 해당 리스트를 Model로 보내준다.
	@GetMapping("c_detail")
	@ResponseBody
	public ModelAndView getCommentDetail(CommentDTO commentDTO)throws Exception {
		ModelAndView mv = new ModelAndView();
		commentDTO = commentService.getCommentDetail(commentDTO);
		List<CommentDTO> tCommentDTOs = commentService.getT_CommentList(commentDTO);
		mv.addObject("commentDTO", commentDTO);
		mv.addObject("tCommentDTO", tCommentDTOs);
		
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
	
	@PostMapping("sb_commentDelete")
	@ResponseBody
	public int setSB_CommentDelete(CommentDTO commentDTO)throws Exception{
		int result = commentService.setSB_CommentDelete(commentDTO);
		return result;
	}
	
	@PostMapping("commentCount")
	@ResponseBody
	public Long getComment_Count(CommentDTO commentDTO)throws Exception{
		Long result = commentService.getComment_Count(commentDTO);
		System.out.println(result);
		return result;
	}
	
	//강사답글 - 댓글
	@PostMapping("teacher_comment")
	@ResponseBody
	public ModelAndView getT_CommentList(CommentDTO commentDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		List<CommentDTO> ar = commentService.getT_CommentList(commentDTO);
		mv.addObject("list", ar);
		mv.setViewName("comment/all_comment");
		
		return mv;
	}
	
	public int setT_CommentAdd(CommentDTO commentDTO)throws Exception{
		int result = commentService.setT_CommentAdd(commentDTO);
		
		return result;
	}

}
