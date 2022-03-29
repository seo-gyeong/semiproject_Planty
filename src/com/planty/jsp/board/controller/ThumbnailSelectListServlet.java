package com.greedy.jsp.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.jsp.board.model.dto.BoardDTO;
import com.greedy.jsp.board.model.service.BoardService;

@WebServlet("/thumbnail/list")
public class ThumbnailSelectListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BoardService boardService = new BoardService();
		
		List<BoardDTO> thumbnailList = boardService.selectThumbnailList();
		
		for(BoardDTO board : thumbnailList) {
			System.out.println(board);
		}
		
		String path = "";
		if(thumbnailList != null) {
			path = "/WEB-INF/views/thumbnail/thumbnailList.jsp";
			request.setAttribute("thumbnailList", thumbnailList);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "썸네일 게시판 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
