package com.seok.home.f_board;

import java.sql.Date;

public class FreeBoardDTO {
	private Long fb_num;
	private String id;
	private String title;
	private Date reg_date;
	private Integer answer;
	private Long hit;
	private String contents;
	private String category;
	private Long like_count;
	private String bd_name; //admin에서 게시판 종류 구분하는 용도의 변수
	
	public Long getFb_num() {
		return fb_num;
	}
	public void setFb_num(Long fb_num) {
		this.fb_num = fb_num;
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
	public Integer getAnswer() {
		return answer;
	}
	public void setAnswer(Integer answer) {
		this.answer = answer;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Long getLike_count() {
		return like_count;
	}
	public void setLike_count(Long like_count) {
		this.like_count = like_count;
	}
	public String getBd_name() {
		return bd_name;
	}
	public void setBd_name(String bd_name) {
		this.bd_name = bd_name;
	}

}
