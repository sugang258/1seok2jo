package com.seok.home.lecture.add;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.seok.home.lecture.LectureDTO;

@Repository
public class LectureAddDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.seok.home.lecture.add.LectureAddDAO.";
	
	//강의 수강 신청
	public int setLectureAdd(LectureAddDTO lectureAddDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setLectureAdd", lectureAddDTO);
	}
	
	//강의 수강 삭제
	public int setLectureDelete(LectureAddDTO lectureAddDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"setLectureDelete", lectureAddDTO);
	}
	
	//강의 수강 상태 업데이트(1 -> 0)
	public int setLectureUpdate(LectureAddDTO lectureAddDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"setLectureUpdate", lectureAddDTO);
	}
	
	public LectureAddDTO getLectureAdd(LectureAddDTO lectureAddDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getLectureAdd", lectureAddDTO);
	}
	
	public int setLectureAddDelete(LectureAddDTO lectureAddDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"setLectureAddDelete", lectureAddDTO);
	}

	public int setLectureCount(LectureAddDTO lectureAddDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"setLectureCount", lectureAddDTO);
	}
	
	public List<LectureAddDTO> getLectureAddAll() throws Exception{
		return sqlSession.selectList(NAMESPACE+"getLectureAddAll");
	}
	
	public List<LectureAddDTO> getLectureSearch(LectureAddDTO lectureAddDTO) throws Exception{
		return sqlSession.selectList(NAMESPACE+"getLectureSearch", lectureAddDTO);
	}
	 
	public int setLectureDeleteAll(LectureDTO lectureDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"setLectureDeleteAll", lectureDTO);
	}

}
