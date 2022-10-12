package com.seok.home.lecture;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.YamlProcessor.ResolutionMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import com.seok.home.lecture.add.LectureAddDTO;
import com.seok.home.lecture.add.LectureAddService;
import com.seok.home.lecture.status.StatusDTO;
import com.seok.home.lecture.status.StatusService;
import com.seok.home.lecture.teacher.TeacherDTO;
import com.seok.home.lecture.teacher.TeacherService;
import com.seok.home.member.MemberDTO;
import com.seok.home.member.RoleDTO;
import com.seok.home.util.Pager;
import com.seok.home.vm.TestFileDTO;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;


@Controller
@RequestMapping(value="/lecture/*")
public class LectureController {

	@Autowired
	private LectureService lectureService;
	@Autowired
	private LectureAddService lectureAddService;
	@Autowired
	private StatusService statusService;
	@Autowired
	private TeacherService teacherService;
	
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public ModelAndView getLecture(ModelAndView mv,LectureDTO lectureDTO,Pager pager) throws Exception {
		
		List<LectureDTO> ar = lectureService.getLecture(pager);
		System.out.println("ar : "+ar.size());
		System.out.println("search :"+pager.getSearch());
		System.out.println(pager.getStartRow());
		System.out.println(pager.getLastRow());
		System.out.println(pager.getKind());
		mv.addObject("list", ar);
		mv.addObject("Pager", pager);
		
		mv.setViewName("lecture/list");
		
		return mv;
	}
	
	@RequestMapping(value="add", method=RequestMethod.GET)
	public String setLecture() throws Exception {
		System.out.println("강의 추가 GET");
		return "lecture/add";
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public ModelAndView setLecture(LectureDTO lectureDTO,String f_name, String oriname, HttpServletRequest request, HttpSession session,/* MultipartFile[] files,*/LectureVideoDTO lectureVideoDTO) throws Exception {
		System.out.println("강의 추가 POST");
		
		System.out.println("fileDTO_FNAME : "+f_name);
		System.out.println("fileDTO_ORINAME : "+oriname);
		
		MemberDTO mem = (MemberDTO)request.getSession().getAttribute("member");
		ModelAndView mv = new ModelAndView();
		lectureDTO.setId(mem.getId());
		
//		String [] f_names = f_name.split(",");
//		String [] orinames = oriname.split(",");
//		
		List<LectureFileDTO> files = new ArrayList<LectureFileDTO>();
		LectureFileDTO lectureFileDTO = new LectureFileDTO();

		lectureFileDTO.setF_name(f_name);
		lectureFileDTO.setF_oriname(oriname);
		files.add(lectureFileDTO);
		
//		for(int i=0; i<orinames.length; i++) {
//			LectureFileDTO lectureFileDTO = new LectureFileDTO();
//			
//			lectureFileDTO.setF_name(f_names[i]);
//			lectureFileDTO.setF_oriname(orinames[i]);
//			files.add(lectureFileDTO);
//		}
		
		int result = lectureService.setLecture(lectureDTO,files, session.getServletContext(),lectureVideoDTO);
		session.setAttribute("add", lectureDTO);
		mv.addObject("result", result);
		mv.setViewName("redirect:./list");
		
		return mv;
	}
	
	@GetMapping("detail")
	@ResponseBody
	public ModelAndView getDetail(LectureDTO lectureDTO,HttpServletRequest request, HttpSession session) throws Exception {
		System.out.println("detail");
		MemberDTO mem = (MemberDTO)request.getSession().getAttribute("member");
		System.out.println(lectureDTO.getL_num());
		lectureDTO = lectureService.getDetail(lectureDTO);
		long count = lectureService.getListCount(lectureDTO);
		System.out.println(lectureDTO);
		List<LectureVideoDTO> ar  = lectureDTO.getLectureVideoDTO();
		List<LectureFileDTO> file = lectureDTO.getLectureFileDTO();
		System.out.println("ar : "+ar.size());
		System.out.println("file : "+ file.size());
		System.out.println("count : "+count);
//		lectureAddDTO.setId(mem.getId());
//		lectureAddDTO.setL_num(lectureDTO.getL_num());
//		lectureAddDTO = lectureAddService.getLectureAdd(lectureAddDTO);
		
		//List<LectureDTO> ar = lectureService.getDetailVideo(lectureDTO);
		ModelAndView mv = new ModelAndView();
		session.setAttribute("num", lectureDTO.getL_num());
		session.setAttribute("detail", lectureDTO);
		//session.setAttribute("sign", lectureAddDTO);
		mv.addObject("count", count);
		mv.addObject("detail", lectureDTO);
		mv.addObject("ar", ar);
		mv.addObject("file", file);
		//mv.addObject("video", ar);
		mv.setViewName("/lecture/detail");
		return mv;
	}
	
	@GetMapping("update")
	public ModelAndView setUpdate(LectureDTO lectureDTO,HttpSession session) throws Exception {
		
		System.out.println("update");
		ModelAndView mv = new ModelAndView();
		
		lectureDTO = (LectureDTO) session.getAttribute("detail");
	    //lectureDTO = lectureService.getDetail(lectureDTO);

		List<LectureVideoDTO> ar = lectureDTO.getLectureVideoDTO();
		System.out.println("video ar: "+ar.size());
		System.out.println("l_num : "+lectureDTO.getL_num());
		Long l_num = lectureDTO.getL_num();
		session.setAttribute("update", l_num);
		mv.addObject("video", ar);
		mv.addObject("update", lectureDTO);
		mv.setViewName("/lecture/update");
		//int result = lectureService.setUpdate(lectureDTO);
		
		return mv;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public ModelAndView setUpdate(LectureDTO lectureDTO, ModelAndView mv,MultipartFile[] files,HttpSession session,LectureVideoDTO lectureVideoDTO) throws Exception{
		System.out.println("update post");
		//System.out.println("l_nummmm"+lectureDTO.getL_num());
		System.out.println("VIDEO : "+lectureVideoDTO);
		lectureService.setUpdate(lectureDTO,lectureVideoDTO);
		mv.addObject("dto", lectureDTO);
		mv.setViewName("redirect:./detail?l_num="+lectureDTO.getL_num());
		
		return mv;
	}
	
	@PostMapping("setVideoDelete")
	@ResponseBody
	public int setVideoDelete(LectureVideoDTO lectureVideoDTO) throws Exception {
		System.out.println("동영상 삭제");
		
		int result = lectureService.setVideoDelete(lectureVideoDTO);
		
		return result;
	}
	
	@PostMapping("setDelete")
	@ResponseBody
	public int setDelete(LectureDTO lectureDTO,HttpServletRequest request) throws Exception {
		//실행시켜보기
		//status -> lecture_sign 
		System.out.println("delete");
		int result = 0;
		MemberDTO mem = (MemberDTO)request.getSession().getAttribute("member");

		LectureAddDTO lectureAddDTO = new LectureAddDTO();
		StatusDTO statusDTO = new StatusDTO();
		lectureAddDTO.setL_num(lectureDTO.getL_num());
		System.out.println(lectureAddDTO.getL_num());
		lectureDTO = lectureService.getDetail(lectureDTO);
		long s_count = lectureDTO.getL_count();
		System.out.println(s_count);
//		LectureVideoDTO lectureVideoDTO =new LectureVideoDTO();
//		lectureVideoDTO.setL_num(lectureDTO.getL_num());
		long v_count = lectureService.getListCount(lectureDTO);
		System.out.println(v_count);
		System.out.println(mem.getId());
		System.out.println(lectureDTO.getId());
		List<LectureAddDTO> ar = lectureAddService.getLectureSearch(lectureAddDTO);
		if(mem.getId().equals(lectureDTO.getId())) {
			
			for(int x=0;x<ar.size();x++) {
				statusDTO.setS_num(ar.get(x).getS_num());
				for(int i=0;i<s_count*v_count;i++) {
					//statusDTO S_NUM으로 다 삭제시키기
					statusService.setStatusDelete(statusDTO);
				}
			}
			lectureAddService.setLectureDeleteAll(lectureDTO);
			lectureService.setFileDelete(lectureDTO);
			lectureService.setVideoDele(lectureDTO);
			result = lectureService.setDelete(lectureDTO);
			
		}else {
			//어드민 권한이면 삭제하도록 한다.
			Boolean chk = (Boolean)request.getSession().getAttribute("admin");
			if(chk) {
				for(int x=0;x<ar.size();x++) {
					statusDTO.setS_num(ar.get(x).getS_num());
					for(int i=0;i<s_count*v_count;i++) {
						//statusDTO S_NUM으로 다 삭제시키기
						statusService.setStatusDelete(statusDTO);
					}
				}
				lectureAddService.setLectureDeleteAll(lectureDTO);
				lectureService.setFileDelete(lectureDTO);
				lectureService.setVideoDele(lectureDTO);
				result = lectureService.setDelete(lectureDTO);
			}else {
			result =0;
			}
		}
		System.out.println(result);
		return result;
	}
	
	@PostMapping("setFileUpdate")
	@ResponseBody
	public ModelAndView setFileUpdate(LectureDTO lectureDTO,/* MultipartFile[] files,*/String f_name, String oriname, HttpSession session) throws Exception{
		System.out.println("파일 업데이트");
		LectureFileDTO lectureFileDTO = new LectureFileDTO();
		
		lectureDTO = (LectureDTO) session.getAttribute("detail");
        
		
		System.out.println("fileDTO_FNAME : "+f_name);
        System.out.println("fileDTO_ORINAME : "+oriname);
        
        List<LectureFileDTO> files = new ArrayList<LectureFileDTO>();
		ModelAndView mv = new ModelAndView();
		
		lectureFileDTO.setF_name(f_name);
        lectureFileDTO.setF_oriname(oriname);
        files.add(lectureFileDTO);
        
        
		
		lectureDTO = (LectureDTO) session.getAttribute("detail");
		lectureFileDTO.setL_num(lectureDTO.getL_num());
		System.out.println(lectureFileDTO.getL_num());

		int result = lectureService.setFileUpdate(lectureFileDTO,files,session.getServletContext());
		
		//lectureService.setFileDelete(lectureDTO);
		
		
		mv.setViewName("redirect:./detail?l_num="+lectureDTO.getL_num());
		
		
		return mv;
		
	}
	
	@PostMapping("setVideoUpdate")
	@ResponseBody
	public int setVideoUpdate(LectureVideoDTO lectureVideoDTO) throws Exception{
		int result = lectureService.setVideoUpdate(lectureVideoDTO);
		return result;
	}
	
	@GetMapping("listen")
	public ModelAndView getDetailVideo(LectureAddDTO lectureAddDTO,HttpServletRequest request, LectureDTO lectureDTO, ModelAndView mv, HttpSession session) throws Exception{
		System.out.println("detailLecture");
		MemberDTO mem = (MemberDTO)request.getSession().getAttribute("member");
		//lectureAddDTO = (LectureAddDTO) session.getAttribute("sign");
		lectureDTO = lectureService.getDetail(lectureDTO);
		//lectureDTO = (LectureDTO) session.getAttribute("detail");
		//lectureDTO.setL_num((Long)session.getAttribute("num"));
		System.out.println(lectureDTO.getL_num());
		lectureAddDTO.setId(mem.getId());
		lectureAddDTO.setL_num(lectureDTO.getL_num());
		lectureAddDTO = lectureAddService.getLectureCancel(lectureAddDTO);
		long count = lectureService.getListCount(lectureDTO);
		System.out.println(lectureAddDTO);
		if(lectureAddDTO == null) {
		    mv.addObject("dto", lectureDTO);
		    mv.addObject("sign", lectureAddDTO);
		    mv.setViewName("/lecture/detail");
		}else {
		//System.out.println(lectureVideoDTO.getV_seq());
		List<LectureVideoDTO> video = lectureDTO.getLectureVideoDTO();
		List<LectureFileDTO> file = lectureDTO.getLectureFileDTO();
		
		//lectureAddDTO = lectureAddService.getLectureAdd(lectureAddDTO);
		StatusDTO statusDTO = new StatusDTO();
		
			statusDTO.setS_num(lectureAddDTO.getS_num());
			statusDTO.setV_num(video.get(0).getV_num());
			statusDTO = statusService.getStatus(statusDTO);
		
		
		System.out.println("video size" +video.size());
		//lectureVideoDTO.setV_seq(0L);
		//lectureVideoDTO.setL_num(lectureDTO.getL_num());
		//List<LectureVideoDTO> list = lectureService.getDetailVideo(lectureVideoDTO);
		session.setAttribute("status", statusDTO);
		mv.addObject("status", statusDTO);
		mv.addObject("sign", lectureAddDTO);
		mv.addObject("count", count);
		mv.addObject("video", video);
		mv.addObject("file", file);
		mv.addObject("dto", lectureDTO);
		//mv.addObject("list", list);
		mv.setViewName("/lecture/listen");
		
		}
		
		
		return mv;
	}
	
	//강의 이동
	@PostMapping("getLectureNext")
	@ResponseBody
	public LectureVideoDTO getLectureNext(LectureVideoDTO lectureVideoDTO,HttpSession session,StatusDTO statusDTO) throws Exception{
		System.out.println("next");
		ModelAndView mv = new ModelAndView();
		lectureVideoDTO = lectureService.getLectureNext(lectureVideoDTO);
		System.out.println(lectureVideoDTO);

		return lectureVideoDTO;
	}
	
	@PostMapping("getLecturePre")
	@ResponseBody
	public LectureVideoDTO getLecturePre(LectureVideoDTO lectureVideoDTO,HttpSession session,StatusDTO statusDTO) throws Exception{
		System.out.println("pre");
		ModelAndView mv = new ModelAndView();

		lectureVideoDTO = lectureService.getLecturePre(lectureVideoDTO);

		return lectureVideoDTO;
	}
	
	@PostMapping("getVideoList")
	@ResponseBody
	public LectureVideoDTO getVideoList(LectureVideoDTO lectureVideoDTO,HttpSession session,StatusDTO statusDTO) throws Exception{
		System.out.println("list");

		lectureVideoDTO = lectureService.getVideoList(lectureVideoDTO);
		
		return lectureVideoDTO;
	}
	
	@PostMapping("setTeacherCheck")
	@ResponseBody
	public int setTeacherCheck(LectureDTO lectureDTO, HttpServletRequest request) throws Exception{
	    System.out.println("Teacher check");
        MemberDTO mem = (MemberDTO)request.getSession().getAttribute("member");
        
        lectureDTO.setId(mem.getId());
        System.out.println("teacher id" +lectureDTO.getId());
        System.out.println(lectureDTO.getL_num());
        
        lectureDTO = lectureService.setTeacherCheck(lectureDTO);
        int result = 0;
        if(lectureDTO != null) {
            result = 1;
        }else {
            result = 0;
        }

	    return result;
	}
	
	@GetMapping("teacher")
	public ModelAndView getTeacherLecture(LectureDTO lectureDTO, HttpServletRequest request) throws Exception{
	    System.out.println("teacherLecture");
	    ModelAndView mv = new ModelAndView();
        MemberDTO mem = (MemberDTO)request.getSession().getAttribute("member");
        lectureDTO.setId(mem.getId());
        
        List<LectureDTO> ar = lectureService.getTeacherLecture(lectureDTO);
        
        mv.addObject("lecture", ar);
	    mv.setViewName("/lecture/teacher");
	    return mv;
	}
	
    @PostMapping("setTeacherLecture")
	@ResponseBody
	public int getTeacherLecture(TeacherDTO teacherDTO,HttpServletRequest request) throws Exception{
	    System.out.println("teacherLecturePOST");

	    int result = 0;
	    MemberDTO mem = (MemberDTO)request.getSession().getAttribute("member");
	    //로그인 안했을경우
	    if(mem != null) {
	    
	        teacherDTO.setId(mem.getId());
	        teacherDTO = teacherService.getTeacherCheck(teacherDTO);
	        System.out.println(teacherDTO);
	        
	        if(teacherDTO != null) {
	            result = 1;
	        }
	    }else {
	        result = 0;
	    }
	    
	    
	    return result;
	}
	
	@PostMapping("setLoginCheck")
	@ResponseBody
	public int setLoginCheck(HttpServletRequest request) throws Exception{
	    MemberDTO mem = (MemberDTO)request.getSession().getAttribute("member");
	    LectureAddDTO lectureAddDTO = new LectureAddDTO();
	    Date now = new Date();
	    java.sql.Date date1 = new java.sql.Date(now.getTime());
	    int result = 0;
	    if(mem == null) {
	        result = 0;
	    }else {
	        result = 1;
	        lectureAddDTO.setId(mem.getId());
	        List<LectureAddDTO> ar = lectureAddService.getLectureEnd(lectureAddDTO);
	        if(ar.size() != 0) {
	            for(int i=0;i<ar.size();i++) {
	                if(date1.after(ar.get(i).getS_end())) {
	                    System.out.println(ar.get(i).getS_num());
	                    lectureAddDTO.setL_num(ar.get(i).getL_num());
	                    lectureAddDTO.setS_num(ar.get(i).getS_num());
	                    lectureAddService.setLectureUpdate(lectureAddDTO);
	                    
	                    lectureAddService.setLectureCountM(lectureAddDTO);
	                    
	                }
	                
	            }
	            
	        }
	        
	    }

	    return result;
	}
	
	@PostMapping("list")
	public ModelAndView getLectureCate(Pager pager) throws Exception{
	    System.out.println("list post");
	    ModelAndView mv = new ModelAndView();
	    List<LectureDTO> ar = lectureService.getLectureCate(pager);
	    int result = 0;
	    if(ar.size() == 0) {
	        result = 0;
	    }else {
	        result = 1;
	    }
	    mv.addObject("list", ar);
	    mv.addObject("pager", pager);
	    mv.setViewName("lecture/category_list");
	    
	    return mv;

	}
	
	@PostMapping("recommend")
	public ModelAndView getLectureRecommend() throws Exception{
	    ModelAndView mv = new ModelAndView();
	    List<LectureDTO> ar = lectureService.getLectureRecommend();
	    
	    mv.addObject("list", ar);
	    mv.setViewName("lecture/category_list");

	    return mv;	    
	}

	
}
