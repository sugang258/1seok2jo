package com.seok.home.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.seok.home.lecture.LectureDTO;
import com.seok.home.lecture.add.LectureAddDTO;
import com.seok.home.member.MemberDTO;

public class ListenCheckInterceptor extends HandlerInterceptorAdapter{

    
    //수강하고 있는 강의인지 체크
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse reponse, Object handler,
            ModelAndView mv) throws Exception {
        
        String method = request.getMethod();
        
        if(method.equals("POST")) {
            return;
        }
        
        //HttpSession session = request.getSession();
        //MemberDTO mem = (MemberDTO) session.getAttribute("member");
        Map<String, Object> map = mv.getModel();
        Map<String, Object> map2 = mv.getModel();
        
        LectureDTO lectureDTO = (LectureDTO) map.get("dto");
        LectureAddDTO lectureAddDTO = (LectureAddDTO) map2.get("sign");
        
//        System.out.println(mem.getId());
//        System.out.println(lectureDTO.getL_num());
//        System.out.println(lectureAddDTO.getId());
//        System.out.println(lectureAddDTO.getL_num());
//        
        if(lectureAddDTO == null) {
            mv.setViewName("common/result");
            mv.addObject("message", "수강중인 강의가 아닙니다");
            mv.addObject("url", "/lecture/detail?l_num="+lectureDTO.getL_num());
            mv.addObject("result", 1);
        }
        
        
        super.postHandle(request, reponse, handler, mv);
    }
        
        
        
    
}
