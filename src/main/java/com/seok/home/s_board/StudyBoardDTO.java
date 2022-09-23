package com.seok.home.s_board;

import java.sql.Date;

public class StudyBoardDTO {
	
	private Long sb_num;
	private Long l_num;
	private String id;
	private String title;
	private Date reg_date;
	private int answer;
	private Long hit;
	private String contents;
	private String category;

	public Long getSb_num() {
		return sb_num;
	}
	public void setSb_num(Long sb_num) {
		this.sb_num = sb_num;
	}
	public Long getL_num() {
		return l_num;
	}
	public void setL_num(Long l_num) {
		this.l_num = l_num;
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
	public int getAnswer() {
		return answer;
	}
	public void setAnswer(int answer) {
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
	
}
