package com.seok.home.lecture;

import com.seok.home.lecture.status.StatusDTO;

public class LectureVideoDTO {
	
	private Long v_num;
	private Long l_num;
	private String v_url;
	private String v_context;
	private Long v_seq;
	private StatusDTO statusDTO;
	
	
	
	public Long getV_num() {
		return v_num;
	}
	public void setV_num(Long v_num) {
		this.v_num = v_num;
	}
	public Long getL_num() {
		return l_num;
	}
	public void setL_num(Long l_num) {
		this.l_num = l_num;
	}
	public String getV_url() {
		return v_url;
	}
	public void setV_url(String v_url) {
		this.v_url = v_url;
	}
	public String getV_context() {
		return v_context;
	}
	public void setV_context(String v_context) {
		this.v_context = v_context;
	}
	public Long getV_seq() {
		return v_seq;
	}
	public void setV_seq(Long v_seq) {
		this.v_seq = v_seq;
	}
	public StatusDTO getStatusDTO() {
		return statusDTO;
	}
	public void setStatusDTO(StatusDTO statusDTO) {
		this.statusDTO = statusDTO;
	}
	
	
	
	
	
	
	
	
	
	

}
