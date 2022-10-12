package com.seok.home.b_comment;

import java.sql.Date;

public class CommentDTO extends ReplyDTO{
	private Long sb_num;
	private int ref;
	private String f_name;
	
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public Long getSb_num() {
		return sb_num;
	}
	public void setSb_num(Long sb_num) {
		this.sb_num = sb_num;
	}

	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	
}