package com.seok.home.n_board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.seok.home.b_comment.NoticeReplyDTO;

@Controller
@RequestMapping("/board/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	/* 공지사항 목록 */
	@GetMapping("notice")
	public ModelAndView getNoticeList()throws Exception {
		ModelAndView mv = new ModelAndView();
		List<NoticeDTO> ar = noticeService.getNoticeList();
		mv.addObject("list", ar);
		mv.setViewName("/board/notice");
		
		return mv;
	}
	
	/* 공지사항 글작성 */
	@GetMapping("nb_add")
	public void getNoticeAdd()throws Exception{	
	}
	@PostMapping("nb_add")
	public String setNoticeAdd(NoticeDTO noticeDTO)throws Exception {
		int result = noticeService.setNoticeAdd(noticeDTO);
		return "redirect:notice";
	}
	
	/* 공지사항 상세보기 */
	@GetMapping("nb_detail")
	public ModelAndView getNoticeDetail(NoticeDTO noticeDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		noticeDTO = noticeService.getNoticeDetail(noticeDTO);
		mv.addObject("noticeDTO", noticeDTO);
		mv.setViewName("board/nb_detail");
		
		return mv;
	}
	
	/* 공지사항 글수정 */
	@PostMapping("nb_update")
	@ResponseBody
	public int setNoticeUpdate(NoticeDTO noticeDTO)throws Exception {
		int result = noticeService.setNoticeUpdate(noticeDTO);
		return result;
	}
	
	/* 공지사항 글삭제 */
	@GetMapping("nb_delete")
	public String setNoticeDelete(NoticeDTO noticeDTO)throws Exception {
		int result = noticeService.setNoticeDelete(noticeDTO);
		return "redirect:./notice";
	}
	
	/* 공지사항 댓글목록 */
	@PostMapping("nb_detail")
	@ResponseBody
	public ModelAndView getNoticeDetail(NoticeReplyDTO noticeReplyDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		/* 공지사항 댓글 불러오기 */
		List<NoticeReplyDTO> ar = noticeService.getReplyList(noticeReplyDTO);
		mv.addObject("list", ar);
		mv.setViewName("board/noticeReply");
		return mv;
	}
	
	/* 공지사항 댓글작성 */
	@PostMapping("reply_add")
	@ResponseBody
	public int setReplyAdd(NoticeReplyDTO noticeReplyDTO)throws Exception{
		int result = noticeService.setReplyAdd(noticeReplyDTO);
		return result;
	}
	
	/* 공지사항 댓글삭제 */
	@PostMapping("reply_delete")
	@ResponseBody
	public int setReplyDelete(NoticeReplyDTO noticeReplyDTO)throws Exception{
		int result = noticeService.setReplyDelete(noticeReplyDTO);
		return result;
	}
	
	//자주묻는질문(FAQ jsp연결)
	@GetMapping("faq")
	public void getFAQ()throws Exception{
		
	}

}
