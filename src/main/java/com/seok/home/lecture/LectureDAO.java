package com.seok.home.lecture;

import java.util.List;

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
	
	public List<LectureDTO> getLecture(String search) throws Exception{
		return sqlSession.selectList(NAMESPACE+"getLecture",search);
	}
	
	public int setUpdate(LectureDTO lectureDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"setUpdate", lectureDTO);
	}
	
	public int setDelete(LectureDTO lectureDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"setDelete", lectureDTO);
	}
	
	//file add
	public int setAddFile(LectureFileDTO lectureFileDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setAddFile", lectureFileDTO);
	}
	
	public LectureDTO getDetail(LectureDTO lectureDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getDetail", lectureDTO);
	}
	
	//video add
	public int setAddVideo(LectureVideoDTO lectureVideoDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setAddVideo", lectureVideoDTO);
	}

}
