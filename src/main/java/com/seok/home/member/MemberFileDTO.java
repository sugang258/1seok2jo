package com.seok.home.member;

import com.seok.home.file.FileDTO;

public class MemberFileDTO extends FileDTO {
	//회원프로필사진을 담을 DTO
	
	//	파일번호, 파일이름, 파일업로드이름을 가지고있음
	//	private Long num;
	//	private String f_name;
	//	private String f_oriname;
	
	//회원 아이디를 참조
	private String id;

	
	/********************** getter setter ************************/
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
