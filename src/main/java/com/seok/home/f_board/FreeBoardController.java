package com.seok.home.f_board;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.seok.home.b_comment.FreeBoardReplyDTO;
import com.seok.home.l_board.L_heartDTO;
import com.seok.home.member.MemberDTO;
import com.seok.home.s_board.CommentPager;
import com.seok.home.s_board.Pager;

@Controller
@RequestMapping("/board/*")
public class FreeBoardController {
	
	@Autowired
	private FreeBoardService freeBoardService;
	/* 자유게시판 글목록 */	
	@GetMapping("fb_list")
	public ModelAndView getF_boardList(Pager pager)throws Exception {
		ModelAndView mv = new ModelAndView();
		List<FreeBoardDTO> ar = freeBoardService.getF_boardList(pager);
		mv.addObject("pager", pager);
		mv.addObject("list", ar);
		mv.setViewName("/board/fb_list");
		
		/* 추천수 조회 */
		List<Long> heartCount  = new ArrayList<Long>();		
		for(FreeBoardDTO a:ar) {
			Fb_heartDTO fb_heartDTO = new Fb_heartDTO();
			fb_heartDTO.setFb_num(a.getFb_num());
			fb_heartDTO.setId(a.getId());
			
			heartCount.add(freeBoardService.getFb_heartCount(fb_heartDTO));	
		}
		mv.addObject("count_list", heartCount);
		
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
	public ModelAndView getF_boardDetail(FreeBoardDTO freeBoardDTO, HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		freeBoardDTO = freeBoardService.getF_boardDetail(freeBoardDTO);
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO = (MemberDTO) session.getAttribute("member");
		if(memberDTO != null) {
			/* 추천 컬러변경 */
			Fb_heartDTO heartColor;
			Fb_heartDTO fb_heartDTO = new Fb_heartDTO();
			fb_heartDTO.setFb_num(freeBoardDTO.getFb_num());
			fb_heartDTO.setId(memberDTO.getId());
			heartColor = freeBoardService.getFb_heart(fb_heartDTO);
			mv.addObject("color", heartColor);
		}
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
	
	/* 자유게시판 추천등록&취소 */
	@PostMapping("fb_heart")
	@ResponseBody
	public int setFb_heart(Fb_heartDTO fb_heartDTO)throws Exception{
		int result = 0;
		Fb_heartDTO f_DTO = freeBoardService.getFb_heart(fb_heartDTO);
		if(f_DTO == null) {
			freeBoardService.setFb_heartAdd(fb_heartDTO);
			result = 1;
		}else {
			freeBoardService.setFb_heartDelete(fb_heartDTO);
		}
		return result;
	}

	/* 자유게시판 추천갯수 */
	@GetMapping("fb_heart_count")
	@ResponseBody
	public Long getFb_heartCount(Fb_heartDTO fb_heartDTO)throws Exception{
		Long count = freeBoardService.getFb_heartCount(fb_heartDTO);
		return count;
	}
	
	
	/* 자유게시판 댓글 가져오기 */
	@GetMapping("fb_reply")
	@ResponseBody
	public ModelAndView getFb_replyList(CommentPager commentPager)throws Exception{
		ModelAndView mv = new ModelAndView();
		commentPager.getRowNum();
		List<FreeBoardReplyDTO> ar = freeBoardService.getFb_replyList(commentPager);
		
		//자유게시판 댓글 수-더보기 페이징
		FreeBoardReplyDTO freeBoardReplyDTO = new FreeBoardReplyDTO();
		freeBoardReplyDTO.setFb_num(commentPager.getFb_num());
		Long count = freeBoardService.getReplyCount(freeBoardReplyDTO);
		Long totalPage = commentPager.getTotalPage(count);
		
		mv.addObject("commentPager", commentPager);
		mv.addObject("totalPage", totalPage);
		mv.addObject("reply_count", count);
		mv.addObject("list", ar);
		mv.setViewName("comment/all_comment");
		return mv;
	}
	
	/* 자유게시판 댓글작성 */
	@PostMapping("fb_replyAdd")
	@ResponseBody
	public int setFb_replyAdd(FreeBoardReplyDTO freeBoardReplyDTO)throws Exception{
		int result = freeBoardService.setFb_replyAdd(freeBoardReplyDTO);
		return result;
	}
	
	/* 자유게시판 댓글삭제 */
	@PostMapping("fb_replyDelete")
	@ResponseBody
	public int setFb_replyDelete(FreeBoardReplyDTO freeBoardReplyDTO)throws Exception{
		int result = freeBoardService.setFb_replyDelete(freeBoardReplyDTO);
		return result;
	}
	
	/* 자유게시판 댓글수 */
	@GetMapping("fb_reply_count")
	@ResponseBody
	public Long getReplyCount(FreeBoardReplyDTO freeBoardReplyDTO)throws Exception{
		Long count = freeBoardService.getReplyCount(freeBoardReplyDTO);
		return count;
	}

}
