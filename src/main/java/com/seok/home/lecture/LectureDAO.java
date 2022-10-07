package com.seok.home.lecture;

import java.lang.reflect.Member;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.seok.home.cart.CartDTO;
import com.seok.home.lecture.add.LectureAddDTO;
import com.seok.home.member.MemberDTO;
import com.seok.home.util.Pager;

@Repository
public class LectureDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.seok.home.lecture.LectureDAO.";
	
	//결제에서 가져오는 간단한 lecture정보
	public LectureDTO getSimpleLecture(LectureDTO lectureDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getSimpleLecture", lectureDTO);
	}
	
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
	
	public LectureDTO getDetailVideo(LectureVideoDTO lectureVideoDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getDetailVideo", lectureVideoDTO);
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
	
	public LectureFileDTO getFileDetail(LectureFileDTO lectureFileDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getFileDetail", lectureFileDTO);
	}
	
	public int setFileUpdate(LectureFileDTO lectureFileDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"setFileUpdate", lectureFileDTO);
	}
	
	public int setVideoUpdate(LectureVideoDTO lectureVideoDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"setVideoUpdate", lectureVideoDTO);
	}
	
	public List<LectureVideoDTO> getVideoDetails(LectureVideoDTO lectureVideoDTO) throws Exception{
		return sqlSession.selectList(NAMESPACE+"getVideoDetails", lectureVideoDTO);
	}
	
	//수강 동영상 갯수
	public Long getVideoStatusCount(LectureVideoDTO lectureVideoDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getVideoStatusCount", lectureVideoDTO);
	}
	
	//수강완료한 동영상 정보 
	public List<LectureDTO> getVideoStatus(LectureDTO lectureDTO) throws Exception{
		return sqlSession.selectList(NAMESPACE+"getVideoStatus", lectureDTO);
	}
	
	//한 강의당 목차 갯수
	public Long getListCount(LectureDTO lectureDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getListCount", lectureDTO);
	}
	
	public LectureVideoDTO getLectureNext(LectureVideoDTO lectureVideoDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getLectureNext", lectureVideoDTO);
	}
	
	public LectureVideoDTO getLecturePre(LectureVideoDTO lectureVideoDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getLecturePre", lectureVideoDTO);
	}
	
	public LectureVideoDTO getVideoList(LectureVideoDTO lectureVideoDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getVideoList", lectureVideoDTO);
	}
	
	public LectureDTO setTeacherCheck(LectureDTO lectureDTO) throws Exception{
	    return sqlSession.selectOne(NAMESPACE+"setTeacherCheck", lectureDTO);
	}
	
	public List<LectureDTO> getTeacherLecture(LectureDTO lectureDTO) throws Exception {
	    return sqlSession.selectList(NAMESPACE+"getTeacherLecture", lectureDTO);
	}
	
	public List<LectureVideoDTO> getVideoCount(LectureVideoDTO lectureVideoDTO) throws Exception{
	    return sqlSession.selectList(NAMESPACE+"getVideoCount", lectureVideoDTO);
	}
	
	public List<LectureDTO> getLectureCate(Pager pager) throws Exception{
	    return sqlSession.selectList(NAMESPACE+"getLectureCate", pager);
	}
	
	public String getMemberName(MemberDTO memberDTO) throws Exception{
	    return sqlSession.selectOne(NAMESPACE+"getMemberName", memberDTO);
	}
	
	public List<LectureDTO> getLectureC() throws Exception{
	    return sqlSession.selectList(NAMESPACE+"getLectureC");
	}
	
	public List<LectureDTO> getLectureLevel() throws Exception{
	    return sqlSession.selectList(NAMESPACE+"getLectureLevel");
	}
	public List<LectureDTO> getLectureRecommend() throws Exception{
	    return sqlSession.selectList(NAMESPACE+"getLectureRecommend", NAMESPACE);
	}



	
	
	
}
