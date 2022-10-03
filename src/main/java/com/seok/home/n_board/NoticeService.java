package com.seok.home.n_board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seok.home.b_comment.NoticeReplyDTO;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	/* 공지사항 목록 */
	public List<NoticeDTO> getNoticeList()throws Exception{
		return noticeDAO.getNoticeList();
	}
	
	/* 공지사항 상세보기 */
	public NoticeDTO getNoticeDetail(NoticeDTO noticeDTO)throws Exception{
		return noticeDAO.getNoticeDetail(noticeDTO);
	}
	
	/* 공지사항 글작성 */
	public int setNoticeAdd(NoticeDTO noticeDTO)throws Exception {
		return noticeDAO.setNoticeAdd(noticeDTO);
	}
	
	/* 공지사항 글수정 */
	public int setNoticeUpdate(NoticeDTO noticeDTO)throws Exception {
		return noticeDAO.setNoticeUpdate(noticeDTO);
	}
	
	/* 공지사항 글삭제 */
	public int setNoticeDelete(NoticeDTO noticeDTO)throws Exception {
		return noticeDAO.setNoticeDelete(noticeDTO);
	}
	
	/* 공지사항 댓글목록 */
	public List<NoticeReplyDTO> getReplyList(NoticeReplyDTO noticeReplyDTO)throws Exception{
		return noticeDAO.getReplyList(noticeReplyDTO);
	}
	
	/* 공지사항 댓글작성 */
	public int setReplyAdd(NoticeReplyDTO noticeReplyDTO)throws Exception{
		return noticeDAO.setReplyAdd(noticeReplyDTO);
	}
	
	/* 공지사항 댓글삭제 */
	public int setReplyDelete(NoticeReplyDTO noticeReplyDTO)throws Exception{
		return noticeDAO.setReplyDelete(noticeReplyDTO);
	}

}
