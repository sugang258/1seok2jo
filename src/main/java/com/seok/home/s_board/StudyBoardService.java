package com.seok.home.s_board;

import java.io.File;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.seok.home.b_comment.CommentDTO;
import com.seok.home.b_comment.CommentService;

@Service
public class StudyBoardService {

	@Autowired
	private StudyBoardDAO studyBoardDAO;
	
	public List<StudyBoardDTO> getBoardList(Pager pager)throws Exception{
		Long totalCount = studyBoardDAO.getTotalCount(pager);
		pager.getBlockNum(totalCount);
		pager.getRowNum();
		return studyBoardDAO.getBoardList(pager);
	}
	
	public StudyBoardDTO getBoardDetail(StudyBoardDTO studyBoardDTO)throws Exception{
		studyBoardDAO.setBoardHit(studyBoardDTO);
		return studyBoardDAO.getBoardDetail(studyBoardDTO);
	}
	
	public int setBoardAdd(StudyBoardDTO studyBoardDTO, MultipartFile file, HttpSession session)throws Exception{
		int result = studyBoardDAO.setBoardAdd(studyBoardDTO);	
		
		//1)파일 저장 위치
		//resources/upload/board
		if(!file.isEmpty()) {
			//2)저장할 폴더의 실제 경로 반환(os기준)
			String realPath = session.getServletContext().getRealPath("resources/upload/board");
			System.out.println("realPath : "+realPath);
			
			//폴더가 없을 땐 만든다.
			File files = new File(realPath);
			if(!files.exists()) {
				files.mkdirs();
			}
			
			//4)파일을 저장할 때 중복되지 않는 파일명을 만들어줘야함.
			String fileName = UUID.randomUUID().toString();
			
			//뒤에 확장자를 붙이게끔 만들어준다.
			fileName = fileName+"_"+file.getOriginalFilename();
			System.out.println("fileName : "+ fileName);
			
			//5)HDD에 파일 저장
			files = new File(files, fileName);
			
			//MultipartFile클래스의 transferTo메서드를 사용
			file.transferTo(files);
			
			//저장된 파일 정보를 DB에 저장
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setF_name(fileName);
			boardFileDTO.setF_oriname(file.getOriginalFilename());
			boardFileDTO.setSb_num(studyBoardDTO.getSb_num());
			int count  = studyBoardDAO.setBoardFile(boardFileDTO);
		}
		
		return result;
	}
	
	public int setBoardDelete(StudyBoardDTO studyBoardDTO)throws Exception{
		return studyBoardDAO.setBoardDelete(studyBoardDTO);
	}
	
	public int setBoardUpdate(StudyBoardDTO studyBoardDTO)throws Exception{
		return studyBoardDAO.setBoardUpdate(studyBoardDTO);
	}
	
	//댓글 수 
	public Long getCount(StudyBoardDTO studyBoardDTO)throws Exception{
		return studyBoardDAO.getCount(studyBoardDTO);
	}
	

}
