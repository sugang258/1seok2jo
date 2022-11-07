package com.seok.home.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FrontErrorController {
	
//	@GetMapping("/*")
	public ModelAndView error404() throws Exception{
		ModelAndView mv = new ModelAndView();
        
        System.out.println("파일 경로 없음");
        mv.setViewName("errors/error_404");
        return mv;
	}
    
//    @GetMapping("/error/error400")
    public ModelAndView error400() throws Exception {
        ModelAndView mv = new ModelAndView();
        
        System.out.println("Parameter가 틀림");
        mv.setViewName("errors/error_404");
        return mv;
    }
    @GetMapping("/error/error500")
    public ModelAndView error500() throws Exception {
        ModelAndView mv = new ModelAndView();
        
        System.out.println("Server Exception발생");
        mv.setViewName("errors/error_500");
        return mv;
    }

}