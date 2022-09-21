package com.seok.home.b_comment;

import java.sql.Date;

public class CommentDTO {
	private Long num;
	private Long sb_num;
	private String id;
	private String contents;
	private Date reg_date;
	private int ref;
	
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	public Long getSb_num() {
		return sb_num;
	}
	public void setSb_num(Long sb_num) {
		this.sb_num = sb_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	
}