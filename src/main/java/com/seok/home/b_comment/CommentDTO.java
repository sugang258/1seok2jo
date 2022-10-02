package com.seok.home.b_comment;

import java.sql.Date;

public class CommentDTO extends ReplyDTO{
	private Long sb_num;
	private int ref;
	
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