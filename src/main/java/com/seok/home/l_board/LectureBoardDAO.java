package com.seok.home.l_board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LectureBoardDAO {
	
	@Autowired
	private SqlSession session;
	private String NAMESPACE = "com.seok.home.l_board.LectureBoardDAO.";
	
	public List<LectureBoardDTO> getL_boardList(LectureBoardDTO lectureBoardDTO)throws Exception{
		return session.selectList(NAMESPACE+"getL_boardList", lectureBoardDTO);
	}
	
	public int setL_boardAdd(LectureBoardDTO lectureBoardDTO)throws Exception{
		return session.insert(NAMESPACE+"setL_boardAdd", lectureBoardDTO);
	}
	
	public int setL_boardDelete(LectureBoardDTO lectureBoardDTO)throws Exception{
		return session.delete(NAMESPACE+"setL_boardDelete", lectureBoardDTO);
	}
	/* 수강평 댓글 수 */ 	
	public Long getTotalCount(LectureBoardDTO lectureBoardDTO)throws Exception{
		return session.selectOne(NAMESPACE+"getTotalCount", lectureBoardDTO);
	}
	/* 수강평 점수별 댓글 수 */ 	
	public Long getFiveScore(LectureBoardDTO lectureBoardDTO)throws Exception{
		return session.selectOne(NAMESPACE+"getFiveScore", lectureBoardDTO);
	}
	public Long getFourScore(LectureBoardDTO lectureBoardDTO)throws Exception{
		return session.selectOne(NAMESPACE+"getFourScore", lectureBoardDTO);
	}
	public Long getThirdScore(LectureBoardDTO lectureBoardDTO)throws Exception{
		return session.selectOne(NAMESPACE+"getThirdScore", lectureBoardDTO);
	}
	public Long getSecondScore(LectureBoardDTO lectureBoardDTO)throws Exception{
		return session.selectOne(NAMESPACE+"getSecondScore", lectureBoardDTO);
	}
	public Long getFirstScore(LectureBoardDTO lectureBoardDTO)throws Exception{
		return session.selectOne(NAMESPACE+"getFirstScore", lectureBoardDTO);
	}
	/* 별점 평점 */
	public double getAvgScore(LectureBoardDTO lectureBoardDTO)throws Exception{
		return session.selectOne(NAMESPACE+"getAvgScore", lectureBoardDTO);
	}
	/* 정렬기능구현 */
	public List<LectureBoardDTO> getL_boardNewList(LectureBoardDTO lectureBoardDTO)throws Exception{
		return session.selectList(NAMESPACE+"getL_boardNewList", lectureBoardDTO);
	}
	public List<LectureBoardDTO> getL_boardHighList(LectureBoardDTO lectureBoardDTO)throws Exception{
		return session.selectList(NAMESPACE+"getL_boardHighList", lectureBoardDTO);
	}
	public List<LectureBoardDTO> getL_boardLowList(LectureBoardDTO lectureBoardDTO)throws Exception{
		return session.selectList(NAMESPACE+"getL_boardLowList", lectureBoardDTO);
	}

	/* 수강평 추천기능구현 */
	public L_heartDTO getL_heart(L_heartDTO l_heartDTO)throws Exception{
		return session.selectOne(NAMESPACE+"getL_heart", l_heartDTO);
	}
	public int setL_heart(L_heartDTO l_heartDTO)throws Exception {
		return session.insert(NAMESPACE+"setL_heart", l_heartDTO);
	}
	/* 수강평 추천 취소 및 재선택 */
	public int setHeartToggle(L_heartDTO l_heartDTO)throws Exception{
		return session.update(NAMESPACE+"setHeartToggle", l_heartDTO);
	}
	/* 추천 갯수 */
	public Long getHeartCount(L_heartDTO l_heartDTO)throws Exception{
		return session.selectOne(NAMESPACE+"getHeartCount", l_heartDTO);
	}

	
}
