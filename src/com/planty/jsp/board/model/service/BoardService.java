package com.greedy.jsp.board.model.service;

import static com.greedy.jsp.common.mybatis.Template.getSqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.greedy.jsp.board.model.dao.BoardDAO;
import com.greedy.jsp.board.model.dto.AttachmentDTO;
import com.greedy.jsp.board.model.dto.BoardDTO;
import com.greedy.jsp.common.paging.Pagenation;
import com.greedy.jsp.common.paging.SelectCriteria;

public class BoardService {
	
	private final BoardDAO boardDAO;
	
	public BoardService() {
		boardDAO = new BoardDAO();
	}
	
	
	/* 게시물 전체 조회용 메소드 */
	public Map<String, Object> selectBoardList(int pageNo, Map<String, String> searchMap) {
		
		SqlSession session = getSqlSession();
		
		int totalCount = boardDAO.selectTotalCount(session, searchMap);
		System.out.println("totalBoardCount : " + totalCount);
		
		/* 한 페이지에 보여 줄 게시물 수 */
		int limit = 10;		
		/* 한 번에 보여질 페이징 버튼의 갯수 */
		int buttonAmount = 5;
		
		/* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */
		SelectCriteria selectCriteria = null;
		
		if(searchMap.get("searchCondition") != null && !"".equals(searchMap.get("searchCondition"))) {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchMap.get("searchCondition"), searchMap.get("searchValue"));
		} else {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}
		
		System.out.println(selectCriteria);
		
		List<BoardDTO> boardList = boardDAO.selectBoardList(session, selectCriteria);
		
		Map<String, Object> returnMap = new HashMap<>();
		returnMap.put("boardList", boardList);
		returnMap.put("selectCriteria", selectCriteria);
		
		session.close();
		
		return returnMap;
	}
	
	/* 신규 게시물 등록용 메소드 */
	public int insertBoard(BoardDTO newBoard) {
		
		SqlSession session = getSqlSession();
		
		int result = boardDAO.insertBoard(session, newBoard);
		
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
	}
	
	/* 썸네일 게시판 조회용 메소드 */
	public List<BoardDTO> selectThumbnailList() {
		
		/* Connection 생성 */
		SqlSession session = getSqlSession();
		
		/* List 조회 */
		List<BoardDTO> thumbnailList = boardDAO.selectThumbnailList(session);
		
		/* Connection 닫기 */
		session.close();
		
		/* 조회 결과 반환 */
		return thumbnailList;
	}
	
	public int insertThumbnail(BoardDTO thumbnail) {
		
		/* Connection 생성 */
		SqlSession session = getSqlSession();
		
		/* 최종적으로 반환할 result 선언 */
		int result = 0;
		
		/* 먼저 board 테이블부터 thumbnail 내용부터 insert 한다. */
		int boardResult = boardDAO.insertThumbnailContent(session, thumbnail);
		
		System.out.println("boardResult : " + thumbnail);
	
		/* Attachment 리스트를 불러온다. */
		List<AttachmentDTO> fileList = thumbnail.getAttachmentList();
		
		/* fileList에 boardNo값을 넣는다. */
		for(int i = 0; i < fileList.size(); i++) {
			fileList.get(i).setRefBoardNo(thumbnail.getNo());
		}
		
		/* Attachment 테이블에 list size만큼 insert 한다. */
		int attachmentResult = 0;
		for(int i = 0; i < fileList.size(); i++) {
			attachmentResult += boardDAO.insertAttachment(session, fileList.get(i));
		}
		
		/* 모든 결과가 성공이면 트랜젝션을 완료한다. */
		if(boardResult > 0 && attachmentResult == fileList.size()) {
			session.commit();
			result = 1;
		} else {
			session.rollback();
		}
		
		/* Connection을 닫는다. */
		session.close();
		
		/* 수행 결과를 리턴한다. */
		return result;
	}

	public BoardDTO selectOneThumbnailBoard(int no) {
		
		SqlSession session = getSqlSession();
		
		BoardDTO thumbnail= null;
		
		int result = boardDAO.incrementBoardCount(session, no);
		
		if(result > 0) {
			thumbnail = boardDAO.selectOneThumbnailBoard(session, no);
			
			if(thumbnail != null) {
				session.commit();
			} else {
				session.rollback();
			}
		} else {
			session.rollback();
		}
		
		session.close();
		
		return thumbnail;
		
	}

}
