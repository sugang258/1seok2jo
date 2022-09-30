package com.seok.home.l_board;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board/*")
public class LectureBoardController {

	@Autowired
	private LectureBoardService lectureBoardService;

	/* 정렬  : type을 파라미터로 받음*/
	@GetMapping("list")
	public ModelAndView getL_boardNewList(LectureBoardDTO lectureBoardDTO, Integer type) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<LectureBoardDTO> ar = new ArrayList<LectureBoardDTO>();
		Long l_check = 1L;
		//수강평정보(type별로 정렬)
		 if(type == null) {
			ar = lectureBoardService.getL_boardNewList(lectureBoardDTO);
		} else if(type == 2) {
			ar = lectureBoardService.getL_boardLikeList(lectureBoardDTO);
			l_check = 2L;
		}else if(type == 3) {
			ar = lectureBoardService.getL_boardHighList(lectureBoardDTO);
			l_check = 3L;
		}else if(type == 4) {
			ar = lectureBoardService.getL_boardLowList(lectureBoardDTO);
			l_check = 4L;
		}else {
			ar = lectureBoardService.getL_boardNewList(lectureBoardDTO);			
		}
		mv.addObject("l_check", l_check);
		//수강평 총갯수
		Long count = lectureBoardService.getTotalCount(lectureBoardDTO);
		//별점 평균
		double avg = lectureBoardService.getAvgScore(lectureBoardDTO);
		avg = Math.round(avg);
		
		/* 추천수 조회 및 컬러변경 */
		List<Long> heartCount = new ArrayList<Long>();
		List<L_heartDTO> heartColor = new ArrayList<L_heartDTO>();
		for(LectureBoardDTO a : ar) {
			L_heartDTO l_heartDTO = new L_heartDTO();
			l_heartDTO.setNum(a.getNum());
			l_heartDTO.setId(a.getId());
			//수강평 추천수(jsp적용) 
			heartCount.add(lectureBoardService.getHeartCount(l_heartDTO));
			//수강평 color변경(jsp적용)
			heartColor.add(lectureBoardService.getL_heart(l_heartDTO));
		}
		mv.addObject("count_list", heartCount);
		mv.addObject("color_list", heartColor);

		//수강평 프로그래스바 width값
		Long firstScore = lectureBoardService.getFirstScore(lectureBoardDTO);
		Long secondScore = lectureBoardService.getSecondScore(lectureBoardDTO);
		Long thirdScore = lectureBoardService.getThirdScore(lectureBoardDTO);
		Long fourScore = lectureBoardService.getFourScore(lectureBoardDTO);
		Long fiveScore = lectureBoardService.getFiveScore(lectureBoardDTO);
		Long totalCount = lectureBoardService.getTotalCount(lectureBoardDTO);

		firstScore = Math.round(((double) firstScore / totalCount) * 100);
		secondScore = Math.round(((double) secondScore / totalCount) * 100);
		thirdScore = Math.round(((double) thirdScore / totalCount) * 100);
		fourScore = Math.round(((double) fourScore / totalCount) * 100);
		fiveScore = Math.round(((double) fiveScore / totalCount) * 100);

		mv.addObject("firstScore", firstScore);
		mv.addObject("secondScore", secondScore);
		mv.addObject("thirdScore", thirdScore);
		mv.addObject("fourScore", fourScore);
		mv.addObject("fiveScore", fiveScore);

		mv.addObject("avg", avg);
		mv.addObject("list", ar);
		mv.addObject("count", count);
		mv.setViewName("board/lectureboard_index");

		return mv;
	}

	/* 수강평추가 */
	@PostMapping("l_boardAdd")
	@ResponseBody
	public int setL_boardAdd(LectureBoardDTO lectureBoardDTO) throws Exception {
		int result = lectureBoardService.setL_boardAdd(lectureBoardDTO);

		return result;
	}
	/* 수강평삭제 */
	@PostMapping("l_boardDelete")
	@ResponseBody
	public int setL_boardDelete(LectureBoardDTO lectureBoardDTO) throws Exception {
		int result = lectureBoardService.setL_boardDelete(lectureBoardDTO);

		return result;
	}

	/* 수강평 추천 기능 구현 */
	@PostMapping("l_heart")
	@ResponseBody
	public int setL_heart(L_heartDTO l_heartDTO) throws Exception {
		int result=0;
		L_heartDTO h_DTO = lectureBoardService.getL_heart(l_heartDTO);
		if(h_DTO==null) {
			lectureBoardService.setL_heart(l_heartDTO);
			result = 1;
		}else {
			lectureBoardService.setL_heartDelete(l_heartDTO);
		}
		return result;
	}

}
