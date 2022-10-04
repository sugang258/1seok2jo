package com.seok.home.f_board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.seok.home.b_comment.FreeBoardReplyDTO;

@Controller
@RequestMapping("/board/*")
public class FreeBoardController {
	
	@Autowired
	private FreeBoardService freeBoardService;
	/* 자유게시판 글목록 */	
	@GetMapping("fb_list")
	public ModelAndView getF_boardList()throws Exception {
		ModelAndView mv = new ModelAndView();
		List<FreeBoardDTO> ar = freeBoardService.getF_boardList();
		mv.addObject("list", ar);
		mv.setViewName("/board/fb_list");
		
		return mv;
	}
	
	/* 자유게시판 글작성 */
	@GetMapping("fb_add")
	public String getF_boardAdd()throws Exception{
		return "/board/fb_add";
	}
	@PostMapping("fb_add")
	public String setF_boardAdd(FreeBoardDTO freeBoardDTO)throws Exception{
		int result = freeBoardService.setF_boardAdd(freeBoardDTO);
		return "redirect: ../board/fb_list";
	}
	
	/* 자유게시판 글 상세보기 */
	@GetMapping("fb_detail")
	public ModelAndView getF_boardDetail(FreeBoardDTO freeBoardDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		freeBoardDTO = freeBoardService.getF_boardDetail(freeBoardDTO);
		mv.addObject("freeBoardDTO", freeBoardDTO);
		mv.setViewName("/board/fb_detail");
		return mv;
	}
	
	/* 자유게시판 글 수정 */
	@PostMapping("fb_update")
	@ResponseBody
	public int setF_boardUpdate(FreeBoardDTO freeBoardDTO)throws Exception{
		int result = freeBoardService.setF_boardUpdate(freeBoardDTO);
		return result;
	}
	
	/* 자유게시판 글 삭제 */
	@PostMapping("fb_delete")
	@ResponseBody
	public int setF_boardDelete(FreeBoardDTO freeBoardDTO)throws Exception{
		int result = freeBoardService.setF_boardDelete(freeBoardDTO);
		return result;
	}
	
	/* 자유게시판 댓글 가져오기 */
	@GetMapping("fb_reply")
	@ResponseBody
	public ModelAndView getFb_replyList(FreeBoardReplyDTO freeBoardReplyDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		List<FreeBoardReplyDTO> ar = freeBoardService.getFb_replyList(freeBoardReplyDTO);
		mv.addObject("list", ar);
		mv.setViewName("comment/all_comment");
		return mv;
	}


}
