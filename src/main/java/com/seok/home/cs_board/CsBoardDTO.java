package com.seok.home.cs_board;

import java.sql.Date;

public class CsBoardDTO {
	
	private Long cs_num;
	private String id;
	private String cs_phone;
	private String cs_email;
	private String cs_title;
	private String cs_contents;
	private Date regdate;
	private String cs_status;
	private String cs_answer;
	private String cs_admin;
	private Date re_regdate;
	
	
	public Long getCs_num() {
		return cs_num;
	}
	public void setCs_num(Long cs_num) {
		this.cs_num = cs_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCs_phone() {
		return cs_phone;
	}
	public void setCs_phone(String cs_phone) {
		this.cs_phone = cs_phone;
	}
	public String getCs_email() {
		return cs_email;
	}
	public void setCs_email(String cs_email) {
		this.cs_email = cs_email;
	}
	public String getCs_title() {
		return cs_title;
	}
	public void setCs_title(String cs_title) {
		this.cs_title = cs_title;
	}
	public String getCs_contents() {
		return cs_contents;
	}
	public void setCs_contents(String cs_contents) {
		this.cs_contents = cs_contents;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getCs_status() {
		return cs_status;
	}
	public void setCs_status(String cs_status) {
		this.cs_status = cs_status;
	}
	public String getCs_answer() {
		return cs_answer;
	}
	public void setCs_answer(String cs_answer) {
		this.cs_answer = cs_answer;
	}
	public String getCs_admin() {
		return cs_admin;
	}
	public void setCs_admin(String cs_admin) {
		this.cs_admin = cs_admin;
	}
	public Date getRe_regdate() {
		return re_regdate;
	}
	public void setRe_regdate(Date re_regdate) {
		this.re_regdate = re_regdate;
	}
	
}
