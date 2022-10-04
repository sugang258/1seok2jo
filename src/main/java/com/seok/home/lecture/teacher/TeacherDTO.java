package com.seok.home.lecture.teacher;

import java.util.List;

import com.seok.home.member.RoleDTO;

public class TeacherDTO {
	private Long t_num;
	private String id;
	private String bank_num;
	private String bank_name;
	private String introduce;
	//등급을 여러개
	private List<RoleDTO> roleDTOs;
	
	/********************** getter setter ************************/
	public List<RoleDTO> getRoleDTOs() {
		return roleDTOs;
	}
	public void setRoleDTOs(List<RoleDTO> roleDTOs) {
		this.roleDTOs = roleDTOs;
	}
	public Long getT_num() {
		return t_num;
	}
	public void setT_num(Long t_num) {
		this.t_num = t_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBank_num() {
		return bank_num;
	}
	public void setBank_num(String bank_num) {
		this.bank_num = bank_num;
	}
	
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	
	
}
