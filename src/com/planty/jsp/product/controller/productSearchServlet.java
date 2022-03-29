package com.planty.jsp.product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.planty.jsp.board.model.dto.BoardDTO;
import com.planty.jsp.board.model.service.BoardService;

@WebServlet("/product/search")
public class productSearchServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BoardService boardService = new BoardService();
		
		List<BoardDTO> productList = boardService.selectProductList();
		
		for(BoardDTO board : productList) {
			System.out.println(board);
		}
		
		String path = "";
		if(productList != null) {
			path = "/WEB-INF/views/product/productSerach.jsp";
			request.setAttribute("productList", productList);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "게시판 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
