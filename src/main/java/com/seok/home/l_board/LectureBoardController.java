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

	/* 최신순조회 */
	@GetMapping("new")
	public ModelAndView getL_boardNewList(LectureBoardDTO lectureBoardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		//수강평정보
		List<LectureBoardDTO> ar = lectureBoardService.getL_boardNewList(lectureBoardDTO);
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
	
	/* 추천순 조회 */
	@GetMapping("like")
	public ModelAndView getL_boardLikeList(LectureBoardDTO lectureBoardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<LectureBoardDTO> ar = lectureBoardService.getL_boardLikeList(lectureBoardDTO);
		Long count = lectureBoardService.getTotalCount(lectureBoardDTO);
		double avg = lectureBoardService.getAvgScore(lectureBoardDTO);
		avg = Math.round(avg);
		
		/* 추천수 조회 및 컬러변경 */
		List<Long> heartCount = new ArrayList<Long>();
		List<L_heartDTO> heartColor = new ArrayList<L_heartDTO>();
		for(LectureBoardDTO a : ar) {
			L_heartDTO l_heartDTO = new L_heartDTO();
			l_heartDTO.setNum(a.getNum());
			l_heartDTO.setId(a.getId());
			heartCount.add(lectureBoardService.getHeartCount(l_heartDTO));
			heartColor.add(lectureBoardService.getL_heart(l_heartDTO));
		}
		mv.addObject("count_list", heartCount);
		mv.addObject("color_list", heartColor);

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

	/* 높은 평점순 조회 */
	@GetMapping("high")
	public ModelAndView getL_boardHighList(LectureBoardDTO lectureBoardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<LectureBoardDTO> ar = lectureBoardService.getL_boardHighList(lectureBoardDTO);
		Long count = lectureBoardService.getTotalCount(lectureBoardDTO);
		double avg = lectureBoardService.getAvgScore(lectureBoardDTO);
		avg = Math.round(avg);
		
		/* 추천수 조회 */
		List<Long> heartCount = new ArrayList<Long>();
		List<L_heartDTO> heartColor = new ArrayList<L_heartDTO>();
		for(LectureBoardDTO a : ar) {
			L_heartDTO l_heartDTO = new L_heartDTO();
			l_heartDTO.setNum(a.getNum());
			l_heartDTO.setId(a.getId());
			heartCount.add(lectureBoardService.getHeartCount(l_heartDTO));
			heartColor.add(lectureBoardService.getL_heart(l_heartDTO));
		}
		mv.addObject("count_list", heartCount);
		mv.addObject("color_list", heartColor);

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

	/* 낮은 평점순 조회 */
	@GetMapping("low")
	public ModelAndView getL_boardLowList(LectureBoardDTO lectureBoardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<LectureBoardDTO> ar = lectureBoardService.getL_boardLowList(lectureBoardDTO);
		Long count = lectureBoardService.getTotalCount(lectureBoardDTO);
		double avg = lectureBoardService.getAvgScore(lectureBoardDTO);
		avg = Math.round(avg);
		
		/* 추천수 조회 */
		List<Long> heartCount = new ArrayList<Long>();
		List<L_heartDTO> heartColor = new ArrayList<L_heartDTO>();
		for(LectureBoardDTO a : ar) {
			L_heartDTO l_heartDTO = new L_heartDTO();
			l_heartDTO.setNum(a.getNum());
			l_heartDTO.setId(a.getId());
			heartCount.add(lectureBoardService.getHeartCount(l_heartDTO));
			heartColor.add(lectureBoardService.getL_heart(l_heartDTO));
		}
		mv.addObject("count_list", heartCount);
		mv.addObject("color_list", heartColor);

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
