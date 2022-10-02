package com.seok.home.cs_board;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.seok.home.member.MemberDTO;
import com.seok.home.s_board.StudyBoardDTO;

@Controller
@RequestMapping(value="/csBoard/*")
public class CsController {
	
	@Autowired
	CsService csService;

	@GetMapping("add")
	public void setBoardAdd() {
		
	}
	
	@PostMapping("add")
	public String setBoardAdd(CsBoardDTO csBoardDTO) throws Exception {
		int result = csService.setBoardAdd(csBoardDTO);
		
		return "redirect:/csBoard/mylist"; //마이페이지의 내문의 페이지로
	}
	
	@GetMapping("mylist")
	public void getMylist(CsBoardDTO csBoardDTO, HttpSession session) throws Exception{
		MemberDTO member = (MemberDTO)session.getAttribute("member");
		
		csBoardDTO.setId(member.getId());
	}
	

}
