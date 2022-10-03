package com.seok.home.n_board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.seok.home.b_comment.NoticeReplyDTO;

@Repository
public class NoticeDAO {
	
	@Autowired
	private SqlSession session;
	private String NAMESPACE="com.seok.home.n_board.NoticeDAO.";
	
	/* 공지사항 목록 */
	public List<NoticeDTO> getNoticeList()throws Exception{
		return session.selectList(NAMESPACE+"getNoticeList");
	}
	
	/* 공지사항 상세보기 */
	public NoticeDTO getNoticeDetail(NoticeDTO noticeDTO)throws Exception{
		return session.selectOne(NAMESPACE+"getNoticeDetail", noticeDTO);
	}

	/* 공지사항 글작성 */
	public int setNoticeAdd(NoticeDTO noticeDTO)throws Exception {
		return session.insert(NAMESPACE+"setNoticeAdd", noticeDTO);
	}
	
	/* 공지사항 글수정 */
	public int setNoticeUpdate(NoticeDTO noticeDTO)throws Exception {
		return session.update(NAMESPACE+"setNoticeUpdate", noticeDTO);
	}
	
	/* 공지사항 글삭제 */
	public int setNoticeDelete(NoticeDTO noticeDTO)throws Exception {
		return session.delete(NAMESPACE+"setNoticeDelete", noticeDTO);
	}
	
	/* 공지사항 댓글목록 */
	public List<NoticeReplyDTO> getReplyList(NoticeReplyDTO noticeReplyDTO)throws Exception{
		return session.selectList(NAMESPACE+"getReplyList", noticeReplyDTO);
	}

}
