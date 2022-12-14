package com.seok.home.lecture.status;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.seok.home.lecture.LectureDTO;
import com.seok.home.lecture.LectureVideoDTO;
import com.seok.home.lecture.add.LectureAddDTO;

@Repository
public class StatusDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.seok.home.lecture.status.StatusDAO.";
	
	//수강신청 완료 동시에 추가
	public int setStatusAdd(StatusDTO statusDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setStatusAdd", statusDTO);
	}
	
	public List<LectureVideoDTO> getVideoList(LectureDTO lectureDTO) throws Exception{
		return sqlSession.selectList(NAMESPACE+"getVideoList", lectureDTO);
	}
	
	public int setStatusUpdate(StatusDTO statusDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"setStatusUpdate", statusDTO);
	}
	
	public StatusDTO getStatus(StatusDTO statusDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getStatus", statusDTO);
	}
	public List<LectureDTO> getSignList(LectureAddDTO lectureAddDTO ) throws Exception{
		return sqlSession.selectList(NAMESPACE+"getSignList", lectureAddDTO);
	}
	
	public long getStatusCount(LectureAddDTO lectureAddDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getStatusCount", lectureAddDTO);
	}
	
	public long getStatusTotal(LectureAddDTO lectureAddDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getStatusTotal", lectureAddDTO);
	}
	
	public int setStatusDelete(StatusDTO statusDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"setStatusDelete", statusDTO);
	}

}
