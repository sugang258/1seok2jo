package com.seok.home.member;

import java.util.List;

public class MemberDTO {

	//회원의 정보를 담을 DTO
	
	//아이디
	private String id;
	//비밀번호
	private String pw;
	//이름
	private String name;
	//닉네임
	private String n_name;
	//생년월이
	private Long b_date;
	//성별
	private String gender;
	//이메일
	private String email;
	//전화번호
	private String phone;
	//마일리지
	private Long point;
	//등급을 여러개
	private List<RoleDTO> roleDTOs;
	//getter setter
	
	public List<RoleDTO> getRoleDTOs() {
		return roleDTOs;
	}
	public void setRoleDTOs(List<RoleDTO> roleDTOs) {
		this.roleDTOs = roleDTOs;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getN_name() {
		return n_name;
	}
	public void setN_name(String n_name) {
		this.n_name = n_name;
	}
	public Long getB_date() {
		return b_date;
	}
	public void setB_date(Long b_date) {
		this.b_date = b_date;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Long getPoint() {
		return point;
	}
	public void setPoint(Long point) {
		this.point = point;
	}
	
}
