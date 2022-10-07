package com.seok.home.n_board;

import java.sql.Date;

public class NoticeDTO {
	private Long n_num;
	private String id;
	private String title;
	private Date reg_date;
	private Long hit;
	private String contents;
	private String f_name;
	
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public Long getN_num() {
		return n_num;
	}
	public void setN_num(Long n_num) {
		this.n_num = n_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public Long getHit() {
		return hit;
	}
	public void setHit(Long hit) {
		this.hit = hit;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
}
