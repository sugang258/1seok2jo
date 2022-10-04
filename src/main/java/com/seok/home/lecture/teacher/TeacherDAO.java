package com.seok.home.lecture.teacher;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TeacherDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.seok.home.lecture.teacher.TeacherDAO.";
	
	//강사 추가
	public int setTeacherAdd(TeacherDTO teacherDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setTeacherAdd", teacherDTO);
	}
	
	//강사등급설정
	public int setTeacherRole(TeacherDTO teacherDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setTeacherRole", teacherDTO);
	}
	
	//강사 수정
	public int setTeacherUpdate(TeacherDTO teacherDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"setTeacherUpdate", teacherDTO);
	}
	
	//강사 삭제
	public int setTeacherDelete(TeacherDTO teacherDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"setTeacherDelete", teacherDTO);
	}
	
	//강사 조회
	public TeacherDTO getTeacherDetail(TeacherDTO teacherDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getTeacherDetail", teacherDTO);
	}
	
	//강사 리스트 조회
	public List<TeacherDTO> getTeacher() throws Exception {
		return sqlSession.selectList(NAMESPACE+"getTeacher");
	}
	
	
}
