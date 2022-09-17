package com.seok.home.lecture;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.seok.home.util.FileManager;

@Service
public class LectureService {

	@Autowired
	private LectureDAO lectureDAO;
	@Autowired
	private FileManager fileManager;
	
	public List<LectureDTO> getLecture() throws Exception {
		
		return lectureDAO.getLecture();
	}
	
	public int setLecture(LectureDTO lectureDTO, MultipartFile[] files, ServletContext servletContext) throws Exception {
		int result = lectureDAO.setLecture(lectureDTO);
		String path = "resources/upload/lecture";
		
		for(MultipartFile mf : files) {
			if(mf.isEmpty()) {
				continue;
			}
		
		
		String fileName = fileManager.saveFile(path, servletContext,mf);

		LectureFileDTO lectureFileDTO = new LectureFileDTO();
		lectureFileDTO.setF_name(fileName);
		lectureFileDTO.setF_oriname(mf.getOriginalFilename());
		lectureFileDTO.setL_num(lectureDTO.getL_num());
		lectureDAO.setAddFile(lectureFileDTO);
		}
		return result;
	}
	
	
	
	
}
