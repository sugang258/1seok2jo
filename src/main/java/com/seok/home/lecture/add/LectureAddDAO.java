package com.seok.home.lecture.add;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	
	

}
