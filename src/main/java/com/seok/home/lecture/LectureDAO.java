package com.seok.home.lecture;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.seok.home.cart.CartDTO;
import com.seok.home.util.Pager;

@Repository
public class LectureDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.seok.home.lecture.LectureDAO.";
	
	public int setLecture(LectureDTO lectureDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setLecture", lectureDTO);
	}
	
	public List<LectureDTO> getLecture(Pager pager) throws Exception{
		return sqlSession.selectList(NAMESPACE+"getLecture",pager);
	}
	
	public int setUpdate(LectureDTO lectureDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"setUpdate", lectureDTO);
	}
	
	
	//file add
	public int setAddFile(LectureFileDTO lectureFileDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setAddFile", lectureFileDTO);
	}
	
	public LectureDTO getDetail(LectureDTO lectureDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getDetail", lectureDTO);
	}
	
	public List<LectureDTO> getDetailVideo(LectureDTO lectureDTO) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getDetailVideo", lectureDTO);
	}
	
	//video add
	public int setAddVideo(LectureVideoDTO lectureVideoDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setAddVideo", lectureVideoDTO);
	}
	
	//PAGER COUNT
	public Long getCount(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+"getCount",pager);
	}
	
	//장바구니 리스트
	public List<LectureDTO> getCartDetail(CartDTO cartDTO) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getCartDetail",cartDTO);
	}
	
	//비디오 삭제
	public int setVideoDelete(LectureVideoDTO lectureVideoDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"setVideoDelete", lectureVideoDTO);
	}
	
	//강의 삭제
	public int setDelete(LectureDTO lectureDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"setDelete", lectureDTO);
	}
	
	public int setVideoDele(LectureDTO lectureDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"setVideoDele", lectureDTO);
	}
	
	public int setFileDelete(LectureDTO lectureDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"setFileDelete", lectureDTO);
	}
	
	public List<LectureFileDTO> getFileDetail(LectureFileDTO lectureFileDTO) throws Exception{
		return sqlSession.selectList(NAMESPACE+"getFileDetail", lectureFileDTO);
	}
	
	public int setFileUpdate(LectureFileDTO lectureFileDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"setFileUpdate", lectureFileDTO);
	}
	
	

}
