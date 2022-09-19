package com.seok.home.pay;

import java.sql.Date;
import java.util.List;

import com.seok.home.member.MemberDTO;

public class PaymentDTO {
	//아임포트 변수 참고문서(https://docs.iamport.kr/sdk/javascript-sdk)
	
	//내가 작성하는 변수 영역
	private String p_uid; //결제번호 *필수
	private Long p_point; //사용포인트
	private Long p_amount; //총상품금액
	private Long p_realamount; //실결제금액
	private String p_method; //결제수단 *필수
	private Date p_regdate; //결제일자
	private Long p_remains; //환불후남은금액
	private List<OrderDTO> orders; //강의기준 주문상세

	
	//결제완료 후 받아오는 변수 영역
	private String p_c_name; //카드사
	private Long p_c_num; //카드번호
	private Long p_c_quota; //할부개월
	private Long p_at; //결제승인시각(UNIX timestamp)
	private String p_receipt; //매출전표
	
	
	
	//getter setter
	public String getP_uid() {
		return p_uid;
	}
	public void setP_uid(String p_uid) {
		this.p_uid = p_uid;
	}
	
	public Long getP_point() {
		return p_point;
	}
	public void setP_point(Long p_point) {
		this.p_point = p_point;
	}
	public Long getP_amount() {
		return p_amount;
	}
	public void setP_amount(Long p_amount) {
		this.p_amount = p_amount;
	}
	public Long getP_realamount() {
		return p_realamount;
	}
	public void setP_realamount(Long p_realamount) {
		this.p_realamount = p_realamount;
	}
	public Date getP_regdate() {
		return p_regdate;
	}
	public void setP_regdate(Date p_regdate) {
		this.p_regdate = p_regdate;
	}
	public String getP_method() {
		return p_method;
	}
	public void setP_method(String p_method) {
		this.p_method = p_method;
	}
	public String getP_c_name() {
		return p_c_name;
	}
	public void setP_c_name(String p_c_name) {
		this.p_c_name = p_c_name;
	}
	public Long getP_c_num() {
		return p_c_num;
	}
	public void setP_c_num(Long p_c_num) {
		this.p_c_num = p_c_num;
	}
	public Long getP_c_quota() {
		return p_c_quota;
	}
	public void setP_c_quota(Long p_c_quota) {
		this.p_c_quota = p_c_quota;
	}
	public Long getP_remains() {
		return p_remains;
	}
	public void setP_remains(Long p_remains) {
		this.p_remains = p_remains;
	}
	public Long getP_at() {
		return p_at;
	}
	public void setP_at(Long p_at) {
		this.p_at = p_at;
	}
	public String getP_receipt() {
		return p_receipt;
	}
	public void setP_receipt(String p_receipt) {
		this.p_receipt = p_receipt;
	}

	
	

}
