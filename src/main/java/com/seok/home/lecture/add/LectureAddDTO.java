package com.seok.home.lecture.add;

import java.sql.Date;

import oracle.sql.DATE;

public class LectureAddDTO {
	private Long s_num;
	private Long l_num;
	private String id;
	private Date s_start;
	private Date s_end;
	private Long status;
	
	public Long getS_num() {
		return s_num;
	}
	public void setS_num(Long s_num) {
		this.s_num = s_num;
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
	
	public Date getS_start() {
		return s_start;
	}
	public void setS_start(Date s_start) {
		this.s_start = s_start;
	}
	public Date getS_end() {
		return s_end;
	}
	public void setS_end(Date s_end) {
		this.s_end = s_end;
	}
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	
}
