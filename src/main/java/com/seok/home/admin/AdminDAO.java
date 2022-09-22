package com.seok.home.admin;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.seok.home.member.MemberDTO;

@Repository
public class AdminDAO {
	
	private final String NAMESPACE = "com.seok.home.admin.AdminDAO.";
	@Autowired
	private SqlSession session;
	
	//권한 추가
	public int getAuth(MemberDTO member) {
		return session.insert(NAMESPACE+"getAuth", member);
	}
}
