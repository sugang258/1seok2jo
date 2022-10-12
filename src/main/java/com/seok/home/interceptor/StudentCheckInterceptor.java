package com.seok.home.interceptor;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.seok.home.lecture.add.LectureAddDTO;
import com.seok.home.lecture.add.LectureAddService;
import com.seok.home.member.MemberDTO;
import com.seok.home.member.RoleDTO;

public class StudentCheckInterceptor extends HandlerInterceptorAdapter{
    @Autowired
	private LectureAddService lectureAddService;
    //수강생인지 아닌지 체크
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception{
        
        HttpSession session = request.getSession();
        MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
        List<LectureAddDTO> list = lectureAddService.getLectureAddAll();
        boolean check = false;
        
        for(LectureAddDTO lectureAddDTO : list) {
            System.out.println(lectureAddDTO.getId());
            
            if(lectureAddDTO.getId().equals(memberDTO.getId())) {
                check = true;
                break;
            }
        }
        
        //수강생이 아닐때
        if(!check) {
            request.setAttribute("messeage", "수강생이 아닙니다🙈");
            request.setAttribute("url", "/board/sb_list");
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp"); //jsp의 경로
            view.forward(request, response);
        }
        
        super.postHandle(request, response, handler, modelAndView);
    }

}
