package com.seok.home.l_board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LectureBoardService {
	
	@Autowired
	private LectureBoardDAO lectureBoardDAO;

	public int setL_boardAdd(LectureBoardDTO lectureBoardDTO)throws Exception{
		return lectureBoardDAO.setL_boardAdd(lectureBoardDTO);
	}
	
	public int setL_boardDelete(LectureBoardDTO lectureBoardDTO)throws Exception{
		return lectureBoardDAO.setL_boardDelete(lectureBoardDTO);
	}
	/* 수강평 댓글 수 */ 
	public Long getTotalCount(LectureBoardDTO lectureBoardDTO)throws Exception{
		return lectureBoardDAO.getTotalCount(lectureBoardDTO);
	}
	/* 수강평 점수별 댓글 수 */ 	
	public Long getFiveScore(LectureBoardDTO lectureBoardDTO)throws Exception{
		return lectureBoardDAO.getFiveScore(lectureBoardDTO);
	}
	public Long getFourScore(LectureBoardDTO lectureBoardDTO)throws Exception{
		return lectureBoardDAO.getFourScore(lectureBoardDTO);
	}
	public Long getThirdScore(LectureBoardDTO lectureBoardDTO)throws Exception{
		return lectureBoardDAO.getThirdScore(lectureBoardDTO);
	}
	public Long getSecondScore(LectureBoardDTO lectureBoardDTO)throws Exception{
		return lectureBoardDAO.getSecondScore(lectureBoardDTO);
	}
	public Long getFirstScore(LectureBoardDTO lectureBoardDTO)throws Exception{
		return lectureBoardDAO.getFirstScore(lectureBoardDTO);
	}
	/* 별점 평점 */
	public double getAvgScore(LectureBoardDTO lectureBoardDTO)throws Exception{
		return lectureBoardDAO.getAvgScore(lectureBoardDTO);
	}
	/* 정렬기능구현 */
	public List<LectureBoardDTO> getL_boardNewList(LectureBoardDTO lectureBoardDTO)throws Exception{
		return lectureBoardDAO.getL_boardNewList(lectureBoardDTO);
	}
	public List<LectureBoardDTO> getL_boardLikeList(LectureBoardDTO lectureBoardDTO)throws Exception{
		return lectureBoardDAO.getL_boardLikeList(lectureBoardDTO);
	}
	public List<LectureBoardDTO> getL_boardHighList(LectureBoardDTO lectureBoardDTO)throws Exception{
		return lectureBoardDAO.getL_boardHighList(lectureBoardDTO);
	}
	public List<LectureBoardDTO> getL_boardLowList(LectureBoardDTO lectureBoardDTO)throws Exception{
		return lectureBoardDAO.getL_boardLowList(lectureBoardDTO);
	}
	
	/* 수강평 추천기능구현 */
	public L_heartDTO getL_heart(L_heartDTO l_heartDTO)throws Exception{
		return lectureBoardDAO.getL_heart(l_heartDTO);
	}
	public int setL_heart(L_heartDTO l_heartDTO)throws Exception {
		return lectureBoardDAO.setL_heart(l_heartDTO);
	}
	/* 추천 취소 */
	public int setL_heartDelete(L_heartDTO l_heartDTO)throws Exception {
		return lectureBoardDAO.setL_heartDelete(l_heartDTO);
	}
	/* 추천 갯수 */
	public Long getHeartCount(L_heartDTO l_heartDTO)throws Exception{
		return lectureBoardDAO.getHeartCount(l_heartDTO);
	}

	

}
