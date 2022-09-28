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

	@GetMapping("L_index")
	public ModelAndView getL_boardList(LectureBoardDTO lectureBoardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<LectureBoardDTO> ar = lectureBoardService.getL_boardList(lectureBoardDTO);
		Long count = lectureBoardService.getTotalCount(lectureBoardDTO);
		double avg = lectureBoardService.getAvgScore(lectureBoardDTO);
		avg = Math.round(avg);

		/* 프로그래스바 구현 */
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

	/* 정렬조회 */
	@GetMapping("new")
	public ModelAndView getL_boardNewList(LectureBoardDTO lectureBoardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<LectureBoardDTO> ar = lectureBoardService.getL_boardNewList(lectureBoardDTO);
		Long count = lectureBoardService.getTotalCount(lectureBoardDTO);
		double avg = lectureBoardService.getAvgScore(lectureBoardDTO);
		avg = Math.round(avg);

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

	/* 정렬조회 */
	@GetMapping("high")
	public ModelAndView getL_boardHighList(LectureBoardDTO lectureBoardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<LectureBoardDTO> ar = lectureBoardService.getL_boardHighList(lectureBoardDTO);
		Long count = lectureBoardService.getTotalCount(lectureBoardDTO);
		double avg = lectureBoardService.getAvgScore(lectureBoardDTO);
		avg = Math.round(avg);

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

	/* 정렬조회 */
	@GetMapping("low")
	public ModelAndView getL_boardLowList(LectureBoardDTO lectureBoardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<LectureBoardDTO> ar = lectureBoardService.getL_boardLowList(lectureBoardDTO);
		Long count = lectureBoardService.getTotalCount(lectureBoardDTO);
		double avg = lectureBoardService.getAvgScore(lectureBoardDTO);
		avg = Math.round(avg);

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

	@PostMapping("l_boardAdd")
	@ResponseBody
	public int setL_boardAdd(LectureBoardDTO lectureBoardDTO) throws Exception {
		int result = lectureBoardService.setL_boardAdd(lectureBoardDTO);

		return result;
	}

	@PostMapping("l_boardDelete")
	@ResponseBody
	public int setL_boardDelete(LectureBoardDTO lectureBoardDTO) throws Exception {
		int result = lectureBoardService.setL_boardDelete(lectureBoardDTO);

		return result;
	}

	/* 수강평 추천 기능 구현 */
	@PostMapping("l_heart")
	@ResponseBody
	public Long setL_heart(L_heartDTO l_heartDTO) throws Exception {
		int result=0;
		Long like_check = 0L;
		L_heartDTO h_DTO = lectureBoardService.getL_heart(l_heartDTO);
		if(h_DTO==null) {
			result = lectureBoardService.setL_heart(l_heartDTO);
			like_check = 1L;
		}else {
			result = lectureBoardService.setHeartToggle(h_DTO);
			if(h_DTO.getLike_check() == 1) {
				like_check = 0L;
			}else {
				like_check = 1L;
			}
		}
		return like_check;
	}
	
	@GetMapping("l_heartCount")
	public ModelAndView getHeartCount(L_heartDTO l_heartDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		Long heart_count = lectureBoardService.getHeartCount(l_heartDTO);
		mv.addObject("heart_count", heart_count);
		mv.setViewName("board/lectureboard_index");
		return mv;
	}

}
