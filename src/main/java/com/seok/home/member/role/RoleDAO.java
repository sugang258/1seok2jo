package com.seok.home.member.role;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.seok.home.member.RoleDTO;

@Repository
public class RoleDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.seok.home.member.RoleDAO.";
	
	public int setAdmin(RoleDTO roleDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setAdmin", NAMESPACE);
	}
	
	public int setTeacher(RoleDTO roleDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setTeacher", NAMESPACE);
	}
	
	public int setMember(RoleDTO roleDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setMember", NAMESPACE);
	}
	
}
