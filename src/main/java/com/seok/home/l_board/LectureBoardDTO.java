package com.seok.home.l_board;

import java.sql.Date;

public class LectureBoardDTO {
	private Long num;
	private Long l_num;
	private String id;
	private Integer score;
	private String contents;
	private Date get_date;
	
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
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
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getGet_date() {
		return get_date;
	}
	public void setGet_date(Date get_date) {
		this.get_date = get_date;
	}
	
}
