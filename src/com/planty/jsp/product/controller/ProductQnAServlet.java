package com.planty.jsp.product.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.planty.jsp.product.model.dto.ProductDTO;
import com.planty.jsp.product.model.dto.QnaDTO;
import com.planty.jsp.product.model.service.ProductService;
import com.planty.jsp.review.model.dto.ReviewDTO;

/**
 * Servlet implementation class ProductQnAServlet
 */
@WebServlet("/product/qna")
public class ProductQnAServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pro_no = Integer.parseInt(request.getParameter("pro_no"));
		
		ProductDTO product = new ProductService().selectOneProduct(pro_no);
		System.out.println(product);
		
		List<QnaDTO> qna = new ArrayList<QnaDTO>();
		qna = new ProductService().selectProductQnaList(pro_no); 
		System.out.println(qna);
		
		String path = "";
		if(product != null && qna != null) {
			path = "/WEB-INF/views/product/productQna.jsp";
			request.setAttribute("product", product);
			request.setAttribute("qnaList", qna);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "상품 상세 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
