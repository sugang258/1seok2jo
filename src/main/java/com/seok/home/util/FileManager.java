package com.seok.home.util;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.seok.home.file.FileDTO;

@Component
public class FileManager {
	
		//delete
		public boolean deleteFile(ServletContext servletContext, String path, FileDTO fileDTO) throws Exception{
			String realPath = servletContext.getRealPath(path);
			System.out.println(realPath);
			
			File file = new File(realPath, fileDTO.getF_name());
			
			return file.delete();
		}
		
		//save
		public String saveFile(String path,ServletContext servletContext, MultipartFile multipartFile) throws Exception {
			String realPath = servletContext.getRealPath(path);
			
			System.out.println(realPath);
			
			//2. 폴더(directory) 체크
			File file = new File(realPath);
			
			if(!file.exists()) {
				file.mkdirs();
			}
			
			//3. 저장할 파일명 생성
			String fileName = UUID.randomUUID().toString();
			fileName = fileName + "_" + multipartFile.getOriginalFilename();
			
			//4.HDD에 저장
			file = new File(file, fileName);
			multipartFile.transferTo(file);
			
			return fileName;
		}

}
