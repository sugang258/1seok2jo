package com.seok.home.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
	
	@Autowired
	private AdminDAO dao;
	
	public void getLogin() {
		dao.getLogin();
	}
	
	public void getAuth() {
		//아이디 패스워드 맞는지 확인
		//권한추가
		dao.getAuth();
	}

}
