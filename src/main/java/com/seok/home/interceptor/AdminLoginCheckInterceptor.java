package com.seok.home.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.seok.home.member.MemberDTO;
import com.seok.home.member.RoleDTO;

public class AdminLoginCheckInterceptor extends HandlerInterceptorAdapter{
    
    //관리자인지 아닌지 체크
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        
        HttpSession session = request.getSession();
        Boolean admin = (Boolean) session.getAttribute("admin");
        
        boolean check = false;
        
        //세션의 어드민이 널이면
        if(admin == null) {            
            check = false;
        }else {
        	if(admin) {
        		check = true;
        	}
        }
        
        //관리자가 아닐때
        if(!check) {
            request.setAttribute("message", "관리자 로그인이 필요합니다");
            request.setAttribute("url", "../../../../../../admin/login");
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp"); //jsp의 경로
            view.forward(request, response);
        }
        
        return check;
    }

}
