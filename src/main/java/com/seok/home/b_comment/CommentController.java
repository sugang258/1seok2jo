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

import com.seok.home.s_board.CommentPager;
import com.seok.home.s_board.StudyBoardDTO;
import com.seok.home.s_board.StudyBoardService;

@Controller
@RequestMapping("/comment/*")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	@Autowired
	private StudyBoardService studyBoardService;
	
	//강사 답글 불러오기 및 댓글 불러오기 
	//강사 답글을 가져올때 댓글DTO의 값을 리스트에 담아서 해당 리스트를 Model로 보내준다.
	@GetMapping("c_detail")
	@ResponseBody
	public ModelAndView getCommentDetail(CommentDTO commentDTO)throws Exception {
		ModelAndView mv = new ModelAndView();
		CommentDTO t_comment = commentService.getCommentDetail(commentDTO);
		CommentPager commentPager = new CommentPager();
		commentPager.setSb_num(commentDTO.getSb_num());
		
		//댓글 더보기(댓글 수, 총페이지 수 보내기)
		commentPager.getRowNum();
		List<CommentDTO> tCommentDTOs = commentService.getT_CommentList(commentPager);
		Long result = commentService.getComment_Count(commentDTO);
		
		Long totalPage = commentPager.getTotalPage(result);	
		mv.addObject("commentPager", commentPager);
		mv.addObject("totalPage", totalPage);
		mv.addObject("count", result);
		
		mv.addObject("commentDTO", t_comment);
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
	public ModelAndView getSB_CommentList(CommentPager commentPager)throws Exception{
		ModelAndView mv = new ModelAndView();
		commentPager.getRowNum();
		List<CommentDTO>ar = commentService.getSB_CommentList(commentPager);
		//게시판 댓글 수
		StudyBoardDTO studyBoardDTO = new StudyBoardDTO();
		studyBoardDTO.setSb_num(commentPager.getSb_num());
		Long count = studyBoardService.getCount(studyBoardDTO);
		Long totalPage = commentPager.getTotalPage(count);
		
		mv.addObject("commentPager", commentPager);
		mv.addObject("totalPage", totalPage);
		mv.addObject("reply_count", count);
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
	public ModelAndView getT_CommentList(CommentPager commentPager)throws Exception{
		ModelAndView mv = new ModelAndView();
		commentPager.getRowNum();
		List<CommentDTO> ar = commentService.getT_CommentList(commentPager);
		
		mv.addObject("list", ar);
		mv.setViewName("comment/t_comment");
		
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
