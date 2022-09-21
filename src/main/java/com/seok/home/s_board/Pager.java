package com.seok.home.s_board;

public class Pager {
	
	private Long page;
	private Long startRow;
	private Long lastRow;
	private Long perPage;
	private Long perBlock;
	private Long startNum;
	private Long lastNum;
	
	private boolean pre;
	private boolean next;
	
	public Pager() {
		this.perPage = 10L;
		this.perBlock = 5L;
	}
	
	public void getRowNum()throws Exception{
		this.startRow = this.getPerPage()*this.getPage() -(this.getPerPage()-1);
		this.lastRow = this.getPerPage() * this.getPage();
	}
	
	public void getBlockNum(Long totalCount)throws Exception{
		Long totalPage =  (long) Math.ceil((double)totalCount / this.getPerPage());
		//현재 페이지수가 총 페이지수보다 클때 현재 페이지수를 총페이지수로 세팅
		if(totalPage < this.getPage()) {
			this.setPage(totalPage);
		}
		Long totalBlock = (long) Math.ceil((double)totalPage / this.getPerBlock());
		Long curBlock = (long) Math.ceil((double) this.getPage() / this.getPerBlock());
		
		this.startNum = (curBlock*this.getPerBlock())-4; 
		this.lastNum = curBlock*this.getPerBlock();
		
		//현재 블록이 마지막블록일때 총페이지수와 lastNum은 같다.
		if(curBlock == totalBlock) {
			this.lastNum = totalPage;
		}
		
		//이전 다음 블록 유무boolean값 활용
		if(curBlock > 1) {
			pre = true;
		}
		if(curBlock < totalBlock) {
			next = true;
		}
		
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
		if(this.perPage == null) {
			this.perPage = 10L;
		}
		return perPage;
	}
	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	public Long getPerBlock() {
		if(this.perBlock == null) {
			this.perBlock = 5L;
		}
		return perBlock;
	}
	public void setPerBlock(Long perBlock) {
		this.perBlock = perBlock;
	}
	public Long getStartNum() {
		return startNum;
	}
	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}
	public Long getLastNum() {
		return lastNum;
	}
	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}
	public boolean isPre() {
		return pre;
	}
	public void setPre(boolean pre) {
		this.pre = pre;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	
}
