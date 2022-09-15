package com.seok.home.admin;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDAO {
	
	private final String NAMESPACE = "com.seok.home.admin.AdminDAO.";
	@Autowired
	private SqlSession session;
	
	public void getLogin() {
	}
	
	public void getAuth() {
		//권한 추가
	}
}
