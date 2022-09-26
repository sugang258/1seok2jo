package com.seok.home.lecture;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.seok.home.util.FileManager;
import com.seok.home.util.Pager;

@Service
public class LectureService {

	@Autowired
	private LectureDAO lectureDAO;
	@Autowired
	private FileManager fileManager;
	
	public List<LectureDTO> getLecture(Pager pager) throws Exception {
		System.out.println(pager.getPage());
		System.out.println("seaaaa :"+pager.getSearch());
		Long totalCount = lectureDAO.getCount(pager);
		pager.getNum(totalCount);
		pager.getRowNum();
		System.out.println(totalCount);
		return lectureDAO.getLecture(pager);
	}
	
	public int setLecture(LectureDTO lectureDTO, MultipartFile[] files, ServletContext servletContext,LectureVideoDTO lectureVideoDTO) throws Exception {
		int result = lectureDAO.setLecture(lectureDTO);
		String path = "resources/upload/lecture";
		
		for(MultipartFile mf : files) {
			if(mf.isEmpty()) {
				continue;
			}
		
		System.out.println(mf.getSize());
		String fileName = fileManager.saveFile(path, servletContext,mf);

		LectureFileDTO lectureFileDTO = new LectureFileDTO();
		lectureFileDTO.setF_name(fileName);
		lectureFileDTO.setF_oriname(mf.getOriginalFilename());
		lectureFileDTO.setL_num(lectureDTO.getL_num());
		lectureDAO.setAddFile(lectureFileDTO);
		}
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
		
		lectureVideoDTO.setL_num(lectureDTO.getL_num());
		List<LectureVideoDTO> ar = lectureDAO.getVideoDetails(lectureVideoDTO);
		System.out.println("arrrr :" +ar.size());
//		//마지막 SEQ 가져오기
		for(int i=0; i<ar.size();i++) {
			
			System.out.println("seqqq:"+ar.get(i).getV_seq());
			seq = ar.get(i).getV_seq();
			
		}
		if(lectureVideoDTO != null) {
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
	public int setFileUpdate(LectureFileDTO lectureFileDTO, MultipartFile[] files, ServletContext servletContext) throws Exception{
		
		lectureFileDTO = lectureDAO.getFileDetail(lectureFileDTO);
		String path = "resources/upload/lecture";
		
		for(MultipartFile mf : files) {
			if(mf.isEmpty()) {
				continue;
			}
		
		System.out.println(mf.getSize());
		String fileName = fileManager.saveFile(path, servletContext,mf);
		lectureFileDTO.setF_name(fileName);
		lectureFileDTO.setF_oriname(mf.getOriginalFilename());
		
	}
		 return lectureDAO.setFileUpdate(lectureFileDTO);
		
		
	}
	
	public int setVideoUpdate(LectureVideoDTO lectureVideoDTO) throws Exception{
		
		return lectureDAO.setVideoUpdate(lectureVideoDTO);
	}
	
	public long getListCount(LectureDTO lectureDTO) throws Exception{
		return lectureDAO.getListCount(lectureDTO);
	}
}
