package com.greedy.jsp.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import com.greedy.jsp.board.model.dto.AttachmentDTO;
import com.greedy.jsp.board.model.dto.BoardDTO;
import com.greedy.jsp.common.paging.SelectCriteria;

public class BoardDAO {
	
	public int selectTotalCount(SqlSession session, Map<String, String> searchMap) {
		
		return session.selectOne("BoardDAO.selectTotalCount", searchMap);
	}

	public List<BoardDTO> selectBoardList(SqlSession session, SelectCriteria selectCriteria) {
		
		return session.selectList("BoardDAO.selectBoardList", selectCriteria);
	}

	public int insertBoard(SqlSession session, BoardDTO newBoard) {
		
		return session.insert("BoardDAO.insertBoard", newBoard);
	}
	
	/* 썸네일게시판 목록 조회용 메소드 */
	public List<BoardDTO> selectThumbnailList(SqlSession session) {
		
		return session.selectList("BoardDAO.selectThumbnailList");
	}
	
	/* 썸네일 제목과 내용 insert용 메소드 */
	public int insertThumbnailContent(SqlSession session, BoardDTO thumbnail) {
		
		return session.insert("BoardDAO.insertThumbnailContent", thumbnail);
	}
	
	/* Attachment 테이블에 insert */
	public int insertAttachment(SqlSession session, AttachmentDTO file) {
		
		return session.insert("BoardDAO.insertAttachment", file);
	}
	
	public int incrementBoardCount(SqlSession session, int no) {
		
		return session.update("BoardDAO.incrementBoardCount", no);
	}

	public BoardDTO selectOneThumbnailBoard(SqlSession session, int no) {
		
		return session.selectOne("BoardDAO.selectOneThumbnailBoard", no);
	}

}
