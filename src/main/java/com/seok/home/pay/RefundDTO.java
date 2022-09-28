package com.seok.home.pay;

import java.sql.Date;

public class RefundDTO {
	
	private Long pr_num; //환불번호
	private String pr_reason; //환불사유
	private Long pr_amount; //환불금액
	private String pr_point; //환불포인트
	private Date pr_regdate; //신청일자
	
	public Long getPr_num() {
		return pr_num;
	}
	public void setPr_num(Long pr_num) {
		this.pr_num = pr_num;
	}
	public String getPr_reason() {
		return pr_reason;
	}
	public void setPr_reason(String pr_reason) {
		this.pr_reason = pr_reason;
	}
	public Long getPr_amount() {
		return pr_amount;
	}
	public void setPr_amount(Long pr_amount) {
		this.pr_amount = pr_amount;
	}

	public Date getPr_regdate() {
		return pr_regdate;
	}
	public void setPr_regdate(Date pr_regdate) {
		this.pr_regdate = pr_regdate;
	}
	public String getPr_point() {
		return pr_point;
	}
	public void setPr_point(String pr_point) {
		this.pr_point = pr_point;
	}

	
	

}
