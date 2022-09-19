package com.seok.home.pay;

import com.seok.home.lecture.LectureDTO;

public class OrderDTO {
	
	private Long o_num;
	private Long o_amount;
	private LectureDTO lectureDTO;
	private RefundDTO refundDTO;
	
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
	public LectureDTO getLectureDTO() {
		return lectureDTO;
	}
	public void setLectureDTO(LectureDTO lectureDTO) {
		this.lectureDTO = lectureDTO;
	}
	public RefundDTO getRefundDTO() {
		return refundDTO;
	}
	public void setRefundDTO(RefundDTO refundDTO) {
		this.refundDTO = refundDTO;
	}

}
