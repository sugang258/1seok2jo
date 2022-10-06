package com.seok.home.lecture;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.seok.home.lecture.add.LectureAddDAO;
import com.seok.home.lecture.add.LectureAddDTO;
import com.seok.home.lecture.status.StatusDAO;
import com.seok.home.lecture.status.StatusDTO;
import com.seok.home.util.FileManager;
import com.seok.home.util.Pager;

@Service
public class LectureService {

	@Autowired
	private LectureDAO lectureDAO;
	@Autowired
	private FileManager fileManager;
	@Autowired
	private LectureAddDAO lectureAddDAO;
	@Autowired
	private StatusDAO statusDAO;
	
	public List<LectureDTO> getLecture(Pager pager) throws Exception {
		System.out.println(pager.getPage());
		System.out.println("seaaaa :"+pager.getSearch());
		Long totalCount = lectureDAO.getCount(pager);
		pager.getNum(totalCount);
		pager.getRowNum();
		System.out.println(totalCount);
		return lectureDAO.getLecture(pager);
	}
	
	public int setLecture(LectureDTO lectureDTO,List<LectureFileDTO> files,/*String path,*//* MultipartFile[] files,*/ ServletContext servletContext,LectureVideoDTO lectureVideoDTO) throws Exception {
		int result = lectureDAO.setLecture(lectureDTO);
		//String path = "http://20.249.88.100/upload/lecture";
		
//		for(MultipartFile mf : files) {
//			if(mf.isEmpty()) {
//				continue;
//			}
		
//		System.out.println(mf.getSize());
//		String fileName = fileManager.saveFile(path, servletContext,mf);

		if(result == 1) {
			System.out.println("어레이리스트"+files.size());
			
			for(LectureFileDTO lf : files) {
				lf.setL_num(lectureDTO.getL_num());
				result = lectureDAO.setAddFile(lf);
				
				
				if(result!=1) {
					System.out.println("파일 추가 오류");
					break;
				}
			}
		}else {
			System.out.println("lecture에러");
		}
//		LectureFileDTO lectureFileDTO = new LectureFileDTO();
//		lectureFileDTO.setF_name(fileName);
//		lectureFileDTO.setF_oriname(mf.getOriginalFilename());
//		lectureFileDTO.setL_num(lectureDTO.getL_num());
//		lectureDAO.setAddFile(lectureFileDTO);
//		}
		String[] url =lectureVideoDTO.getV_url().split(",");
		String[] context = lectureVideoDTO.getV_context().split(",");
		for(int i=0; i<url.length; i++) {
			lectureVideoDTO.setL_num(lectureDTO.getL_num());
			lectureVideoDTO.setV_url(url[i]);
			lectureVideoDTO.setV_context(context[i]);
			lectureVideoDTO.setV_seq((long)i);
			lectureDAO.setAddVideo(lectureVideoDTO);
			
		}
		return result;
	}
	
	public LectureDTO getDetail(LectureDTO lectureDTO) throws Exception {
		
		return lectureDAO.getDetail(lectureDTO);
	}
	
	public LectureDTO getDetailVideo(LectureVideoDTO lectureVideoDTO) throws Exception {
		return lectureDAO.getDetailVideo(lectureVideoDTO);
	}
	
	public int setUpdate(LectureDTO lectureDTO,LectureVideoDTO lectureVideoDTO) throws Exception {
		
		Long seq=0L;
		
		int result = lectureDAO.setUpdate(lectureDTO);
		
		if(lectureVideoDTO.getV_url() != null) {
		    System.out.println("lectureVideoDTO :" +lectureVideoDTO);
		    System.out.println("lectureVideoDTO :" +lectureVideoDTO.getV_url());
    		lectureVideoDTO.setL_num(lectureDTO.getL_num());
    		//추가되는 비디오 순서 정해주기
    		List<LectureVideoDTO> ar = lectureDAO.getVideoDetails(lectureVideoDTO);
    		System.out.println("arrrr :" +ar.size());
    //		//마지막 SEQ 가져오기
        		for(int i=0; i<ar.size();i++) {
        			
        			System.out.println("seqqq:"+ar.get(i).getV_seq());
        			seq = ar.get(i).getV_seq();
        			
        		}
    		String[] url =lectureVideoDTO.getV_url().split(",");
    		String[] context = lectureVideoDTO.getV_context().split(",");
    		for(int i=0; i<url.length; i++) {
    			seq++;
    			lectureVideoDTO.setL_num(lectureDTO.getL_num());
    			lectureVideoDTO.setV_url(url[i]);
    			lectureVideoDTO.setV_context(context[i]);
    			lectureVideoDTO.setV_seq(seq+1);
    			lectureDAO.setAddVideo(lectureVideoDTO);
			}
    		lectureVideoDTO.setL_num(lectureDTO.getL_num());
    		lectureVideoDTO.setRowNum((long)url.length);
    		List<LectureVideoDTO> video = lectureDAO.getVideoCount(lectureVideoDTO);
    		StatusDTO statusDTO = new StatusDTO();
    		List<LectureAddDTO> list =  lectureAddDAO.getLectureList(lectureDTO);
    		System.out.println("list size "+list.size());
    		for (int i=0;i<list.size();i++) {
    		    for(int y=0;y<video.size();y++) {
    		        System.out.println(video.get(y).getV_num());
    		       statusDTO.setV_num(video.get(y).getV_num());
    		       statusDTO.setS_num(list.get(i).getS_num());
    		       statusDAO.setStatusAdd(statusDTO);
    		    }
    		}
    		
		}
		return result;
		
//		
		
		
		
		
	}
	
	public int setVideoDelete(LectureVideoDTO lectureVideoDTO) throws Exception {
		return lectureDAO.setVideoDelete(lectureVideoDTO);
	}
	
	//강의 삭제
	public int setDelete(LectureDTO lectureDTO) throws Exception {
		return lectureDAO.setDelete(lectureDTO);
	}
	
	public int setVideoDele(LectureDTO lectureDTO) throws Exception {
		return lectureDAO.setVideoDele(lectureDTO);
	}
	
	public int setFileDelete(LectureDTO lectureDTO) throws Exception {
		
		return lectureDAO.setFileDelete(lectureDTO);
		
	}
	
	//파일 업데이트
	public int setFileUpdate(LectureFileDTO lectureFileDTO, /*MultipartFile[] files,*/List<LectureFileDTO> files, ServletContext servletContext) throws Exception{
		LectureDTO lectureDTO = new LectureDTO();
		lectureFileDTO = lectureDAO.getFileDetail(lectureFileDTO);
//		String path = "http://20.249.88.100/upload/lecture";
//		
//		for(MultipartFile mf : files) {
//			if(mf.isEmpty()) {
//				continue;
//			}
		
//		System.out.println(mf.getSize());
//		String fileName = fileManager.saveFile(path, servletContext,mf);
//		lectureFileDTO.setF_name(fileName);
//		lectureFileDTO.setF_oriname(mf.getOriginalFilename());
//		
//	}
//		if(result == 1) {
//            System.out.println("어레이리스트"+files.size());
//            
		int result = 0;
		    for(LectureFileDTO lf : files) {
                lf.setL_num(lectureFileDTO.getL_num());
                result = lectureDAO.setFileUpdate(lf);
                result = 1;
                
//                if(result!=1) {
//                    System.out.println("파일 추가 오류");
//                    break;
//                }
//            }
//        }else {
//            System.out.println("lecture에러");
		    }
		// return lectureDAO.setFileUpdate(lectureFileDTO);
		return result;
		
	}
	
	public int setVideoUpdate(LectureVideoDTO lectureVideoDTO) throws Exception{
		
		return lectureDAO.setVideoUpdate(lectureVideoDTO);
	}
	
	public long getListCount(LectureDTO lectureDTO) throws Exception{
		return lectureDAO.getListCount(lectureDTO);
	}
	
	public LectureVideoDTO getLectureNext(LectureVideoDTO lectureVideoDTO) throws Exception{
		return lectureDAO.getLectureNext(lectureVideoDTO);
	}
	
	public LectureVideoDTO getLecturePre(LectureVideoDTO lectureVideoDTO) throws Exception{
		return lectureDAO.getLecturePre(lectureVideoDTO);
	}
	
	public LectureVideoDTO getVideoList(LectureVideoDTO lectureVideoDTO) throws Exception{
		return lectureDAO.getVideoList(lectureVideoDTO);
	}
	public LectureDTO setTeacherCheck(LectureDTO lectureDTO) throws Exception{
	    return lectureDAO.setTeacherCheck(lectureDTO);
	}
	public List<LectureDTO> getTeacherLecture(LectureDTO lectureDTO) throws Exception{
	    return lectureDAO.getTeacherLecture(lectureDTO);
	}
}
