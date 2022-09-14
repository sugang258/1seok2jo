package com.seok.home.lecture;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LectureDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.seok.home.lecture.LectureDAO.";
	
	public int setLecture(LectureDTO lectureDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setLecture", lectureDTO);
	}

}
