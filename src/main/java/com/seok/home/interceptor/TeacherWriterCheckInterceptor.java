package com.seok.home.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.seok.home.lecture.LectureDTO;
import com.seok.home.member.MemberDTO;

public class TeacherWriterCheckInterceptor extends HandlerInterceptorAdapter{

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception{
        
        String method = request.getMethod();
        
        if(method.equals("POST")) {
            return;
        }
        
        //로그인 사용자와 lectureDTO 의 작성자가 일치하는가
        
        HttpSession session = request.getSession();
        MemberDTO mem = (MemberDTO) session.getAttribute("member");
        Map<String, Object> map = modelAndView.getModel();
        
        LectureDTO lectureDTO = (LectureDTO) map.get("detail");
        System.out.println(mem.getId());
        System.out.println(lectureDTO.getId());
        
        if(!mem.getId().equals(lectureDTO.getId())) {
            modelAndView.setViewName("common/result");
            modelAndView.addObject("message", "작성자만 수정이 가능");
            modelAndView.addObject("url", "/lecture/list");
            modelAndView.addObject("result", 1);
        }
        
        super.postHandle(request, response, handler, modelAndView);
    }
}
