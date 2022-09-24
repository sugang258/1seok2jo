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
		CommentDTO t_comment = commentService.getCommentDetail(commentDTO);
		List<CommentDTO> tCommentDTOs = commentService.getT_CommentList(commentDTO);
		Long result = commentService.getComment_Count(commentDTO);
		mv.addObject("commentDTO", t_comment);
		mv.addObject("count", result);
		mv.setViewName("comment/t_comment");
		if(tCommentDTOs.size() != 0) {
		mv.addObject("tCommentDTO", tCommentDTOs);
		}
		
		if(t_comment==null) {
			mv.setViewName("comment/blank");
		}else {
			mv.setViewName("comment/t_comment");			
		}
		return mv;
	}
	
	//강사답글 추가
	@PostMapping("c_add")
	@ResponseBody
	public int setCommentAdd(CommentDTO commentDTO)throws Exception{
		int result = commentService.setCommentAdd(commentDTO);
		
		return result;
	}
	
	//강사 답글 삭제
	@PostMapping("c_delete")
	@ResponseBody
	public int setCommentDelete(CommentDTO commentDTO)throws Exception{
		int result = commentService.setCommentDelete(commentDTO);
		if(result == 1) {
			//강사답글 삭제 시, 해당 댓글 삭제
			commentService.setAllCommentDelete(commentDTO);
		}else {
			result = 0;
		}
		return result;
	}
	
	//강사답글 수정
	@PostMapping("comment_update")
	@ResponseBody
	public int setCommentUpdate(CommentDTO commentDTO)throws Exception{
		int result = commentService.setCommentUpdate(commentDTO);
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
	
	
	//강사답글 - 댓글
	@PostMapping("t_comment")
	@ResponseBody
	public ModelAndView getT_CommentList(CommentDTO commentDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		List<CommentDTO> ar = commentService.getT_CommentList(commentDTO);
		mv.addObject("list", ar);
		mv.setViewName("comment/all_comment");
		
		return mv;
	}
	
	@PostMapping("t_commentAdd")
	@ResponseBody
	public int setT_CommentAdd(CommentDTO commentDTO)throws Exception{
		int result = commentService.setT_CommentAdd(commentDTO);
		
		return result;
	}
	
	@PostMapping("t_commentDelete")
	@ResponseBody
	public int setT_CommentDelete(CommentDTO commentDTO)throws Exception{
		int result = commentService.setT_CommentDelete(commentDTO);
		return result;
	}
	

}
