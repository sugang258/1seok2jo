package com.seok.home.l_board;

import java.sql.Date;



import com.fasterxml.jackson.annotation.JsonFormat;

public class LectureBoardDTO {
	private Long num;
	private Long l_num;
	private String id;
	private Integer score;
	private String contents;
	@JsonFormat(pattern = "MM/DD/YY HH:MM:SS")
	private Date reg_date;
	private String array;
	
	public String getArray() {
		return array;
	}
	public void setArray(String array) {
		this.array = array;
	}
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
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	
}
