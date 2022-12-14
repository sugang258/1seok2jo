package com.seok.home.lecture.add;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.time.LocalDate;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.seok.home.cart.CartDTO;
import com.seok.home.cart.CartService;
import com.seok.home.lecture.LectureDTO;
import com.seok.home.lecture.LectureService;
import com.seok.home.lecture.LectureVideoDTO;
import com.seok.home.lecture.status.StatusDTO;
import com.seok.home.lecture.status.StatusService;
import com.seok.home.member.MemberDTO;

@Controller
@RequestMapping(value="/lectureAdd/*")
public class LectureAddController {
 
	@Autowired
	private LectureAddService lectureAddService;
	@Autowired
	private LectureService lectureService;
	@Autowired
	private StatusService statusService;
	@Autowired
	private CartService cartService;
	
	@PostMapping("setLectureAdd")
	@ResponseBody
	public int setLectureAdd(LectureDTO lectureDTO, LectureAddDTO lectureAddDTO, HttpServletRequest request,HttpSession session) throws Exception{
		int result = 1;
		System.out.println("수강완료");
		CartDTO cartDTO = new CartDTO();
		lectureDTO = lectureService.getDetail(lectureDTO);
		MemberDTO mem = (MemberDTO)request.getSession().getAttribute("member");
		List<LectureAddDTO> list = lectureAddService.getLectureAddAll();
		for(int i=0;i<list.size(); i++) {
			if(list.get(i).getId().equals(mem.getId()) && list.get(i).getL_num().equals(lectureAddDTO.getL_num())) {
				result = 0;
			}else {
				result = 1;
			}
		}
		if(result == 1) {
			
			Date now = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(now);
			cal.add(Calendar.MONTH,lectureDTO.getL_date().intValue());
			System.out.println(cal.MONTH);
			java.sql.Date date1 = new java.sql.Date(cal.getTimeInMillis());
			System.out.println(date1);
			lectureAddDTO.setS_end(date1);
			lectureAddDTO.setId(mem.getId());
			
			
			int reulst =lectureAddService.setLectureAdd(lectureAddDTO);
			System.out.println(reulst);
			lectureAddService.setLectureCount(lectureAddDTO);
			
			StatusDTO statusDTO = new StatusDTO();
			List<LectureVideoDTO> ar = statusService.getVideoList(lectureDTO);
			lectureAddDTO.setL_num(lectureDTO.getL_num());
			System.out.println("LECTUREEERERE"+lectureAddDTO.getL_num());;
			//로그인 정보 가져오기
			lectureAddDTO.setId(mem.getId());
			System.out.println(lectureAddDTO.getId());
			lectureAddDTO = lectureAddService.getLectureAdd(lectureAddDTO);
			System.out.println("LLLLLLL"+lectureAddDTO.getL_num());
			System.out.println("SSSSSS"+lectureAddDTO.getS_num());
			
			for(int i=0; i<ar.size();i++) {
				statusDTO.setS_num(lectureAddDTO.getS_num());
				statusDTO.setV_num(ar.get(i).getV_num());
				//System.out.println(ar.get(i).getV_num());
				//System.out.println(lectureAddDTO.getS_num());
				statusService.setStatusAdd(statusDTO);
			}
			
			cartDTO.setId(mem.getId());
			cartDTO.setL_num(lectureDTO.getL_num());
			cartDTO = cartService.getCartOne(cartDTO);
			if(cartDTO != null) {			    
			    cartService.setCartDelete(cartDTO);
			}
		}
		//session.setAttribute("sign", lectureAddDTO);
		return result;
	}
	
	@PostMapping("SignCheck")
    @ResponseBody
    public int SignCheck(LectureAddDTO lectureAddDTO, HttpServletRequest request) throws Exception{
        System.out.println("signCheck");
        MemberDTO mem = (MemberDTO)request.getSession().getAttribute("member");
        lectureAddDTO.setId(mem.getId());
        System.out.println(lectureAddDTO.getId());
        System.out.println("llllnnnnn"+lectureAddDTO.getL_num());
        lectureAddDTO = lectureAddService.getLectureCancel(lectureAddDTO);
        System.out.println("SSSNNNN"+lectureAddDTO);
        int result = 0;
        if(lectureAddDTO == null) {
            result = 0;
        }else {
            result = 1;
        }
        
        
        return result;
    }
}
