package com.seok.home.b_comment;

public class FreeBoardReplyDTO extends ReplyDTO{
	private Long fb_num;
	private String f_name;

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public Long getFb_num() {
		return fb_num;
	}

	public void setFb_num(Long fb_num) {
		this.fb_num = fb_num;
	}

}
