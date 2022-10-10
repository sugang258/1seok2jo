package com.seok.home.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.seok.home.member.MemberDTO;
import com.seok.home.member.RoleDTO;

public class TeacherCheckInterceptor extends HandlerInterceptorAdapter{
    
    //강사인지 아닌지 체크
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        
        HttpSession session = request.getSession();
        MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
        
        boolean check = false;
        
        for(RoleDTO roleDTO : memberDTO.getRoleDTOs()) {
            System.out.println(roleDTO.getRoleNum());
            System.out.println(roleDTO.getRoleName());
            
            if(roleDTO.getRoleName().equals("teacher")) {
                check = true;
                break;
            }
        }
        
        //강사가 아닐때
        if(!check) {
            request.setAttribute("messeage", "강사가 아닙니다");
            request.setAttribute("url", "../../../../../../");
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp"); //jsp의 경로
            view.forward(request, response);
        }
        
        return check;
    }

}
