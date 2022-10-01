package com.seok.home.n_board;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/*")
public class NoticeController {
	
	/* 공지사항 목록 */
	@GetMapping("notice")
	private void getNoticeList()throws Exception {
		
	}
	
	
	//자주묻는질문(FAQ jsp연결)
	@GetMapping("faq")
	public void getFAQ()throws Exception{
		
	}

}
