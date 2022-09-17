package com.seok.home.lecture.add;

import oracle.sql.DATE;

public class LectureAddDTO {
	private Long s_num;
	private Long l_num;
	private String id;
	private DATE s_start;
	private DATE s_end;
	private Boolean status;
	
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
	public DATE getS_start() {
		return s_start;
	}
	public void setS_start(DATE s_start) {
		this.s_start = s_start;
	}
	public DATE getS_end() {
		return s_end;
	}
	public void setS_end(DATE s_end) {
		this.s_end = s_end;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
}
