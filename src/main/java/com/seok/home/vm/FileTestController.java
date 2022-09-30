package com.seok.home.vm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.seok.home.file.FileDTO;
import com.seok.home.s_board.StudyBoardDTO;

@Controller
@RequestMapping(value="/fileTest/*")
public class FileTestController {
	
	@Autowired
	private FileTestService service;
	
	@GetMapping(value="home")
	public String home() {
		return "fileTest/home";
	}
	
	@GetMapping(value="add")
	public String upload() {
		return "fileTest/fileUpload";
	}
	
	@GetMapping("view")
	public ModelAndView view(TestBoardDTO boradDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		boradDTO = service.getBoardDetail(boradDTO);
		mv.addObject("studyBoardDTO", boradDTO);
		mv.setViewName("fileTest/fileView");
		
		return mv;
	}
	
	
	@PostMapping("add")
	public String add(TestBoardDTO boradDTO, String f_name, String oriname) throws Exception {
		System.out.println("boradDTO"+boradDTO.getTitle()+boradDTO.getCategory()+boradDTO.getId());
		
		//콤마을 구분자로 스트링 들어옴
		System.out.println("fileDTO_FNAME : "+f_name);
		System.out.println("fileDTO_ORINAME : "+oriname);
		
		//스트링을 구분자로 나눠준뒤
		String [] f_names = f_name.split(",");
		String [] orinames = oriname.split(",");

		//어레이 리스트에 추가
		ArrayList<TestFileDTO> files = new ArrayList<TestFileDTO>();
		
		for(int i=0; i<orinames.length; i++) {
			TestFileDTO fileDTO = new TestFileDTO();
			
			fileDTO.setF_name(f_names[i]);
			fileDTO.setF_oriname(orinames[i]);
			files.add(fileDTO);
		}
		
		
		
		Long sb_num = service.setBoardAdd(boradDTO, files);

		return "redirect: /fileTest/view?sb_num="+sb_num;
	}

}
