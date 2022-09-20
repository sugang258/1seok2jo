package com.seok.home.member;

public class RoleDTO {

	//등급DTO
	
	//등급번호
	private Long roleNum;
	
	//등급이름
	private String roleName;
	
	//getter setter
	public Long getRoleNum() {
		return roleNum;
	}
	public void setRoleNum(Long roleNum) {
		this.roleNum = roleNum;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
