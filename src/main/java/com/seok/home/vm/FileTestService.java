package com.seok.home.vm;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seok.home.file.FileDTO;
import com.seok.home.s_board.StudyBoardDTO;

@Service
public class FileTestService {
	
	@Autowired
	private FileTestDAO dao;
	
	public Long setBoardAdd(TestBoardDTO boardDTO, ArrayList<TestFileDTO> files)throws Exception{
		//borad DB에 저장
		int result = dao.setBoardAdd(boardDTO);
		
		//insert 가 되면
		if(result==1) {
			System.out.println("어레이리스트"+files.size());
			//파일 리스트를 파일 DB에 저장
			for(TestFileDTO file: files) {
				
				file.setSb_num(boardDTO.getSb_num());
				result = dao.setFileAdd(file);
				
				
				if(result!=1) {
					System.out.println("파일 추가 오류");
					break;
				}
				
			}
			
		}else {
			System.out.println("boardAdd 에러");
		}
		
		return boardDTO.getSb_num();
	}
	
	public TestBoardDTO getBoardDetail(TestBoardDTO boardDTO)throws Exception{
		return dao.getBoardDetail(boardDTO);
	}

}
