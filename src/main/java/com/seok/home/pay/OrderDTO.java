package com.seok.home.pay;

import java.sql.Date;

import com.seok.home.lecture.LectureDTO;

public class OrderDTO {
	private String p_uid;
	private Long o_num;
	private Long o_amount;
	private Long l_num;
	private Long pr_num; //환불번호
	private LectureDTO lectureDTO;
	private Date p_regdate;
	
	public Long getO_num() {
		return o_num;
	}
	public void setO_num(Long o_num) {
		this.o_num = o_num;
	}
	public Long getO_amount() {
		return o_amount;
	}
	public void setO_amount(Long o_amount) {
		this.o_amount = o_amount;
	}
	public Long getL_num() {
		return l_num;
	}
	public void setL_num(Long l_num) {
		this.l_num = l_num;
	}
	public Long getPr_num() {
		return pr_num;
	}
	public void setPr_num(Long pr_num) {
		this.pr_num = pr_num;
	}
	public String getP_uid() {
		return p_uid;
	}
	public void setP_uid(String p_uid) {
		this.p_uid = p_uid;
	}
	public LectureDTO getLectureDTO() {
		return lectureDTO;
	}
	public void setLectureDTO(LectureDTO lectureDTO) {
		this.lectureDTO = lectureDTO;
	}
	public Date getP_regdate() {
		return p_regdate;
	}
	public void setP_regdate(Date p_regdate) {
		this.p_regdate = p_regdate;
	}
	

}
