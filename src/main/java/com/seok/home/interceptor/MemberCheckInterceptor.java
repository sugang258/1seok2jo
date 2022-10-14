package com.seok.home.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.seok.home.member.MemberDTO;

public class MemberCheckInterceptor extends HandlerInterceptorAdapter{
    
    //로그인 했는지 안했는지 체크
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        
        HttpSession session = request.getSession();
        MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
        
        boolean check = false;
        
        if(session.getAttribute("member") == null) {            
            check = false;
        }else {
        	check = true;
        }
        
        //로그인이 안 되어있을 때
        if(!check) {
            request.setAttribute("message", "로그인이 필요합니다🤐");
            request.setAttribute("url", "./../../../member/login");
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp"); //jsp의 경로
            view.forward(request, response);
        }
        
        return check;
    }

}
