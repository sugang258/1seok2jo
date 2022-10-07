package com.seok.home.b_comment;

public class NoticeReplyDTO extends ReplyDTO{
	private Long n_num;
	private String f_name;
	
	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public Long getN_num() {
		return n_num;
	}

	public void setN_num(Long n_num) {
		this.n_num = n_num;
	}
	
}
