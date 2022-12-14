package com.seok.home.n_board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.seok.home.b_comment.NoticeReplyDTO;
import com.seok.home.s_board.Pager;

@Repository
public class NoticeDAO {
	
	@Autowired
	private SqlSession session;
	private String NAMESPACE="com.seok.home.n_board.NoticeDAO.";
	
	/* 공지사항 목록 */
	public List<NoticeDTO> getNoticeList(Pager pager)throws Exception{
		return session.selectList(NAMESPACE+"getNoticeList", pager);
	}
	
	/* 공지사항 총글수 */
	public Long getTotalCount(Pager pager)throws Exception{
		return session.selectOne(NAMESPACE+"getTotalCount", pager);
	}
	
	/* 공지사항 상세보기 */
	public NoticeDTO getNoticeDetail(NoticeDTO noticeDTO)throws Exception{
		return session.selectOne(NAMESPACE+"getNoticeDetail", noticeDTO);
	}
	
	/* 공지사항 댓글수 */
	public Long getReplyCount(NoticeReplyDTO noticeReplyDTO)throws Exception{
		return session.selectOne(NAMESPACE+"getReplyCount", noticeReplyDTO);
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
	
	/* 공지사항 댓글작성 */
	public int setReplyAdd(NoticeReplyDTO noticeReplyDTO)throws Exception{
		return session.insert(NAMESPACE+"setReplyAdd", noticeReplyDTO);
	}
	
	/* 공지사항 댓글삭제 */
	public int setReplyDelete(NoticeReplyDTO noticeReplyDTO)throws Exception{
		return session.delete(NAMESPACE+"setReplyDelete", noticeReplyDTO);
	}

}
