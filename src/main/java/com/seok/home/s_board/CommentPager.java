package com.seok.home.s_board;

public class CommentPager {
	
	private Long page;
	private Long startRow;
	private Long lastRow;
	private Long perPage;
	private Long fb_num;
	private Long sb_num;
	
	public Long getSb_num() {
		return sb_num;
	}

	public void setSb_num(Long sb_num) {
		this.sb_num = sb_num;
	}

	public Long getFb_num() {
		return fb_num;
	}

	public void setFb_num(Long fb_num) {
		this.fb_num = fb_num;
	}

	public CommentPager() {
		this.perPage = 5L;
	}
	
	public void getRowNum()throws Exception{
		this.startRow = 1L;
		this.lastRow = this.getPerPage() * this.getPage();
	}
	
	public Long getTotalPage(Long count)throws Exception{
		Long totalPage = (long) Math.ceil(count / (double)this.perPage); 
		if(totalPage < this.getPage()) {
			this.setPage(totalPage);
		}
		return totalPage;
	}
		
	public Long getPage() {
		if(this.page == null || this.page <= 0L) {
			this.page = 1L;
		}
		return page;
	}

		public void setPage(Long page) {
			this.page = page;
		}

		public Long getStartRow() {
			return startRow;
		}

		public void setStartRow(Long startRow) {
			this.startRow = startRow;
		}

		public Long getLastRow() {
			return lastRow;
		}

		public void setLastRow(Long lastRow) {
			this.lastRow = lastRow;
		}

		public Long getPerPage() {
			return perPage;
		}

		public void setPerPage(Long perPage) {
			this.perPage = perPage;
		}

}
