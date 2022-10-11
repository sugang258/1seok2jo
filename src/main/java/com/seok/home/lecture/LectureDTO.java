package com.seok.home.lecture;

import java.util.List;

import com.seok.home.cart.CartDTO;
import com.seok.home.lecture.add.LectureAddDTO;
import com.seok.home.lecture.status.StatusDTO;
import com.seok.home.member.MemberDTO;

public class LectureDTO {
	
	private Long l_num;
	private String id;
	private Long level_num;
	private String level_name;
	private String l_name;
	private String l_contents;
	private Long c_num;
	private String c_name;
	private Long l_price;
	private Long l_count;
	private Long l_date;
	private List<LectureFileDTO> lectureFileDTO;
	private List<LectureVideoDTO> lectureVideoDTO;
	private CartDTO cartDTO;
	private LectureAddDTO lectureAddDTO;
	private MemberDTO memberDTO;
	
	public Long getL_num() {
		return l_num;
	}
	public void setL_num(Long l_num) {
		this.l_num = l_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getLevel_num() {
		return level_num;
	}
	public void setLevel_num(Long level_num) {
		this.level_num = level_num;
	}
	public String getL_name() {
		return l_name;
	}
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}
	public String getL_contents() {
		return l_contents;
	}
	public void setL_contents(String l_contents) {
		this.l_contents = l_contents;
	}
	public Long getC_num() {
		return c_num;
	}
	public void setC_num(Long c_num) {
		this.c_num = c_num;
	}
	public Long getL_price() {
		return l_price;
	}
	public void setL_price(Long l_price) {
		this.l_price = l_price;
	}
	public Long getL_count() {
		return l_count;
	}
	public void setL_count(Long l_count) {
		this.l_count = l_count;
	}
	public Long getL_date() {
		return l_date;
	}
	public void setL_date(Long l_date) {
		this.l_date = l_date;
	}
	public List<LectureFileDTO> getLectureFileDTO() {
		return lectureFileDTO;
	}
	public void setLectureFileDTO(List<LectureFileDTO> lectureFileDTO) {
		this.lectureFileDTO = lectureFileDTO;
	}
	public List<LectureVideoDTO> getLectureVideoDTO() {
		return lectureVideoDTO;
	}
	public void setLectureVideoDTO(List<LectureVideoDTO> lectureVideoDTO) {
		this.lectureVideoDTO = lectureVideoDTO;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getLevel_name() {
		return level_name;
	}
	public void setLevel_name(String level_name) {
		this.level_name = level_name;
	}
	public CartDTO getCartDTO() {
		return cartDTO;
	}
	public void setCartDTO(CartDTO cartDTO) {
		this.cartDTO = cartDTO;
	}
	public LectureAddDTO getLectureAddDTO() {
		return lectureAddDTO;
	}
	public void setLectureAddDTO(LectureAddDTO lectureAddDTO) {
		this.lectureAddDTO = lectureAddDTO;
	}
    public MemberDTO getMemberDTO() {
        return memberDTO;
    }
    public void setMemberDTO(MemberDTO memberDTO) {
        this.memberDTO = memberDTO;
    }
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	

}
