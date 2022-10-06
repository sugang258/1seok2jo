package com.seok.home.admin;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.seok.home.util.Pager;

public class AdminPager extends Pager{
	
	//멤버변수
	//내가 정하는 변수
	private Long perPage; //한 페이지에 출력할 글의 개수
	private Long perBlock; //한 페이지에 출력할 번호의 갯수
	//파라미터를 담을 변수
	private Long page; //현재 페이지, 파라미터로 받음
	//jsp에서 꺼내서 사용할 변수
	private Long startNum;
	private Long lastNum;
	private Long totalPage; //전체 페이지, getPageBlock에서 계산함
	//Mapper에서 꺼내서 사용할 변수
	private Long startRow;
	private Long lastRow;
	
	//이전, 다음 블럭의 유무
	private boolean pre;
	private boolean next;
	
	//검색
	private String kind;// 컬럼의 종류
	private String search;//검색어
	private String startDate;
	private String endDate;
	private String orderby;
	
	private String chkstatus;
	
	
	public AdminPager() {
		this.perPage= 15L;
		this.perBlock = 5L;
	}
	
	
	public void calNum(Long totalCount) throws Exception{
		//전체 페이지수와 블록 계산
		this.getPageBlock(totalCount);
		
		//totalPage보다 파라미터page가 더 클 경우
		if(this.getPage()>totalPage) {
			this.setPage(totalPage);
		}
		//가져올 행의 범위 계산
		this.getRow();
	}
	
	//  1.mapper에서 사용할 값 (가져올 행의 범위) 계산
	public void getRow()throws Exception{
	    this.startRow = (this.getPage()-1)*this.getPerPage()+1;
	    this.lastRow = this.getPage()*this.getPerPage();
	}
	
	// 2. jsp에서 사용 할 값 게산
    public void getPageBlock(Long totalCount)throws Exception{
      //2. totalCount로 totalPage구하기 (전체 페이지수)
       this.totalPage = ((totalCount-1)/this.getPerPage()+1);
    		  
    		  
//	    3. totalPage로 totalBlock 구하기
       Long totalBlock = ((getTotalPage()-1)/getPerBlock()+1);
      
   //   4. page로 curBlock찾기 (현재 블록번호를 찾기, 이걸로 나중에 jsp에서 쓸 숫자를 계산)
       Long curBlock = (this.getPage()-1)/getPerBlock()+1;
      
      //5.curBlock으로 startNum ,lastNum 구하기
       this.startNum = (curBlock -1)*this.getPerBlock()+1;
       
       this.lastNum = curBlock*this.getPerBlock();

       //페이지 블록 마지막 번호 처리
       if(lastNum>totalPage) {
    	   this.lastNum = this.totalPage;
       }
       
       //이전블록과 마지막블록 상황에 따라 보이지 않게 만들기
       if(curBlock== 1) {
    	   this.setPre(true);
       }
       if(curBlock== totalBlock) {
    	   this.setNext(true);
       }
       
       
    }

    
	//getter, setter 영역
	public Long getPage() {
		if(this.page==null || this.page<1) {
			this.page=1L;
		}
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
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
	
	public Long getPerBlock() {
		return perBlock;
	}
	
	public void setPerBlock(Long perBlock) {
		this.perBlock = perBlock;
	}
	public Long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
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


	public String getKind() {
		return kind;
	}


	public void setKind(String kind) {
		this.kind = kind;
	}


	public String getSearch() {
		if(this.search==null) {
			this.search="";
		}
		return search;
	}


	public void setSearch(String search) {
		this.search = search;
	}


	public String getStartDate() {
//		if(this.startDate==null) {
//			Calendar ca = Calendar.getInstance();
//			String pattern = "yyyy-MM-dd";
//			SimpleDateFormat sd = new SimpleDateFormat(pattern);
//			String time = sd.format(ca.getTime());
//			this.startDate = time;
//		}
		return startDate;
	}


	public void setStartDate(String startDate) {
		
		this.startDate = startDate;
	}


	public String getEndDate() {
//		if(this.endDate==null) {
//			Calendar ca = Calendar.getInstance();
//			String pattern = "yyyy-MM-dd";
//			SimpleDateFormat sd = new SimpleDateFormat(pattern);
//			String time = sd.format(ca.getTime());
//			this.endDate = time;
//		}
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public String getOrderby() {
		return orderby;
	}


	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}


	public String getChkstatus() {
		return chkstatus;
	}


	public void setChkstatus(String chkstatus) {
		this.chkstatus = chkstatus;
	}
}
